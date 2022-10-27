package com.huymq.springeshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="sunglasses_property")
public class SunglassesProperty extends ProductProperty {
    
  

    @Column(name="series_number")
    private String series;

    @Column(name="gender")
    private boolean gender;

    @Column(name="lens")
    private String lens;
    
    @Column(name="uv_protection")
    private String UVProtection;

    @Column(name="type")
    private char type;

    @Override
    public String toString() {
        return "SunglassesProperty [UVProtection=" + UVProtection + ", gender=" + gender
                + ", lens=" + lens + ", series=" + series + ", type=" + type + "]";
    }

    public SunglassesProperty() {
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

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }


    
}
