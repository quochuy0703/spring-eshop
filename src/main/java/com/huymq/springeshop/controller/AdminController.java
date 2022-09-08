package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MultiService multiService;
    @Autowired
    private FilesStorageService storageService;
    
    @GetMapping("/product/add/{productType}")
    public String showAddProductPage(@PathVariable("productType") char productType,HttpServletRequest request, Model theModel){
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

        theModel.addAttribute("modeEdit", false);
        theModel.addAttribute("productType", productType);
        theModel.addAttribute("productForm", productForm);
        return "product-add";
    }

    @PostMapping("/product/add")
    public String processAddProductPage(@RequestParam("files") MultipartFile[] files, @ModelAttribute("productForm") ProductForm productForm, HttpServletRequest request, Model theModel){


        Customer theCustomer = (Customer)request.getAttribute("customer");
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }


        // productForm.setProductType(request.getParameter("productType").charAt(0));
        
        
        System.out.println(productForm);
        Product product = productForm.getProduct();
        product.setImageUrl("/images/d.jpg");
       
       
        
        if(productForm.getProductType()== 'W'){
            productForm.setType('W');
            WatchProperty propertyProduct = (WatchProperty) productForm.getProductProperty();
            propertyProduct.setBrand(1);
            propertyProduct.setType('W');
            product.setProductProperty(propertyProduct);
        }else{
            productForm.setType('S');
            SunglassesProperty propertyProduct = (SunglassesProperty) productForm.getProductProperty();
            propertyProduct.setBrand(1);
            propertyProduct.setType('S');
            product.setProductProperty(propertyProduct);
        }

        


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


        
        

        multiService.saveProduct(product);

        
        

        List<Product> theList  = multiService.findAllNewProduct();


        




        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("listNew", theList);
        theModel.addAttribute("sumCost", sumCost);
        return "product-add-type";
    }

    @GetMapping("/product/add-type")
    public String showAddProductTypePage(HttpServletRequest request, Model theModel){

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
        return "product-add-type";
    }

    @GetMapping("/product/edit/{productId}")
    public String showEditProductPage(@PathVariable("productId") int productId,HttpServletRequest request, Model theModel){
        Customer theCustomer = (Customer)request.getAttribute("customer");
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }

        List<Product> theList  = multiService.findAllNewProduct();

        Product thisProduct = multiService.findProductById(productId);


        ProductForm productForm = new ProductForm(thisProduct);
        

        theModel.addAttribute("user", theCustomer);
        theModel.addAttribute("totalCart", theCustomer.getCarts().size()+1);
        theModel.addAttribute("listNew", theList);
        theModel.addAttribute("sumCost", sumCost);

        theModel.addAttribute("modeEdit", true);
        theModel.addAttribute("productType", thisProduct.getProductType());
        theModel.addAttribute("productForm", productForm);
        return "product-add";
    }
}
