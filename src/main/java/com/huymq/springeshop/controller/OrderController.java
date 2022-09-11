package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.OrderAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Order;
import com.huymq.springeshop.entity.OrderAddress;
import com.huymq.springeshop.entity.OrderItem;
import com.huymq.springeshop.entity.OrderStatus;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.service.MultiService;
import com.huymq.springeshop.utils.CheckoutForm;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MultiService multiService;
    
    @GetMapping("/checkout")
    public String showCheckoutPage(HttpServletRequest request, Model theModel){
        Customer theCustomer = (Customer)request.getAttribute("customer");
        
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }

        CheckoutForm checkoutForm = new CheckoutForm();
        checkoutForm.setEmail(theCustomer.getEmail());
        checkoutForm.setFirstName(theCustomer.getFirstName());
        checkoutForm.setLastName(theCustomer.getLastName());
        checkoutForm.setPhone("123456");


        checkoutForm.setAddress(theCustomer.getAddresses().get(0).getAddress());
        checkoutForm.setCity(theCustomer.getAddresses().get(0).getCity());
        checkoutForm.setState(theCustomer.getAddresses().get(0).getState());
        checkoutForm.setCountry(theCustomer.getAddresses().get(0).getCountry());
        checkoutForm.setZipCode(theCustomer.getAddresses().get(0).getZipCode());

        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("sumCost", sumCost);
        theModel.addAttribute("checkoutForm", checkoutForm);
        return "checkout";
    }


    @PostMapping("/checkout")
    public String processOrderPage(@ModelAttribute("checkoutForm") CheckoutForm checkoutForm, HttpServletRequest request, Model theModel){
        Customer theCustomer = (Customer)request.getAttribute("customer");
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }

        OrderAddress orderAddress = new OrderAddress(checkoutForm);

        Order order = new Order();
        order.setAmount(sumCost);
        order.setOrderAddress(orderAddress);
        order.setOrderStatus(OrderStatus.PAID.ordinal());
        
        theCustomer.addOrder(order);
        
        List<Product> listProduct = new ArrayList<>();

        for(Cart cart: theCustomer.getCarts()){
            OrderItem orderItem = new OrderItem();
            // orderItem.setProduct(cart.getProduct());
            cart.getProduct().addOrderItem(orderItem);
            cart.getProduct().setCountSale(cart.getProduct().getCountSale()+cart.getQuantity());
            listProduct.add(cart.getProduct());
            orderItem.setPrice(cart.getProduct().getPrice());
            orderItem.setQuantity(cart.getQuantity());
            order.addOrderItem(orderItem);
            // multiService.saveOrderItem(orderItem);
           
            
        }
        
        theCustomer.setCarts(new ArrayList<>());
        multiService.saveCustomer(theCustomer);

        for(Product product: listProduct){
            multiService.saveProduct(product);
        }


        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("sumCost", sumCost);
        theModel.addAttribute("thisOrder", order);
        return "order";
    }
}
