package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.bcel.AtAjAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.entity.UserLogin;
import com.huymq.springeshop.service.CustomUserDetail;
import com.huymq.springeshop.service.MultiService;
import com.huymq.springeshop.utils.AddToCartForm;
import com.huymq.springeshop.utils.CustomAuthentication;
import com.huymq.springeshop.utils.PasswordForm;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private CustomAuthentication customAuthentication;

    @Autowired
    private MultiService multiService;

    @Autowired
    private  PasswordEncoder bCryptPasswordEncoder;
    
    @GetMapping("")
    public String showAccountPage(HttpServletRequest request, Model theModel){
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
            theModel.addAttribute("path", "profile");

        }
        
        return "account-detail";
    }


    @PostMapping("/profile")
    public String processUpdateProfile(@ModelAttribute("user")Customer formCustomer,HttpServletRequest request, Model theModel){

        
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }

            theCustomer.setFirstName(formCustomer.getFirstName());
            theCustomer.setLastName(formCustomer.getLastName());
            theCustomer.setPhone(formCustomer.getPhone());
            theCustomer.setEmail(formCustomer.getEmail());
            multiService.saveCustomer(theCustomer);
            
            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);

        }

        return "account-detail";
    }

    @GetMapping("address")
    public String showAddressPage(HttpServletRequest request, Model theModel){
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
            theModel.addAttribute("path", "address");

        }
        
        return "account-detail";
    }

    @GetMapping("/password")
    public String showUpdatePassword(HttpServletRequest request, Model theModel){

        
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }

            PasswordForm passwordForm = new PasswordForm();
            
            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            theModel.addAttribute("passwordForm", passwordForm);
            theModel.addAttribute("path", "password");

        }

        return "account-detail";
    }

    @PostMapping("/password")
    public String processUpdatePassword(@ModelAttribute("passwordForm")PasswordForm passwordForm,HttpServletRequest request, Model theModel){

        
        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            double sumCost = 0.0;
            for(Cart cart: theCustomer.getCarts()){
                sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
            }

            CustomUserDetail userDetail = (CustomUserDetail)authentication.getPrincipal();
            
            System.out.println(bCryptPasswordEncoder.encode(passwordForm.getCurrentPassword())+' '+userDetail.getPassword());
            
            if(bCryptPasswordEncoder.matches(passwordForm.getCurrentPassword(),userDetail.getPassword())){
                if(passwordForm.getPassword().equals(passwordForm.getConfirmPassword())){
                    String encodePassword = bCryptPasswordEncoder.encode(passwordForm.getPassword());
                    UserLogin userLogin = multiService.findUserLoginByEmail(authentication.getName());
                    userLogin.setPassword(encodePassword);
                    multiService.saveUserLogin(userLogin);
                }
            }


            theModel.addAttribute("user", theCustomer);
            theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
            theModel.addAttribute("sumCost", sumCost);
            theModel.addAttribute("path", "password");
            

        }

        return "account-detail";
    }


    @GetMapping("/order")
    public String showOrder(HttpServletRequest request, Model theModel){

        
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
          
            theModel.addAttribute("path", "order");

        }

        return "account-detail";
    }

}
