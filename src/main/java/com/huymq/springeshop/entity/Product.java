package com.huymq.springeshop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="product")
public class Product implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="item_in_stock")
    private int itemInStock;

    @Column(name="new")
    private boolean newItem;

    @Column(name="highlight")
    private boolean highlight;

    @Column(name="model")
    private String model;

    @Column(name="image_url")
    private String imageUrl;

    

    @Column(name="product_type")
    private char productType;



    //orphanRemoval de co the remove element trong list image
    //@JsonManagedReference duoc dung khi: Infinite Recursion with Jackson JSON and Hibernate JPA issue
    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference
    private List<Image> images = new ArrayList<>();

    // @JsonIgnoreProperties duoc dung khi bi loi: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="product_property")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private ProductProperty productProperty;

    @OneToMany(mappedBy = "product",orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addImage(Image image){
        images.add(image);
        image.setProduct(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setProduct(this);
    }

    @Override
    public String toString() {
        return "Product [highlight=" + highlight + ", id=" + id + ", itemInStock="
                + itemInStock + ", model=" + model + ", name=" + name + ", newItem=" + newItem + ", price=" + price
                + "]";
    }

    public Product() {
    }

    public char getProductType() {
        return productType;
    }

    public void setProductType(char productType) {
        this.productType = productType;
    }

    public ProductProperty getProductProperty() {
        return productProperty;
    }

    public void setProductProperty(ProductProperty productProperty) {
        this.productProperty = productProperty;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getNewItem() {
        return newItem;
    }

    public void setNewItem(boolean newItem) {
        this.newItem = newItem;
    }

    public boolean getHighlight() {
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    

}
