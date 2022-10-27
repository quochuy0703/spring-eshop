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

    @Column(name="power_reserve")
    private String powerReserve;

    @Column(name="case_size")
    private Double caseSize;

    @Column(name="case_thickness")
    private Double caseThickness;

    
    @Column(name="case_material")
    private String caseMaterial;

    
    @Column(name="case_shape")
    private String caseShape;

    @Column(name="case_back")
    private String caseBack;

    @Column(name="band_material")
    private String bandMaterial;

    
    @Column(name="band_type")
    private String bandType;

    @Column(name="band_color")
    private String bandColor;

    @Column(name="band_lenght")
    private Double bandLenght;

    @Column(name="band_width")
    private Double bandWidth;

    @Column(name="dial_type")
    private String dialType;

    @Column(name="dial_crystal")
    private String dialCrystal;

    @Column(name="water_resistance")
    private String waterResistance;


    @OneToOne(mappedBy = "productProperty", cascade = CascadeType.ALL,fetch =  FetchType.LAZY)
    private Product product;
    

    
    @Override
    public String toString() {
        return "WatchProperty [ engine=" + engine + ", gender=" + gender + ", id=" + this.getId()
                + ", movement=" + movement + ", series=" + series + ", type=" + type + ", watchLabel=" + watchLabel
                + "]";
    }

    public WatchProperty() {
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

    public String getPowerReserve() {
        return powerReserve;
    }

    public void setPowerReserve(String powerReserve) {
        this.powerReserve = powerReserve;
    }

    public Double getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(Double caseSize) {
        this.caseSize = caseSize;
    }

    public Double getCaseThickness() {
        return caseThickness;
    }

    public void setCaseThickness(Double caseThickness) {
        this.caseThickness = caseThickness;
    }

    public String getCaseMaterial() {
        return caseMaterial;
    }

    public void setCaseMaterial(String caseMaterial) {
        this.caseMaterial = caseMaterial;
    }

    public String getCaseShape() {
        return caseShape;
    }

    public void setCaseShape(String caseShape) {
        this.caseShape = caseShape;
    }

    public String getCaseBack() {
        return caseBack;
    }

    public void setCaseBack(String caseBack) {
        this.caseBack = caseBack;
    }

    public String getBandMaterial() {
        return bandMaterial;
    }

    public void setBandMaterial(String bandMaterial) {
        this.bandMaterial = bandMaterial;
    }

    public String getBandType() {
        return bandType;
    }

    public void setBandType(String bandType) {
        this.bandType = bandType;
    }

    public String getBandColor() {
        return bandColor;
    }

    public void setBandColor(String bandColor) {
        this.bandColor = bandColor;
    }

    public Double getBandLenght() {
        return bandLenght;
    }

    public void setBandLenght(Double bandLenght) {
        this.bandLenght = bandLenght;
    }

    public Double getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(Double bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getDialType() {
        return dialType;
    }

    public void setDialType(String dialType) {
        this.dialType = dialType;
    }

    public String getDialCrystal() {
        return dialCrystal;
    }

    public void setDialCrystal(String dialCrystal) {
        this.dialCrystal = dialCrystal;
    }

    public String getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(String waterResistance) {
        this.waterResistance = waterResistance;
    }


    

    
}