package com.huymq.springeshop.entity;

import java.util.List;

public class ProductForm {
    private int id;
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

    // -----------------------------

    

    private List<Image> images;

    private int brand;

    private String series;

    private boolean gender;

    private String watchLabel;


    private String movement;

    private String engine;

    private char type;



    @Override
    public String toString() {
        return "ProductForm [brand=" + brand + ", description=" + description + ", engine=" + engine + ", gender="
                + gender + ", highlight=" + highlight + ", id=" + id + ", imageUrl=" + imageUrl + ", images=" + images
                + ", itemInStock=" + itemInStock + ", model=" + model + ", movement=" + movement + ", name=" + name
                + ", newItem=" + newItem + ", price=" + price + ", productPropertyId=" + productPropertyId
                + ", productType=" + productType + ", series=" + series + ", type=" + type + ", watchLabel="
                + watchLabel + "]";
    }

    public Product getProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setImageUrl(this.imageUrl);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setItemInStock(this.itemInStock);
        product.setProductType(this.productType);
        product.setModel(this.model);
        return product;
    }

    public ProductProperty getProductProperty(){
        ProductProperty productProperty = null;
        if(this.productType=='W'){
            productProperty = new WatchProperty();
        }
        productProperty.setId(this.productPropertyId);
        productProperty.setBrand(this.brand);
        productProperty.setSeries(this.series);
        productProperty.setGender(gender);
        productProperty.setWatchLabel(this.watchLabel);
        productProperty.setMovement(this.movement);
        productProperty.setEngine(this.engine);
        productProperty.setType(this.type);
        return productProperty;
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

    

}
