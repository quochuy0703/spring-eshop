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
import com.huymq.springeshop.entity.Image;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.entity.WatchProperty;
import com.huymq.springeshop.service.MultiService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private MultiService multiService;

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

    @GetMapping("cart")
    public String showCart(HttpServletRequest request, Model theModel){

        Customer theCustomer = (Customer)request.getAttribute("customer");
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }

        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("sumCost", sumCost);
        return "cart";
    }


    @PostMapping("cart")
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

    @GetMapping("/add-product")
    public String showAddProductPage(HttpServletRequest request, Model theModel){
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
        return "product-add";
    }

    @PostMapping("/add-product")
    public String processAddProductPage(HttpServletRequest request, Model theModel){

        // Product product = new Product();
        // product.setImageUrl("/images/d.jpg");
        // product.setName("Dong ho 2");
        // product.setDescription("fsdfafsf");
        // product.setPrice(245.67);
        // product.setItemInStock(99);
        // product.setProductType('W');
        // WatchProperty watch = new WatchProperty();
        // watch.setBrand(1);
        // watch.setType('W');

        // Image image = new Image();
        // image.setImageUrl("/images/e.jpg");
        // product.addImage(image);
        
        // image =  new Image();
        // image.setImageUrl("/images/f.jpg");
        // product.addImage(image);

        
        // product.setProductProperty(watch);

        // multiService.saveProduct(product);

        Product product = multiService.findProductById(1);
        List<Image> images = product.getImages();
        images.remove(1);
        multiService.saveProduct(product);



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
        return "product-add";
    }
}
