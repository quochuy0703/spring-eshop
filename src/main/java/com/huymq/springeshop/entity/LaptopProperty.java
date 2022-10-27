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

    @Column(name="year_release")
    private String yearRelease;

    
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


    @Column(name="touch_screen")
    private Boolean touchScreen;

    @Column(name="hybrid_display")
    private Boolean hybridDisplay;

    @Column(name="ram_size")
    private String ramSize;

    @Column(name="ram_type")
    private String ramType;

    @Column(name="ram_bus")
    private String ramBus;

    @Column(name="ram_max_size")
    private String ramMaxSize;


    @Column(name="storage_type")
    private String storageType;

    @Column(name="storage_size")
    private String storageSize;

    @Column(name="storage_desc")
    private String storageDesc;

    @Column(name="graphic_card_type")
    private String graphicCardType;

    @Column(name="graphic_card_name")
    private String graphicCardName;

    @Column(name="graphic_card_memory_size")
    private String graphicCardMemorySize;

    @Column(name="audio_desc")
    private String audioDesc;

    @Column(name="io_port")
    private String ioPort;

    @Column(name="io_card_reader")
    private String ioCardReader;

    @Column(name="io_webcam")
    private String ioWebcam;

    @Column(name="io_bluetooth")
    private String ioBluetooth;

    @Column(name="io_wifi")
    private String ioWifi;

    @Column(name="power_life")
    private String powerLife;

    @Column(name="power_battery_type")
    private String powerBatteryType;

    @Column(name="power_battery_cell")
    private String powerBatteryCell;

    @Column(name="power_battery_capacity")
    private String powerBatteryCapacity;

    @Column(name="software_os")
    private String softwareOs;

    @Column(name="physic_color")
    private String physicColor;

    @Column(name="physic_dimensions")
    private String physicDemensions;

    @Column(name="physic_weight")
    private String physicWeight;

    @Column(name="warranty")
    private String warranty;




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
    public Boolean getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Boolean touchScreen) {
        this.touchScreen = touchScreen;
    }
    public Boolean getHybridDisplay() {
        return hybridDisplay;
    }
    public void setHybridDisplay(Boolean hybridDisplay) {
        this.hybridDisplay = hybridDisplay;
    }
    public String getRamSize() {
        return ramSize;
    }
    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }
    public String getRamType() {
        return ramType;
    }
    public void setRamType(String ramType) {
        this.ramType = ramType;
    }
    public String getRamBus() {
        return ramBus;
    }
    public void setRamBus(String ramBus) {
        this.ramBus = ramBus;
    }
    public String getRamMaxSize() {
        return ramMaxSize;
    }
    public void setRamMaxSize(String ramMaxSize) {
        this.ramMaxSize = ramMaxSize;
    }
    public String getStorageType() {
        return storageType;
    }
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }
    public String getStorageSize() {
        return storageSize;
    }
    public void setStorageSize(String storageSize) {
        this.storageSize = storageSize;
    }
    public String getStorageDesc() {
        return storageDesc;
    }
    public void setStorageDesc(String storageDesc) {
        this.storageDesc = storageDesc;
    }
    public String getGraphicCardType() {
        return graphicCardType;
    }
    public void setGraphicCardType(String graphicCardType) {
        this.graphicCardType = graphicCardType;
    }
    public String getGraphicCardName() {
        return graphicCardName;
    }
    public void setGraphicCardName(String graphicCardName) {
        this.graphicCardName = graphicCardName;
    }
    public String getGraphicCardMemorySize() {
        return graphicCardMemorySize;
    }
    public void setGraphicCardMemorySize(String graphicCardMemorySize) {
        this.graphicCardMemorySize = graphicCardMemorySize;
    }
    public String getAudioDesc() {
        return audioDesc;
    }
    public void setAudioDesc(String audioDesc) {
        this.audioDesc = audioDesc;
    }
    public String getIoPort() {
        return ioPort;
    }
    public void setIoPort(String ioPort) {
        this.ioPort = ioPort;
    }
    public String getIoCardReader() {
        return ioCardReader;
    }
    public void setIoCardReader(String ioCardReader) {
        this.ioCardReader = ioCardReader;
    }
    public String getIoWebcam() {
        return ioWebcam;
    }
    public void setIoWebcam(String ioWebcam) {
        this.ioWebcam = ioWebcam;
    }
    public String getIoBluetooth() {
        return ioBluetooth;
    }
    public void setIoBluetooth(String ioBluetooth) {
        this.ioBluetooth = ioBluetooth;
    }
    public String getIoWifi() {
        return ioWifi;
    }
    public void setIoWifi(String ioWifi) {
        this.ioWifi = ioWifi;
    }
    public String getPowerLife() {
        return powerLife;
    }
    public void setPowerLife(String powerLife) {
        this.powerLife = powerLife;
    }
    public String getPowerBatteryType() {
        return powerBatteryType;
    }
    public void setPowerBatteryType(String powerBatteryType) {
        this.powerBatteryType = powerBatteryType;
    }
    public String getPowerBatteryCell() {
        return powerBatteryCell;
    }
    public void setPowerBatteryCell(String powerBatteryCell) {
        this.powerBatteryCell = powerBatteryCell;
    }
    public String getPowerBatteryCapacity() {
        return powerBatteryCapacity;
    }
    public void setPowerBatteryCapacity(String powerBatteryCapacity) {
        this.powerBatteryCapacity = powerBatteryCapacity;
    }
    public String getSoftwareOs() {
        return softwareOs;
    }
    public void setSoftwareOs(String softwareOs) {
        this.softwareOs = softwareOs;
    }
    public String getPhysicColor() {
        return physicColor;
    }
    public void setPhysicColor(String physicColor) {
        this.physicColor = physicColor;
    }
    public String getPhysicDemensions() {
        return physicDemensions;
    }
    public void setPhysicDemensions(String physicDemensions) {
        this.physicDemensions = physicDemensions;
    }
    public String getPhysicWeight() {
        return physicWeight;
    }
    public void setPhysicWeight(String physicWeight) {
        this.physicWeight = physicWeight;
    }
    public String getWarranty() {
        return warranty;
    }
    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
    public String getYearRelease() {
        return yearRelease;
    }
    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }


    


    
    
}
