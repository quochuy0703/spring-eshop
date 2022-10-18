package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestBody;
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
import com.huymq.springeshop.utils.FilesStorageService;
import com.huymq.springeshop.utils.ICustomAuthentication;
import com.huymq.springeshop.utils.MessageResponse;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private MultiService multiService;

    @Autowired
    private ICustomAuthentication customAuthentication;

    @GetMapping("")
    public String showCart(HttpServletRequest request, Model theModel){

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


        return "cart";
    }


    @PostMapping("")
    public String processCart(@ModelAttribute("cartForm") AddToCartForm cartForm,HttpServletRequest request, Model theModel){

        Authentication authentication = customAuthentication.getAuthentication();
        Customer theCustomer = multiService.findCustomerByEmail(authentication.getName());
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }


        Product product = multiService.findProductByUUID(cartForm.getUuid());
        if(product == null){
            return null;
        }


        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("sumCost", sumCost);

        
        for(Cart cart : theCustomer.getCarts()){
            if(cart.getProduct().getUuid().equals(cartForm.getUuid()) ){

                cart.setQuantity(cart.getQuantity()+cartForm.getQuantity());
                multiService.saveCustomer(theCustomer);
                return "redirect:/cart";
            }
        }

        Cart tempCart = new Cart();
        tempCart.setQuantity(cartForm.getQuantity());
        tempCart.setProduct(product);
        theCustomer.addCart(tempCart);

        multiService.saveCustomer(theCustomer);

        

        return "redirect:/cart";
    }

    // @GetMapping(value = "/string", produces = MediaType.APPLICATION_XML_VALUE) neu muon tra ve xml
    @GetMapping("/string")
    @ResponseBody
    public List<Product> showString(){
        List<Product> theList  = multiService.findAllNewProduct(true);
        return theList;
    }

    @PutMapping("/delete/{cartId}")
    @ResponseBody
    public ResponseEntity<MessageResponse> deleteProductIdInCart(@PathVariable("cartId") int cartId, HttpServletRequest request){
        

        Cart cart = multiService.findCartById(cartId);
        if(cart == null){
             MessageResponse message = new MessageResponse();
            message.setStatus(HttpStatus.OK.value());
            message.setMessage("khong co gi de xoa");
            message.setTimeStamp(System.currentTimeMillis());
            return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);
        }

        multiService.deleteCartById(cartId);

        MessageResponse message = new MessageResponse();
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Da xoa");
        message.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);

       
    }

    @PutMapping("/add")
    @ResponseBody
    public ResponseEntity<MessageResponse> addProductIdInCart(@RequestBody Cart cart, HttpServletRequest request){
      
        int quantity = cart.getQuantity();
        cart = multiService.findCartById(cart.getId());
        if(cart == null){
             MessageResponse message = new MessageResponse();
            message.setStatus(HttpStatus.NOT_FOUND.value());
            message.setMessage("San pham khong ton tai");
            message.setTimeStamp(System.currentTimeMillis());
            return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);
        }

        
        cart.setQuantity(quantity);
        multiService.saveCart(cart);

        MessageResponse message = new MessageResponse();
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Da update: "+ cart.getQuantity());
        message.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);

       
    }

}
