package com.huymq.springeshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="laptop_property")
public class LaptopProperty extends ProductProperty{

    @Column(name="type")
    private char type;

    @Column(name="screen_size")
    private String screenSize;

    
    @Column(name="screen_resolution")
    private String screenResolution;

    @Column(name="processor_type")
    private String processorType;

    @Column(name="processor_cores")
    private String processorCore;

    @Column(name="processor_speed")
    private String processorSpeed;

    @Column(name="processor_cache")
    private String processorCache;


    public LaptopProperty() {
    }
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
    public String getProcessorType() {
        return processorType;
    }
    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public char getType() {
        return type;
    }
    public void setType(char type) {
        this.type = type;
    }


    
    
}
