package com.huymq.springeshop.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="image_url")
public class Image implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="image_url")
    private String imageUrl;


    //@JsonBackReference duoc dung khi: Infinite Recursion with Jackson JSON and Hibernate JPA issue
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="product_id")
    @JsonBackReference
    private Product product;

    public Image() {
    }

    @Override
    public String toString() {
        return "Image [id=" + id + ", image_url=" + imageUrl + ", product=" + product + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image_url) {
        this.imageUrl = image_url;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    
}
