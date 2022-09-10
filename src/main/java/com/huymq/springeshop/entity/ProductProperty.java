package com.huymq.springeshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ProductProperty implements Serializable,WatchPropertyInterface, SunglassesPropertyInterface {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getBrand() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getEngine() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getMovement() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getSeries() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public char getType() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getWatchLabel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isGender() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getLens() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUVProtection() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setBrand(int brand) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setEngine(String engine) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setGender(boolean gender) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setMovement(String movement) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setSeries(String series) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setType(char type) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setWatchLabel(String watchLabel) {
        // TODO Auto-generated method stub
        
    }


    
  
    
}
