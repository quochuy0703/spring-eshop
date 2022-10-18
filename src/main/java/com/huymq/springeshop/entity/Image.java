package com.huymq.springeshop.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringTokenizer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.huymq.springeshop.utils.FileStoreS3;
import com.huymq.springeshop.utils.MyConstants;



@Entity
@Table(name="image_url")
public class Image implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="image_url")
    private String imageUrl;
    
    @Transient
    private String imageUrlShow;


    //@JsonBackReference duoc dung khi: Infinite Recursion with Jackson JSON and Hibernate JPA issue
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
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

    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    

    public String getImageUrlShow() {

        StringTokenizer st = new StringTokenizer(imageUrl, "/");
        String path = null, filename = null;
        if(st.hasMoreTokens()){
             path = st.nextToken();
        }
        if(st.hasMoreTokens()){
            filename = st.nextToken();
       }
        
        return FileStoreS3.getUrlObject(MyConstants.MY_BUCKET_STRING+"/"+path, filename).toExternalForm();
    }

    public void setImageUrlShow(String imageUrlShow) {
        this.imageUrlShow = imageUrlShow;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    
    
}
