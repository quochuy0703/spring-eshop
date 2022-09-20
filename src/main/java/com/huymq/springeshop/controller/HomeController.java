package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
import com.huymq.springeshop.entity.Review;
import com.huymq.springeshop.entity.SunglassesProperty;
import com.huymq.springeshop.entity.WatchProperty;
import com.huymq.springeshop.service.MultiService;
import com.huymq.springeshop.utils.AddToCartForm;
import com.huymq.springeshop.utils.CustomAuthentication;
import com.huymq.springeshop.utils.FilesStorageService;
import com.huymq.springeshop.utils.MessageResponse;
import com.huymq.springeshop.utils.ReviewForm;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CustomAuthentication customAuthentication;

    @Autowired
    private MultiService multiService;
    

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
        List<Product> listTop3CountSale = multiService.findProductsTop3ByOrderByCountSaleDesc();
        List<Product> listTop3CountSeen = multiService.findProductsTop3ByOrderByCountSeenDesc();

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
        theModel.addAttribute("listTop3CountSale", listTop3CountSale);
        theModel.addAttribute("listTop3CountSeen", listTop3CountSeen);
        

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
    public String showDetailPage(@PathVariable("productId") UUID theId,Model theModel,HttpServletRequest request){

        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();


        Product thisProduct = multiService.findProductByUUID(theId);
        System.out.println(thisProduct);
        thisProduct.setCountSeen(thisProduct.getCountSeen()+1);
        multiService.saveProduct(thisProduct);



        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }

            ReviewForm reviewForm = new ReviewForm();
            reviewForm.setProductId(thisProduct.getId());
            reviewForm.setStar(3);

            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            theModel.addAttribute("reviewForm", reviewForm);
            
        }



        

        Page<Product> theList  = multiService.findProductByType(thisProduct.getProductType(), PageRequest.of(0, 3));
        
        
        AddToCartForm cartForm = new AddToCartForm();
        cartForm.setQuantity(1);

        int avgStar = 0;

        if(thisProduct.getReviews().size() != 0){
            avgStar = (thisProduct.getStarOne()*1+thisProduct.getStarTwo()*2+
                    thisProduct.getStarThree()*4+thisProduct.getStarFour()*4+
                    thisProduct.getStarFive()*5)/thisProduct.getReviews().size();
        }


       


        theModel.addAttribute("thisProduct", thisProduct);
        theModel.addAttribute("listNew", theList.getContent());
        theModel.addAttribute("cartForm", cartForm);
        theModel.addAttribute("avgStar", avgStar);
        




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

    @PostMapping("/products/review/add")
    public String processAddReview(@ModelAttribute("reviewForm") ReviewForm reviewForm,Model theModel,HttpServletRequest request){

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


        System.out.println("review "+reviewForm.getProductId());

        Product thisProduct = multiService.findProductById(reviewForm.getProductId());

        Review review = new Review();
        review.setContent(reviewForm.getContent());
        review.setStar(reviewForm.getStar());
        switch(reviewForm.getStar()){
            case 1:
                thisProduct.setStarOne(thisProduct.getStarOne()+1);
                break;
            case 2:
                thisProduct.setStarTwo(thisProduct.getStarTwo()+1);
                break;
            case 3:
                thisProduct.setStarThree(thisProduct.getStarThree()+1);
                break;
            case 4:
                thisProduct.setStarFour(thisProduct.getStarFour()+1);
                break;
            case 5:
                thisProduct.setStarFive(thisProduct.getStarFive()+1);
                break;
   
            
        }

    
        thisProduct.addReview(review);
        theCustomer.addReview(review);
        multiService.saveProduct(thisProduct);

        Page<Product> theList  = multiService.findProductByType(thisProduct.getProductType(), PageRequest.of(0, 3));
        
        
        AddToCartForm cartForm = new AddToCartForm();
            cartForm.setQuantity(1);
        
        theModel.addAttribute("thisProduct", thisProduct);
        theModel.addAttribute("listNew", theList.getContent());
        theModel.addAttribute("cartForm", cartForm);

        return "redirect:/products/"+thisProduct.getId();
    }

}
