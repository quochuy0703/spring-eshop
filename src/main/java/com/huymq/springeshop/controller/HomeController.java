package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Image;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.entity.ProductForm;
import com.huymq.springeshop.entity.ProductJsonInterface;
import com.huymq.springeshop.entity.Review;
import com.huymq.springeshop.entity.Role;
import com.huymq.springeshop.entity.SunglassesProperty;
import com.huymq.springeshop.entity.UserLogin;
import com.huymq.springeshop.entity.WatchProperty;
import com.huymq.springeshop.service.MultiService;
import com.huymq.springeshop.utils.AddToCartForm;
import com.huymq.springeshop.utils.CustomAuthentication;
import com.huymq.springeshop.utils.FileStoreS3;
import com.huymq.springeshop.utils.FilesStorageService;
import com.huymq.springeshop.utils.MessageResponse;
import com.huymq.springeshop.utils.RegisterForm;
import com.huymq.springeshop.utils.ReviewForm;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CustomAuthentication customAuthentication;

    @Autowired
    private MultiService multiService;

    @Autowired
    private  PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private  AmazonS3 client;

    @Autowired
    private FileStoreS3 fileStoreS3;
    

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
        
        List<Product> theList  = multiService.findProductByNewItemOrHighlightOrIsBanner(true,true,true);
        
        List<Product> listTop3CountSale = multiService.findProductsTop3ByOrderByCountSaleDesc();
        List<Product> listTop3CountSeen = multiService.findProductsTop3ByOrderByCountSeenDesc();

        List<List<Product>> list = new ArrayList<>();
        List<Product> listNew = theList.stream().filter(product -> (product.getNewItem() == true)).collect(Collectors.toList());

        int index = 0;
        List<Product> tempList = new ArrayList<>();
        for(Product product: listNew){
            if(index%4==0){
                tempList = new ArrayList<>();
                list.add(tempList);
            }
            tempList.add(product);
            index++;
        }

        theModel.addAttribute("lists", list);
        theModel.addAttribute("listNew", theList.stream().filter(product -> (product.getNewItem() == true)).collect(Collectors.toList()));
        theModel.addAttribute("listHighlight", theList.stream().filter(product -> (product.getHighlight() == true)).collect(Collectors.toList()));
        theModel.addAttribute("listBanner", theList.stream().filter(product -> (product.isBanner() == true)).collect(Collectors.toList()));
        theModel.addAttribute("listTop3CountSale", listTop3CountSale);
        theModel.addAttribute("listTop3CountSeen", listTop3CountSeen);
        theModel.addAttribute("path", "home");



    
    List<Bucket> buckets = client.listBuckets();
        System.out.println("Your Amazon S3 buckets are:");
        for (Bucket b : buckets) {
            System.out.println("* " + b.getName());
            ListObjectsV2Result result = client.listObjectsV2(b.getName());
            List<S3ObjectSummary> objects = result.getObjectSummaries();
            for (S3ObjectSummary os : objects) {
                System.out.println("* " + os.getKey());
            }
            
            
        }

        

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

        List<Product> theList  = multiService.findAllNewProduct(true);

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
       

       
        theModel.addAttribute("listNew", theList.getContent());
        theModel.addAttribute("path", "type");



        return "show-type";
    }

    @GetMapping("/products/get")
    @ResponseBody
    public ResponseEntity<Object> getProductByType(@RequestParam("type") char type, @RequestParam("value") String value, @RequestParam("filter") String filter){
        
        List<ProductJsonInterface> list = null;

        if(filter.equals("price")){
            if(value.equals("1")){
                list = multiService.findProductJsonByProductTypeAndPriceBetween(type, 100.0, 200.0);
            }else if(value.equals("2")){
                list = multiService.findProductJsonByProductTypeAndPriceBetween(type,200.0, 400.0);
            }else if(value.equals("3")){
                list = multiService.findProductJsonByProductTypeAndPriceGreaterThan(type, 400.0);
            }
        }else if(filter.equals("brand")){
            list = multiService.findProductJsonByBrand( Integer.parseInt(value));
        }else if(filter.equals("search")){
            list = multiService.findProductJsonByWord( value);
        }
        
        

        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }


    @GetMapping("/register")
    public String showRegisterPage(HttpServletRequest request, Model theModel){
       
        RegisterForm register = new RegisterForm();

        theModel.addAttribute("user", register);
     
        return "registration";
    }

    @PostMapping("/register")
    public String processRegisterPage(@Valid @ModelAttribute("user") RegisterForm registerForm, BindingResult result, Model theModel ){
        if (result.hasErrors()) {
            
            return "registration";
        }
       if(registerForm.getConfirmPassword().equals(registerForm.getPassword())){
        String encodePassword = bCryptPasswordEncoder.encode(registerForm.getPassword());
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(registerForm.getEmail());
        userLogin.setPassword(encodePassword);
        Role role = multiService.findRoleByName("USER");
        
        userLogin.getRoles().add(role);

        Customer theCustomer = registerForm.getCustomer();

        multiService.saveUserLogin(userLogin);
        multiService.saveCustomer(theCustomer);
        
       }

       
     
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
