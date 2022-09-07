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

        ProductForm productForm = new ProductForm();
        productForm.setImageUrl("/images/d.jpg");
        productForm.setName("Dong ho 2");
        productForm.setDescription("fsdfafsf");
        productForm.setPrice(245.67);
        productForm.setItemInStock(99);
        productForm.setProductType('W');
        productForm.setModel("model");


        productForm.setBrand(1);
        productForm.setSeries("series");
        productForm.setWatchLabel("Japan made");
        productForm.setMovement("movement");
        productForm.setEngine("engine");
        productForm.setType('W');

        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("listNew", theList);
        theModel.addAttribute("sumCost", sumCost);
        theModel.addAttribute("productForm", productForm);
        return "product-add";
    }

    @PostMapping("/add-product")
    public String processAddProductPage(@RequestParam("files") MultipartFile[] files, @ModelAttribute("productForm") ProductForm productForm, HttpServletRequest request, Model theModel){


        Customer theCustomer = (Customer)request.getAttribute("customer");
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }

        
        productForm.setType('W');
        productForm.setProductType('W');
        System.out.println(productForm);
        Product product = productForm.getProduct();
        product.setImageUrl("/images/d.jpg");
       
        WatchProperty watch = (WatchProperty) productForm.getProductProperty();
        watch.setBrand(1);
        watch.setType('W');

        


        try {
            List<String> fileNames = new ArrayList<>();


            Arrays.asList(files).stream().forEach(file -> {
                String fileNameSave = storageService.save(file, "/"+theCustomer.getId());
                fileNames.add(file.getOriginalFilename());
                Image image = new Image();
                image.setImageUrl("/"+theCustomer.getId()+"/"+fileNameSave );
                product.addImage(image);
            });
            
            } catch (Exception e) {
                e.printStackTrace();
            }


        
        product.setProductProperty(watch);

        multiService.saveProduct(product);

        
        

        List<Product> theList  = multiService.findAllNewProduct();


        




        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("listNew", theList);
        theModel.addAttribute("sumCost", sumCost);
        return "product-add";
    }
}
