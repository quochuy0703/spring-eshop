package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.service.MultiService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private MultiService multiService;

    @GetMapping("")
    public String showHomePage(Model theModel){
        List<Product> theList  = multiService.findAllNewProduct();

        List<List<Product>> list = new ArrayList<>();

        int index = 0;
        List<Product> tempList = new ArrayList<>();
        for(Product product: theList){
            if(index%4==0){
                tempList = new ArrayList<>();
                list.add(tempList);
            }
            tempList.add(product);
            index++;
        }
        
        theModel.addAttribute("lists", list);
        theModel.addAttribute("listNew", theList);



        return "home";
    }

    @GetMapping("/products/{productId}")
    public String showDetailPage(@PathVariable("productId") int theId,Model theModel){
        List<Product> theList  = multiService.findAllNewProduct();

        List<List<Product>> list = new ArrayList<>();

        int index = 0;
        List<Product> tempList = new ArrayList<>();
        for(Product product: theList){
            if(index%4==0){
                tempList = new ArrayList<>();
                list.add(tempList);
            }
            tempList.add(product);
            index++;
        }
        
        theModel.addAttribute("thisProduct", multiService.findProductById(theId));
        theModel.addAttribute("lists", list);
        theModel.addAttribute("listNew", theList);



        return "product-detail";
    }

    @GetMapping("/products/cart")
    public String showCart(HttpServletRequest request, Model theModel){

        Customer theCustomer = (Customer)request.getAttribute("customer");

        theModel.addAttribute("user", theCustomer);
        return "cart";
    }


    @PostMapping("/products/cart")
    public String processCart(HttpServletRequest request, Model theModel){

        Customer theCustomer = (Customer)request.getAttribute("customer");

        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = multiService.findProductById(productId);
        if(product == null){
            return null;
        }

        
        for(Cart cart : theCustomer.getCarts()){
            if(cart.getProduct().getId() == productId){

                cart.setQuantity(cart.getQuantity()+1);
                multiService.saveCustomer(theCustomer);
                return "cart";
            }
        }

        Cart tempCart = new Cart();
        tempCart.setQuantity(1);
        tempCart.setProduct(product);
        theCustomer.addCart(tempCart);

        multiService.saveCustomer(theCustomer);

        

        return "cart";
    }
}
