package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Image;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.entity.ProductForm;
import com.huymq.springeshop.entity.SunglassesProperty;
import com.huymq.springeshop.entity.WatchProperty;
import com.huymq.springeshop.service.MultiService;
import com.huymq.springeshop.utils.FilesStorageService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private MultiService multiService;
    @Autowired
    private FilesStorageService storageService;

    @GetMapping("")
    public String showHomePage(HttpServletRequest request, Model theModel){
        Customer theCustomer = (Customer)request.getAttribute("customer");

        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }


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
        
        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("sumCost", sumCost);
        theModel.addAttribute("lists", list);
        theModel.addAttribute("listNew", theList);



        return "home";
    }

    @GetMapping("/products/{productId}")
    public String showDetailPage(@PathVariable("productId") int theId,Model theModel,HttpServletRequest request){

        Customer theCustomer = (Customer)request.getAttribute("customer");
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }

        


        List<Product> theList  = multiService.findAllNewProduct();
        Product thisProduct = multiService.findProductById(theId);
        System.out.println(thisProduct.getProductProperty());

      

        
        
        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("sumCost", sumCost);
        theModel.addAttribute("thisProduct", thisProduct);
        // theModel.addAttribute("thisProductProperty",thisProduct.getProductProperty());
        
        theModel.addAttribute("listNew", theList);



        return "product-detail";
    }

    
    @GetMapping("/register")
    public String showRegisterPage(HttpServletRequest request, Model theModel){
        Customer theCustomer = (Customer)request.getAttribute("customer");
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }

        List<Product> theList  = multiService.findAllNewProduct();

        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("listNew", theList);
        theModel.addAttribute("sumCost", sumCost);
        return "registration";
    }

    
}
