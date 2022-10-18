package com.huymq.springeshop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

import org.hibernate.annotations.Type;

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

    @Column(name="uuid")
    @Type(type="uuid-char")
    private UUID uuid;

    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

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

    @Column(name="is_banner")
    private boolean isBanner;

    @Column(name="model")
    private String model;

    @Column(name="image_url")
    private String imageUrl;

    

    @Column(name="product_type")
    private char productType;

    @Column(name="count_seen")
    private int countSeen;

    @Column(name="count_sale")
    private int countSale;

    @Column(name="star_1")
    private int starOne;

    @Column(name="star_2")
    private int starTwo;

    @Column(name="star_3")
    private int starThree;

    @Column(name="star_4")
    private int starFour;

    @Column(name="star_5")
    private int starFive;

    @Column(name="title")
    private String title;

    @Column(name="highlight_image")
    private String highlightImage;

    @Column(name="highlight_desc")
    private String highlightDesc;


    //orphanRemoval de co the remove element trong list image
    //@JsonManagedReference duoc dung khi: Infinite Recursion with Jackson JSON and Hibernate JPA issue
    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Image> images = new ArrayList<>();

    // @JsonIgnoreProperties duoc dung khi bi loi: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="product_property")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private ProductProperty productProperty;

    @OneToMany(mappedBy = "product",orphanRemoval = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference
    private List<Review> reviews = new ArrayList<>();


    public void addImage(Image image){
        images.add(image);
        image.setProduct(this);
    }

    public void addReview(Review review){
        reviews.add(review);
        review.setProduct(this);
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getCountSeen() {
        return countSeen;
    }

    public void setCountSeen(int countSeen) {
        this.countSeen = countSeen;
    }

    public int getCountSale() {
        return countSale;
    }

    public void setCountSale(int countSale) {
        this.countSale = countSale;
    }

    public int getStarOne() {
        return starOne;
    }

    public void setStarOne(int starOne) {
        this.starOne = starOne;
    }

    public int getStarTwo() {
        return starTwo;
    }

    public void setStarTwo(int starTwo) {
        this.starTwo = starTwo;
    }

    public int getStarThree() {
        return starThree;
    }

    public void setStarThree(int starThree) {
        this.starThree = starThree;
    }

    public int getStarFour() {
        return starFour;
    }

    public void setStarFour(int starFour) {
        this.starFour = starFour;
    }

    public int getStarFive() {
        return starFive;
    }

    public void setStarFive(int starFive) {
        this.starFive = starFive;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHighlightImage() {
        return highlightImage;
    }

    public void setHighlightImage(String highlightImage) {
        this.highlightImage = highlightImage;
    }

    public String getHighlightDesc() {
        return highlightDesc;
    }

    public void setHighlightDesc(String highlightDesc) {
        this.highlightDesc = highlightDesc;
    }

    public boolean isBanner() {
        return isBanner;
    }

    public void setBanner(boolean isBanner) {
        this.isBanner = isBanner;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    


    
    

}
