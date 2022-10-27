package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.OrderAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Order;
import com.huymq.springeshop.entity.OrderAddress;
import com.huymq.springeshop.entity.OrderItem;
import com.huymq.springeshop.entity.OrderStatus;
import com.huymq.springeshop.entity.ProcessOrderDetail;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.service.MultiService;
import com.huymq.springeshop.utils.CheckoutForm;
import com.huymq.springeshop.utils.CustomAuthentication;
import com.huymq.springeshop.utils.MessageResponse;
import com.huymq.springeshop.utils.exception.OrderItemNotFoundException;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MultiService multiService;

    @Autowired
    private CustomAuthentication customAuthentication;
    
    @GetMapping("/checkout")
    public String showCheckoutPage(HttpServletRequest request, Model theModel){
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            
            

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

            //set discount
            double discount = 0.0;
            //set shipCost
            double shipCost = 0.0;

            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            theModel.addAttribute("shipCost", shipCost);
            theModel.addAttribute("discount",discount );
            theModel.addAttribute("finishPrice", sumCost- discount + shipCost);
            theModel.addAttribute("checkoutForm", checkoutForm);
        }
        
        
        return "checkout";
    }


    @PostMapping("/checkout")
    public String processOrderPage(@ModelAttribute("checkoutForm") CheckoutForm checkoutForm, HttpServletRequest request, Model theModel){
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            
            

            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }

            
            Order order = new Order();
            order.setAmount(sumCost);
        
            order.setPaid(true);
            
            theCustomer.addOrder(order);
            
            List<Product> listProduct = new ArrayList<>();
            List<Cart> cartTemps =  new ArrayList<>();
            cartTemps.addAll(theCustomer.getCarts());
            for(Cart cart: cartTemps){
                
                OrderItem orderItem = new OrderItem();
                // orderItem.setProduct(cart.getProduct());

                ProcessOrderDetail process = new ProcessOrderDetail();
                process.setOrderStatus(OrderStatus.UNPROCESSED);
                orderItem.addProcessOrderDetail(process);
                

                cart.getProduct().addOrderItem(orderItem);
                cart.getProduct().setCountSale(cart.getProduct().getCountSale()+cart.getQuantity());
                cart.getProduct().setItemInStock(cart.getProduct().getItemInStock() - cart.getQuantity());
                listProduct.add(cart.getProduct());
                orderItem.setPrice(cart.getProduct().getPrice());
                orderItem.setQuantity(cart.getQuantity());
                orderItem.setOrderStatus(OrderStatus.UNPROCESSED);
                checkoutForm.getOrderItem(orderItem);
                order.addOrderItem(orderItem);
                // multiService.saveOrderItem(orderItem);

                theCustomer.getCarts().remove(cart);
                
            }
            
            

            multiService.saveCustomer(theCustomer);

            for(Product product: listProduct){
                multiService.saveProduct(product);
            }


            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            theModel.addAttribute("thisOrder", order);
        }
        
        return "order";
    }


    @PutMapping("/receive/{orderId}")
    @ResponseBody
    public ResponseEntity<MessageResponse> processReceiveOrder(@PathVariable("orderId") int orderId, HttpServletRequest request){
        
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            
        }
        if(theCustomer ==  null){
            throw new OrderItemNotFoundException("Not found "+ orderId);
        }
        
        OrderItem orderItem = multiService.findOrderItemById(orderId);
        
        if(orderItem == null){
            
            throw new OrderItemNotFoundException("Not found "+ orderId);
        }

        if(!theCustomer.getEmail().equals(orderItem.getEmail())){
            throw new OrderItemNotFoundException("Not found "+ orderId);
        }

        
        
        ProcessOrderDetail process = new ProcessOrderDetail();
        

        if(orderItem.getOrderStatus() == OrderStatus.SHIPPED ){
            orderItem.setOrderStatus(OrderStatus.values()[orderItem.getOrderStatus().ordinal()+1] );
        }else if(orderItem.getOrderStatus() == OrderStatus.UNPROCESSED || orderItem.getOrderStatus() == OrderStatus.READY_TO_SHIP){
            orderItem.setOrderStatus(OrderStatus.IN_CANCEL );
        }
        
        process.setOrderStatus(orderItem.getOrderStatus());
        orderItem.addProcessOrderDetail(process);
        

        multiService.saveOrderItem(orderItem);


        MessageResponse message = new MessageResponse();
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Da xu ly");
        message.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);

       
    }
}
