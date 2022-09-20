package com.huymq.springeshop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductForm {
    private int id;
    private UUID uuid;
    private int productPropertyId;

    private String name;

    

    private String description;

    private double price;

    private int itemInStock;

    private boolean newItem;

    private boolean highlight;

    private String model;

    private String imageUrl;

    private char productType;

    private List<Image> images = new ArrayList<>();
    private List<Image> imageOnClouds = new ArrayList<>();;

    // -----------------------------

    

    

    private int brand;

    private String series;

    private boolean gender;

    private String watchLabel;


    private String movement;

    private String engine;

    private char type;


    // ------------------------------

    private String lens;

    private String UVProtection;


    //

    
    private String screenSize;

    
   
    private String screenResolution;

   
    private String processorType;

    
    private String processorCore;

    
    private String processorSpeed;

  
    private String processorCache;



    

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public String getProcessorCore() {
        return processorCore;
    }

    public void setProcessorCore(String processorCore) {
        this.processorCore = processorCore;
    }

    public String getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(String processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public String getProcessorCache() {
        return processorCache;
    }

    public void setProcessorCache(String processorCache) {
        this.processorCache = processorCache;
    }

    @Override
    public String toString() {
        return "ProductForm [UVProtection=" + UVProtection + ", brand=" + brand + ", description=" + description
                + ", engine=" + engine + ", gender=" + gender + ", highlight=" + highlight + ", id=" + id
                + ", imageUrl=" + imageUrl + ", images=" + images + ", itemInStock=" + itemInStock + ", lens=" + lens
                + ", model=" + model + ", movement=" + movement + ", name=" + name + ", newItem=" + newItem + ", price="
                + price + ", productPropertyId=" + productPropertyId + ", productType=" + productType + ", series="
                + series + ", type=" + type + ", watchLabel=" + watchLabel + "]";
    }

    public Product getProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setUuid(this.uuid);
        product.setImageUrl(this.imageUrl);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setItemInStock(this.itemInStock);
        product.setProductType(this.productType);
        product.setModel(this.model);
       
        return product;
    }

    public Product getProduct(Product product){
        
   
 
        product.setImageUrl(this.imageUrl);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setItemInStock(this.itemInStock);
        product.setProductType(this.productType);
        product.setModel(this.model);

        ProductProperty productProperty = product.getProductProperty();

        
        productProperty.setBrand(this.brand);
        productProperty.setSeries(this.series);
        productProperty.setGender(gender);
        productProperty.setWatchLabel(this.watchLabel);
        productProperty.setMovement(this.movement);
        productProperty.setEngine(this.engine);
        productProperty.setType(this.type);
    

        productProperty.setScreenSize(this.screenSize);
        productProperty.setScreenResolution(this.screenResolution);
        productProperty.setProcessorCache(this.processorCache);
        productProperty.setProcessorCore(this.processorCore);
        productProperty.setProcessorSpeed(this.processorSpeed);
        productProperty.setProcessorType(this.processorType);
       
        return product;
    }

    public ProductProperty getProductProperty(){
        ProductProperty productProperty = null;
        if(this.productType=='W'){
            productProperty = new WatchProperty();
            
        }else if(this.productType=='S'){
            productProperty = new SunglassesProperty();
        }else if(this.productType=='L'){
            productProperty = new LaptopProperty();
        }
        productProperty.setId(this.productPropertyId);
        productProperty.setBrand(this.brand);
        productProperty.setSeries(this.series);
        productProperty.setGender(gender);
        productProperty.setWatchLabel(this.watchLabel);
        productProperty.setMovement(this.movement);
        productProperty.setEngine(this.engine);
        productProperty.setType(this.type);
    

        productProperty.setScreenSize(this.screenSize);
        productProperty.setScreenResolution(this.screenResolution);
        productProperty.setProcessorCache(this.processorCache);
        productProperty.setProcessorCore(this.processorCore);
        productProperty.setProcessorSpeed(this.processorSpeed);
        productProperty.setProcessorType(this.processorType);
     


        return productProperty;
    }

    public ProductForm(Product product){
        this.setId(product.getId());
        this.setUuid(product.getUuid());
        this.setImageUrl(product.getImageUrl());
        this.setName(product.getName());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setItemInStock(product.getItemInStock());
        this.setModel(product.getModel());
        this.setImages(product.getImages());
        this.setImageOnClouds(product.getImages());

        ProductProperty productProperty = product.getProductProperty();
        this.setProductPropertyId(productProperty.getId());
        this.setBrand(productProperty.getBrand());
        this.setSeries(productProperty.getSeries());
        this.setWatchLabel(productProperty.getWatchLabel());
        this.setMovement(productProperty.getMovement());
        this.setEngine(productProperty.getEngine());
        this.setType(productProperty.getType());


        this.setScreenSize(productProperty.getScreenSize());
        this.setScreenResolution(productProperty.getScreenResolution());
        this.setProcessorType(productProperty.getProcessorType());
        this.setProcessorCore(productProperty.getProcessorCore());
        this.setProcessorSpeed(productProperty.getProcessorSpeed());
        this.setProcessorCache(productProperty.getProcessorCache());
    }
    

    public ProductForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductPropertyId() {
        return productPropertyId;
    }

    public void setProductPropertyId(int product_property) {
        this.productPropertyId = product_property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemInStock() {
        return itemInStock;
    }

    public void setItemInStock(int itemInStock) {
        this.itemInStock = itemInStock;
    }

    public boolean isNewItem() {
        return newItem;
    }

    public void setNewItem(boolean newItem) {
        this.newItem = newItem;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public char getProductType() {
        return productType;
    }

    public void setProductType(char productType) {
        this.productType = productType;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getWatchLabel() {
        return watchLabel;
    }

    public void setWatchLabel(String watchLabel) {
        this.watchLabel = watchLabel;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getUVProtection() {
        return UVProtection;
    }

    public void setUVProtection(String uVProtection) {
        UVProtection = uVProtection;
    }

    public List<Image> getImageOnClouds() {
        return imageOnClouds;
    }

    public void setImageOnClouds(List<Image> imageOnClouds) {
        this.imageOnClouds = imageOnClouds;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    

}
