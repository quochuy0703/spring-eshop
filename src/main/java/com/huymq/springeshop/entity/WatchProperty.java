package com.huymq.springeshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="watch_property")
public class WatchProperty extends ProductProperty {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="id")
    // private int id;

    @Column(name="brand_id")
    private int brand;



    @Column(name="series")
    private String series;

    @Column(name="gender")
    private boolean gender;

    @Column(name="watch_label")
    private String watchLabel;

    @Column(name="movement")
    private String movement;

    @Column(name="engine")
    private String engine;

    @Column(name="type")
    private char type;


    @OneToOne(mappedBy = "productProperty", cascade = CascadeType.ALL,fetch =  FetchType.LAZY)
    private Product product;
    

    
    @Override
    public String toString() {
        return "WatchProperty [brand=" + brand + ", engine=" + engine + ", gender=" + gender + ", id=" + this.getId()
                + ", movement=" + movement + ", series=" + series + ", type=" + type + ", watchLabel=" + watchLabel
                + "]";
    }

    public WatchProperty() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    
}