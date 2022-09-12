package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Image;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.entity.ProductForm;
import com.huymq.springeshop.entity.SunglassesProperty;
import com.huymq.springeshop.entity.WatchProperty;
import com.huymq.springeshop.service.MultiService;
import com.huymq.springeshop.utils.AddToCartForm;
import com.huymq.springeshop.utils.CustomAuthentication;
import com.huymq.springeshop.utils.FilesStorageService;
import com.huymq.springeshop.utils.MessageResponse;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CustomAuthentication customAuthentication;

    @Autowired
    private MultiService multiService;
    @Autowired
    private FilesStorageService storageService;

    @GetMapping("")
    public String showHomePage(HttpServletRequest request, Model theModel){
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }
            AddToCartForm cartForm = new AddToCartForm();
            cartForm.setQuantity(1);

            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            theModel.addAttribute("cartForm", cartForm);
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

        
        theModel.addAttribute("lists", list);
        theModel.addAttribute("listNew", theList);
        

        return "home";
    }


    @GetMapping("/list-view")
    public String showListViewPage(HttpServletRequest request, Model theModel){
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }
            AddToCartForm cartForm = new AddToCartForm();
            cartForm.setQuantity(1);

            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            theModel.addAttribute("cartForm", cartForm);
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

    
        theModel.addAttribute("lists", list);
        theModel.addAttribute("listNew", theList);

        return "four-col";
    }

    @GetMapping("/products/{productId}")
    public String showDetailPage(@PathVariable("productId") int theId,Model theModel,HttpServletRequest request){

        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }
            

            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            
        }



        Product thisProduct = multiService.findProductById(theId);
        thisProduct.setCountSeen(thisProduct.getCountSeen()+1);
        multiService.saveProduct(thisProduct);

        Page<Product> theList  = multiService.findProductByType(thisProduct.getProductType(), PageRequest.of(0, 3));
        
        
        AddToCartForm cartForm = new AddToCartForm();
            cartForm.setQuantity(1);
        
        theModel.addAttribute("thisProduct", thisProduct);
        theModel.addAttribute("listNew", theList.getContent());
        theModel.addAttribute("cartForm", cartForm);





        return "product-detail";
    }


    @GetMapping("/products/type/{type}")
    public String showWatchesPage(@PathVariable("type") char type,HttpServletRequest request, Model theModel){
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }
            AddToCartForm cartForm = new AddToCartForm();
            cartForm.setQuantity(1);

            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            theModel.addAttribute("cartForm", cartForm);
        }


        Page<Product> theList  = multiService.findProductByType(type, Pageable.unpaged());
       

        // List<List<Product>> list = new ArrayList<>();

        // int index = 0;
        // List<Product> tempList = new ArrayList<>();
        // for(Product product: theList){
        //     if(index%4==0){
        //         tempList = new ArrayList<>();
        //         list.add(tempList);
        //     }
        //     tempList.add(product);
        //     index++;
        // }

       
        // theModel.addAttribute("lists", list);
        theModel.addAttribute("listNew", theList.getContent());



        return "show-type";
    }


    @GetMapping("/register")
    public String showRegisterPage(HttpServletRequest request, Model theModel){
       
        List<Product> theList  = multiService.findAllNewProduct();

        theModel.addAttribute("listNew", theList);
     
        return "registration";
    }

    @GetMapping("/api/rest")
    @ResponseBody
    public ResponseEntity<MessageResponse> getMessage(){
        MessageResponse message = new MessageResponse();
        message.setMessage("Hello Client");
        message.setStatus(HttpStatus.OK.value());
        message.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);
    }


}
