package com.huymq.springeshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Image;
import com.huymq.springeshop.entity.LaptopProperty;
import com.huymq.springeshop.entity.OrderItem;
import com.huymq.springeshop.entity.OrderStatus;
import com.huymq.springeshop.entity.ProcessOrderDetail;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.entity.ProductForm;
import com.huymq.springeshop.entity.SunglassesProperty;
import com.huymq.springeshop.entity.WatchProperty;
import com.huymq.springeshop.service.MultiService;
import com.huymq.springeshop.utils.CustomAuthentication;
import com.huymq.springeshop.utils.FilesStorageService;
import com.huymq.springeshop.utils.HighlightProductForm;
import com.huymq.springeshop.utils.MessageResponse;
import com.huymq.springeshop.utils.exception.OrderItemNotFoundException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MultiService multiService;
    @Autowired
    private FilesStorageService storageService;

    @Autowired
    private CustomAuthentication customAuthentication;
    
    @GetMapping("/products")
    public String showAllProductPage(HttpServletRequest request, Model theModel){
        


        Page<Product> theList  = multiService.findAllProduct(Pageable.unpaged());

       

       
        theModel.addAttribute("list", theList.getContent());
        theModel.addAttribute("path", "all-product");
        
        return "admin-detail";
    }

    @GetMapping("/highlight")
    public String showAllHighlightProductPage(HttpServletRequest request, Model theModel){
        


        List<Product> theList  = multiService.findAllHighlightProduct(true);

       

       
        theModel.addAttribute("list", theList);
        theModel.addAttribute("path", "highlight-product");
        
        return "admin-detail";
    }

    @PutMapping("/highlight/save/{productId}")
    @ResponseBody
    public ResponseEntity<MessageResponse> processHighlightSave(@PathVariable("productId") UUID productId, @RequestBody HighlightProductForm highlightForm, HttpServletRequest request){
        

        Product product = multiService.findProductByUUID(productId);
        if(product == null){
            
            throw new OrderItemNotFoundException("Not found "+ productId);
        }

        System.out.println(highlightForm.isEdit());
        if(highlightForm.isHighlight()){
            int count = multiService.countProductByHighlight(true);

            if(count >= 3 && !highlightForm.isEdit()){
                throw new OrderItemNotFoundException("Not found "+ productId);
            }
        }

        product.setHighlightDesc(highlightForm.getHighlightDesc());
        product.setTitle(highlightForm.getTitle());
        product.setHighlight(highlightForm.isHighlight());

        multiService.saveProduct(product);
        


        MessageResponse message = new MessageResponse();
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Da xu ly");
        message.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);

       
    }

    @PutMapping("/new-product/save/{productId}")
    @ResponseBody
    public ResponseEntity<MessageResponse> processNewProductSave(@PathVariable("productId") UUID productId, HttpServletRequest request){
        

        Product product = multiService.findProductByUUID(productId);
        if(product == null){
            
            throw new OrderItemNotFoundException("Not found "+ productId);
        }

        if(!product.getNewItem()){
            int count = multiService.countProductByNewItem(true);
            if(count >= 8){
                throw new OrderItemNotFoundException("Not found "+ productId);
            }
        }

        product.setNewItem(!product.getNewItem());

        multiService.saveProduct(product);
        


        MessageResponse message = new MessageResponse();
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Da xu ly");
        message.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);

       
    }

    @GetMapping("/new-product")
    public String showAllNewProductPage(HttpServletRequest request, Model theModel){
        


        List<Product> theList  = multiService.findAllNewProduct(true);

       

       
        theModel.addAttribute("list", theList);
        theModel.addAttribute("path", "new-product");
        
        return "admin-detail";
    }


    @GetMapping("/banner")
    public String showAllBannerProductPage(HttpServletRequest request, Model theModel){
        


        List<Product> theList  = multiService.findAllBannerProduct(true);

       

       
        theModel.addAttribute("list", theList);
        theModel.addAttribute("path", "banner-product");
        
        return "admin-detail";
    }

    @PutMapping("/banner/save/{productId}")
    @ResponseBody
    public ResponseEntity<MessageResponse> processBannerProductSave(@PathVariable("productId") UUID productId, HttpServletRequest request){
        

        Product product = multiService.findProductByUUID(productId);
        if(product == null){
            
            throw new OrderItemNotFoundException("Not found "+ productId);
        }

        if(!product.isBanner()){
            int count = multiService.countProductByIsBanner(true);
            if(count >= 3){
                throw new OrderItemNotFoundException("Not found "+ productId);
            }
        }

        product.setBanner(!product.isBanner());

        multiService.saveProduct(product);
        


        MessageResponse message = new MessageResponse();
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Da xu ly");
        message.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);

       
    }

    @GetMapping("/product/add/{productType}")
    public String showAddProductPage(@PathVariable("productType") char productType,HttpServletRequest request, Model theModel){
        


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


        theModel.addAttribute("modeEdit", false);
        theModel.addAttribute("productType", productType);
        theModel.addAttribute("productForm", productForm);
        theModel.addAttribute("path", "add-type");
        
        return "product-add";
    }

    @PostMapping("/product/add")
    public String processAddProductPage(@RequestParam("files") MultipartFile[] files, @ModelAttribute("productForm") ProductForm productForm, HttpServletRequest request, Model theModel){


        Customer theCustomer = null;
        Authentication authentication = customAuthentication.getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            theCustomer = multiService.findCustomerByEmail(authentication.getName());
            

        }
        double sumCost = 0.0;
        for(Cart cart: theCustomer.getCarts()){
            sumCost = cart.getQuantity()*cart.getProduct().getPrice() + sumCost;
        }


        // productForm.setProductType(request.getParameter("productType").charAt(0));
        
        Product product = productForm.getProduct();
        product.setImageUrl("/images/d.jpg");
        product.setUuid(UUID.randomUUID());
      
        

        System.out.println(productForm.getId());

        
        if(productForm.getProductType()== 'W'){
           
            WatchProperty propertyProduct = (WatchProperty) productForm.getProductProperty();
            propertyProduct.setBrand(1);
            
            product.setProductProperty(propertyProduct);
        }else if(productForm.getProductType()== 'S'){
           
            SunglassesProperty propertyProduct = (SunglassesProperty) productForm.getProductProperty();
            propertyProduct.setBrand(1);
      
            product.setProductProperty(propertyProduct);
        }if(productForm.getProductType()== 'L'){
           
            LaptopProperty propertyProduct = (LaptopProperty) productForm.getProductProperty();
            propertyProduct.setBrand(1);
      
            product.setProductProperty(propertyProduct);
        }

        

        UUID productUUID = product.getUuid();

        try {
            List<String> fileNames = new ArrayList<>();

            //multifile neu khong chon file se tra ve empty file -> Arrays.asList(files).size() -> = 1(size ==1)
            
            boolean empty = 
                        Arrays.asList(files).stream().filter(f -> !f.isEmpty()).count() == 0;

            if(!empty){
                Arrays.asList(files).stream().forEach(file -> {
                    String fileNameSave = storageService.save(file, "/"+ productUUID);
                    fileNames.add(file.getOriginalFilename());
                    Image image = new Image();
                    image.setImageUrl("/"+productUUID+"/"+fileNameSave );
                    product.addImage(image);
                });
            }
            
            
            } catch (Exception e) {
                e.printStackTrace();
            }


        
        

            
        multiService.saveProduct(product);

        
        

       



        theModel.addAttribute("path", "add-type");
        return "admin-detail";
    }

    @GetMapping("")
    public String showAddProductTypePage(Model theModel){

        theModel.addAttribute("path", "add-type");
        return "admin-detail";
    }

    @GetMapping("/product/edit/{productId}")
    public String showEditProductPage(@PathVariable("productId") UUID uuid,HttpServletRequest request, Model theModel){
        

        Product thisProduct = multiService.findProductByUUID(uuid);


        ProductForm productForm = new ProductForm(thisProduct);
        

        theModel.addAttribute("modeEdit", true);
        theModel.addAttribute("thisProduct", thisProduct);
        theModel.addAttribute("productType", thisProduct.getProductType());
        theModel.addAttribute("productForm", productForm);
        theModel.addAttribute("path", "edit-product");
        return "product-add";
    }


    @GetMapping("/statistic/dashboard")
    public String showDashboarStatisticPage(HttpServletRequest request, Model theModel){
        

       
        

        
        return null;
    }

    @PostMapping("/product/edit")
    public String processEditProductPage(@RequestParam("files") MultipartFile[] files, @ModelAttribute("productForm") ProductForm productForm, HttpServletRequest request, Model theModel){


        
        // productForm.setProductType(request.getParameter("productType").charAt(0));
        
        Product product = multiService.findProductByUUID(productForm.getUuid());

        productForm.getProduct(product);
        System.out.println(product);
       
        System.out.println(productForm.getImageOnClouds());

        // Predicate<Image> p = (i ) -> { 
        //     for(Image image : productForm.getImageOnClouds()){
        //         if(i.getId() == image.getId()){
        //             return true;
        //         }
        //     }
        //     return false;
        // };
        // List<Image> listImageUpdate = product.getImages().stream().filter(p).collect(Collectors.toList());
        // product.setImages(listImageUpdate);

        //remove image tren cloud
        Iterator<Image> i = product.getImages().iterator();

        while (i.hasNext()){
            Image image = i.next();
            boolean flagDelete = true;
            for(Image tempImage : productForm.getImageOnClouds()){
                if(image.getId() == tempImage.getId()){
                    flagDelete = false;
                    break;
                }

            }
            if(flagDelete){
                i.remove();
            }

            
        }


        //add new image;
        UUID productUUID = product.getUuid();

        try {
            List<String> fileNames = new ArrayList<>();


            //multifile neu khong chon file se tra ve empty file -> Arrays.asList(files).size() -> = 1(size ==1)
            
            boolean empty = 
                        Arrays.asList(files).stream().filter(f -> !f.isEmpty()).count() == 0;
            

            if(!empty ){
                Arrays.asList(files).stream().forEach(file -> {
                    String fileNameSave = storageService.saveS3(file, "/"+ productUUID);
                    fileNames.add(file.getOriginalFilename());
                    Image image = new Image();
                    // image.setImageUrl("/uploads/"+productUUID+"/"+fileNameSave );
                    image.setImageUrl("/"+productUUID+"/"+fileNameSave );
                    product.addImage(image);
                });
            }
            
            
            } catch (Exception e) {
                e.printStackTrace();
            }


            
        multiService.saveProduct(product);
     

        
        return "redirect:/admin/product/edit/"+product.getUuid();
    }

    

    @GetMapping("/orders/process/{typeProcess}")
    public String showPrepareOrdertPage(@PathVariable("typeProcess") int processType,HttpServletRequest request, Model theModel){
        


        Page<OrderItem> theList  = multiService.findOrderItemByStatus(OrderStatus.values()[processType],Pageable.unpaged());

        theModel.addAttribute("list", theList.getContent());
        theModel.addAttribute("path", "process"+processType);
        
        return "admin-detail";
    }

    @PutMapping("/orders/prepare/{orderId}")
    @ResponseBody
    public ResponseEntity<MessageResponse> processPrepareOrder(@PathVariable("orderId") int orderId, HttpServletRequest request){
        

        OrderItem orderItem = multiService.findOrderItemById(orderId);
        if(orderItem == null){
            
            throw new OrderItemNotFoundException("Not found "+ orderId);
        }
        if(orderItem.getOrderStatus() == OrderStatus.SHIPPED || orderItem.getOrderStatus() == OrderStatus.COMPLETED || orderItem.getOrderStatus() == OrderStatus.CANCELLED){
            throw new OrderItemNotFoundException("Not found "+ orderId);
        }
        
        ProcessOrderDetail process = new ProcessOrderDetail();
        
        orderItem.setOrderStatus(OrderStatus.values()[orderItem.getOrderStatus().ordinal()+1] );
        process.setOrderStatus(orderItem.getOrderStatus());
        orderItem.addProcessOrderDetail(process);

        multiService.saveOrderItem(orderItem);


        MessageResponse message = new MessageResponse();
        message.setStatus(HttpStatus.OK.value());
        message.setMessage("Da xu ly");
        message.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<MessageResponse>(message, HttpStatus.OK);

       
    }
}
