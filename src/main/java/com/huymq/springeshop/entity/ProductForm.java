package com.huymq.springeshop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductForm {
    private int id;
    private UUID uuid;
    private int productPropertyId;


    private String brand;

    private String name;

    

    private String description;

    private double price;

    private int itemInStock;

    private boolean newItem;

    private boolean highlight;

    private String model;

    private String imageUrl;

    private char productType;

    private List<Image> images = new ArrayList<>();
    private List<Image> imageOnClouds = new ArrayList<>();;

    // -----------------------------

    

    

    

    private String series;

    private boolean gender;

    private String watchLabel;


    private String movement;

    private String engine;

    private char type;

   
    private String powerReserve;

 
    private Double caseSize;

   
    private Double caseThickness;

    
    
    private String caseMaterial;

    
   
    private String caseShape;

    
    private String caseBack;

    
    private String bandMaterial;

    
   
    private String bandType;

    
    private String bandColor;

   
    private Double bandLenght;

    
    private Double bandWidth;

    
    private String dialType;

    
    private String dialCrystal;

    
    private String waterResistance;


    // ------------------------------

    private String lens;

    private String UVProtection;


    //

    
    private String yearRelease;

    
    private String screenSize;

    
   
    private String screenResolution;

   
    private String processorType;

    
    private String processorCore;

    
    private String processorSpeed;

  
    private String processorCache;


    private Boolean touchScreen;

 
    private Boolean hybridDisplay;

   
    private String ramSize;

 
    private String ramType;

   
    private String ramBus;

    
    private String ramMaxSize;


  
    private String storageType;

    
    private String storageSize;

  
    private String storageDesc;

  
    private String graphicCardType;

    
    private String graphicCardName;


    private String graphicCardMemorySize;

    
    private String audioDesc;

 
    private String ioPort;

   
    private String ioCardReader;

    
    private String ioWebcam;

    
    private String ioBluetooth;

   
    private String ioWifi;

    
    private String powerLife;

   
    private String powerBatteryType;

 
    private String powerBatteryCell;

   
    private String powerBatteryCapacity;

    
    private String softwareOs;

   
    private String physicColor;

    
    private String physicDemensions;

  
    private String physicWeight;

    
    private String warranty;



    

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

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
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

   

    @Override
    public String toString() {
        return "ProductForm [id=" + id + ", uuid=" + uuid + ", productPropertyId=" + productPropertyId + ", brand="
                + brand + ", name=" + name + ", description=" + description + ", price=" + price + ", itemInStock="
                + itemInStock + ", newItem=" + newItem + ", highlight=" + highlight + ", model=" + model + ", imageUrl="
                + imageUrl + ", productType=" + productType + ", images=" + images + ", imageOnClouds=" + imageOnClouds
                + ", series=" + series + ", gender=" + gender + ", watchLabel=" + watchLabel + ", movement=" + movement
                + ", engine=" + engine + ", type=" + type + ", lens=" + lens + ", UVProtection=" + UVProtection
                + ", screenSize=" + screenSize + ", screenResolution=" + screenResolution + ", processorType="
                + processorType + ", processorCore=" + processorCore + ", processorSpeed=" + processorSpeed
                + ", processorCache=" + processorCache + ", touchScreen=" + touchScreen + ", hybridDisplay="
                + hybridDisplay + ", ramSize=" + ramSize + ", ramType=" + ramType + ", ramBus=" + ramBus
                + ", ramMaxSize=" + ramMaxSize + ", storageType=" + storageType + ", storageSize=" + storageSize
                + ", storageDesc=" + storageDesc + ", graphicCardType=" + graphicCardType + ", graphicCardName="
                + graphicCardName + ", graphicCardMemorySize=" + graphicCardMemorySize + ", audioDesc=" + audioDesc
                + ", ioPort=" + ioPort + ", ioCardReader=" + ioCardReader + ", ioWebcam=" + ioWebcam + ", ioBluetooth="
                + ioBluetooth + ", ioWifi=" + ioWifi + ", powerLife=" + powerLife + ", powerBatteryType="
                + powerBatteryType + ", powerBatteryCell=" + powerBatteryCell + ", powerBatteryCapacity="
                + powerBatteryCapacity + ", softwareOs=" + softwareOs + ", physicColor=" + physicColor
                + ", physicDemensions=" + physicDemensions + ", physicWeight=" + physicWeight + ", warranty=" + warranty
                + "]";
    }

    public Product getProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setUuid(this.uuid);
        product.setImageUrl(this.imageUrl);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setItemInStock(this.itemInStock);
        product.setProductType(this.productType);
        product.setModel(this.model);
       
        return product;
    }

    public Product getProduct(Product product){
        
   
 
        product.setImageUrl(this.imageUrl);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setItemInStock(this.itemInStock);
        product.setProductType(this.productType);
        product.setModel(this.model);
       

        ProductProperty productProperty = product.getProductProperty();

       

        productProperty.setSeries(this.series);
        productProperty.setGender(gender);
        productProperty.setWatchLabel(this.watchLabel);
        productProperty.setMovement(this.movement);
        productProperty.setEngine(this.engine);
        productProperty.setType(this.type);
        productProperty.setPowerReserve(this.powerReserve);
        productProperty.setCaseBack(this.caseBack);
        productProperty.setCaseMaterial(this.caseMaterial);
        productProperty.setCaseShape(this.caseShape);
        productProperty.setCaseSize(this.caseSize);
        productProperty.setCaseThickness(this.caseThickness);
        productProperty.setBandColor(this.bandColor);
        productProperty.setBandLenght(this.bandLenght);
        productProperty.setBandMaterial(this.bandMaterial);
        productProperty.setBandType(this.bandType);
        productProperty.setBandWidth(this.bandWidth);
        productProperty.setDialCrystal(this.dialCrystal);
        productProperty.setDialType(this.dialType);
        productProperty.setWaterResistance(this.waterResistance);
        
    

        productProperty.setYearRelease(this.getYearRelease());
        productProperty.setScreenSize(this.screenSize);
        productProperty.setScreenResolution(this.screenResolution);
        productProperty.setProcessorCache(this.processorCache);
        productProperty.setProcessorCore(this.processorCore);
        productProperty.setProcessorSpeed(this.processorSpeed);
        productProperty.setProcessorType(this.processorType);
        productProperty.setTouchScreen(this.getTouchScreen());
        productProperty.setHybridDisplay(this.getHybridDisplay()) ;
        productProperty.setRamSize(this.getRamMaxSize());
        productProperty.setRamType(this.getRamType()) ;
        productProperty.setRamBus(this.getRamBus());
        productProperty.setRamMaxSize(this.getRamMaxSize()) ;
        productProperty.setStorageType(this.getStorageType()) ;
        productProperty.setStorageSize(this.getStorageSize()) ;
        productProperty.setStorageDesc(this.getStorageDesc()) ;
        productProperty.setGraphicCardType(this.getGraphicCardType()) ;
        productProperty.setGraphicCardName(this.getGraphicCardName()) ;
        productProperty.setGraphicCardMemorySize(this.getGraphicCardMemorySize()) ;
        productProperty.setAudioDesc(this.getAudioDesc());
        productProperty.setIoPort(this.getIoPort()) ;
        productProperty.setIoCardReader(this.getIoCardReader()) ;
        productProperty.setIoWebcam(this.getIoWebcam()) ;
        productProperty.setIoBluetooth(this.getIoBluetooth());
        productProperty.setIoWifi(this.getIoWifi()) ;
        productProperty.setPowerLife(this.getPowerLife()) ;
        productProperty.setPowerBatteryType(this.getPowerBatteryType());
        productProperty.setPowerBatteryCell(this.getPowerBatteryCell());
        productProperty.setPowerBatteryCapacity(this.getPowerBatteryCapacity());
        productProperty.setSoftwareOs(this.getSoftwareOs());
        productProperty.setPhysicColor(this.getPhysicColor());
        productProperty.setPhysicDemensions(this.getPhysicDemensions()) ;
        productProperty.setPhysicWeight(this.getPhysicWeight());
        productProperty.setWarranty(this.getWarranty()) ;

       
        return product;
    }

    public ProductProperty getProductProperty(){
        ProductProperty productProperty = null;
        if(this.productType=='W'){
            productProperty = new WatchProperty();
            
        }else if(this.productType=='S'){
            productProperty = new SunglassesProperty();
        }else if(this.productType=='L'){
            productProperty = new LaptopProperty();
        }
        productProperty.setId(this.productPropertyId);
        productProperty.setSeries(this.series);
        productProperty.setGender(gender);
        productProperty.setWatchLabel(this.watchLabel);
        productProperty.setMovement(this.movement);
        productProperty.setEngine(this.engine);
        productProperty.setType(this.type);
        productProperty.setPowerReserve(this.powerReserve);
        productProperty.setCaseBack(this.caseBack);
        productProperty.setCaseMaterial(this.caseMaterial);
        productProperty.setCaseShape(this.caseShape);
        productProperty.setCaseSize(this.caseSize);
        productProperty.setCaseThickness(this.caseThickness);
        productProperty.setBandColor(this.bandColor);
        productProperty.setBandLenght(this.bandLenght);
        productProperty.setBandMaterial(this.bandMaterial);
        productProperty.setBandType(this.bandType);
        productProperty.setBandWidth(this.bandWidth);
        productProperty.setDialCrystal(this.dialCrystal);
        productProperty.setDialType(this.dialType);
        productProperty.setWaterResistance(this.waterResistance);


        productProperty.setYearRelease(this.getYearRelease());
        productProperty.setScreenSize(this.screenSize);
        productProperty.setScreenResolution(this.screenResolution);
        productProperty.setProcessorCache(this.processorCache);
        productProperty.setProcessorCore(this.processorCore);
        productProperty.setProcessorSpeed(this.processorSpeed);
        productProperty.setProcessorType(this.processorType);
        productProperty.setTouchScreen(this.getTouchScreen());
        productProperty.setHybridDisplay(this.getHybridDisplay()) ;
        productProperty.setRamSize(this.getRamMaxSize());
        productProperty.setRamType(this.getRamType()) ;
        productProperty.setRamBus(this.getRamBus());
        productProperty.setRamMaxSize(this.getRamMaxSize()) ;
        productProperty.setStorageType(this.getStorageType()) ;
        productProperty.setStorageSize(this.getStorageSize()) ;
        productProperty.setStorageDesc(this.getStorageDesc()) ;
        productProperty.setGraphicCardType(this.getGraphicCardType()) ;
        productProperty.setGraphicCardName(this.getGraphicCardName()) ;
        productProperty.setGraphicCardMemorySize(this.getGraphicCardMemorySize()) ;
        productProperty.setAudioDesc(this.getAudioDesc());
        productProperty.setIoPort(this.getIoPort()) ;
        productProperty.setIoCardReader(this.getIoCardReader()) ;
        productProperty.setIoWebcam(this.getIoWebcam()) ;
        productProperty.setIoBluetooth(this.getIoBluetooth());
        productProperty.setIoWifi(this.getIoWifi()) ;
        productProperty.setPowerLife(this.getPowerLife()) ;
        productProperty.setPowerBatteryType(this.getPowerBatteryType());
        productProperty.setPowerBatteryCell(this.getPowerBatteryCell());
        productProperty.setPowerBatteryCapacity(this.getPowerBatteryCapacity());
        productProperty.setSoftwareOs(this.getSoftwareOs());
        productProperty.setPhysicColor(this.getPhysicColor());
        productProperty.setPhysicDemensions(this.getPhysicDemensions()) ;
        productProperty.setPhysicWeight(this.getPhysicWeight());
        productProperty.setWarranty(this.getWarranty()) ;
     


        return productProperty;
    }

    public ProductForm(Product product){
        this.setId(product.getId());
        this.setBrand(product.getBrand().getName());
        this.setUuid(product.getUuid());
        this.setImageUrl(product.getImageUrl());
        this.setName(product.getName());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setItemInStock(product.getItemInStock());
        this.setModel(product.getModel());
        this.setImages(product.getImages());
        this.setImageOnClouds(product.getImages());
        // this.setBrand(product.getBrand());

        ProductProperty productProperty = product.getProductProperty();

        this.setProductPropertyId(productProperty.getId());
        // this.setBrand(productProperty.getBrand());
        this.setSeries(productProperty.getSeries());
        this.setWatchLabel(productProperty.getWatchLabel());
        this.setMovement(productProperty.getMovement());
        this.setEngine(productProperty.getEngine());
        this.setType(productProperty.getType());
        this.setPowerReserve(productProperty.getPowerReserve());
        this.setCaseBack(productProperty.getCaseBack());
        this.setCaseMaterial(productProperty.getCaseMaterial());
        this.setCaseShape(productProperty.getCaseShape());
        this.setCaseSize(productProperty.getCaseSize());
        this.setCaseThickness(productProperty.getCaseThickness());
        this.setBandColor(productProperty.getBandColor());
        this.setBandLenght(productProperty.getBandLenght());
        this.setBandMaterial(productProperty.getBandMaterial());
        this.setBandType(productProperty.getBandType());
        this.setBandWidth(productProperty.getBandWidth());
        this.setDialCrystal(productProperty.getDialCrystal());
        this.setDialType(productProperty.getDialType());
        this.setWaterResistance(productProperty.getWaterResistance());


        this.setYearRelease(productProperty.getYearRelease());
        this.setScreenSize(productProperty.getScreenSize());
        this.setScreenResolution(productProperty.getScreenResolution());
        this.setProcessorType(productProperty.getProcessorType());
        this.setProcessorCore(productProperty.getProcessorCore());
        this.setProcessorSpeed(productProperty.getProcessorSpeed());
        this.setProcessorCache(productProperty.getProcessorCache());
        this.setTouchScreen(productProperty.getTouchScreen());
        this.setHybridDisplay(productProperty.getHybridDisplay()) ;
        this.setRamSize(productProperty.getRamMaxSize());
        this.setRamType(productProperty.getRamType()) ;
        this.setRamBus(productProperty.getRamBus());
        this.setRamMaxSize(productProperty.getRamMaxSize()) ;
        this.setStorageType(productProperty.getStorageType()) ;
        this.setStorageSize(productProperty.getStorageSize()) ;
        this.setStorageDesc(productProperty.getStorageDesc()) ;
        this.setGraphicCardType(productProperty.getGraphicCardType()) ;
        this.setGraphicCardName(productProperty.getGraphicCardName()) ;
        this.setGraphicCardMemorySize(productProperty.getGraphicCardMemorySize()) ;
        this.setAudioDesc(productProperty.getAudioDesc());
        this.setIoPort(productProperty.getIoPort()) ;
        this.setIoCardReader(productProperty.getIoCardReader()) ;
        this.setIoWebcam(productProperty.getIoWebcam()) ;
        this.setIoBluetooth(productProperty.getIoBluetooth());
        this.setIoWifi(productProperty.getIoWifi()) ;
        this.setPowerLife(productProperty.getPowerLife()) ;
        this.setPowerBatteryType(productProperty.getPowerBatteryType());
        this.setPowerBatteryCell(productProperty.getPowerBatteryCell());
        this.setPowerBatteryCapacity(productProperty.getPowerBatteryCapacity());
        this.setSoftwareOs(productProperty.getSoftwareOs());
        this.setPhysicColor(productProperty.getPhysicColor());
        this.setPhysicDemensions(productProperty.getPhysicDemensions()) ;
        this.setPhysicWeight(productProperty.getPhysicWeight());
        this.setWarranty(productProperty.getWarranty()) ;
    }

    public static ProductForm getProductLaptop(){
        ProductForm productForm = new ProductForm();

    
        productForm.setName("Laptop name");
        productForm.setDescription("Description");
        productForm.setPrice(245.67);
        productForm.setItemInStock(99);
        
        productForm.setModel("model");


        // productForm.setBrand(1);
        productForm.setScreenSize("10.3 in");
        productForm.setScreenResolution("1920 x 1080");
        productForm.setProcessorType("Intel Celeron N4020");
        productForm.setProcessorCore("2");
        productForm.setProcessorSpeed("1.1 GHz");
        productForm.setProcessorCache("4 MB");
        productForm.setRamType("DDR4 2 khe (1 khe 4 GB + 1 khe 4 GB)");
        productForm.setRamSize("8 GB");
        productForm.setRamBus("3200 MHz");
        productForm.setRamMaxSize("32 GB");
        productForm.setStorageType("SSD");
        productForm.setStorageSize("512 GB");
        productForm.setStorageDesc("512 GB SSD NVMe PCIe (Có thể tháo ra)");
        productForm.setGraphicCardType("Integrated");
        productForm.setGraphicCardName("Intel UHD Graphics 600");
        productForm.setGraphicCardMemorySize("4 GB");
        productForm.setAudioDesc("Audio by B&ORealtek High Definition Audio");
        productForm.setIoPort("2 x USB 3.2");
        productForm.setIoBluetooth("Bluetooth 5.0");
        productForm.setIoCardReader("Micro SD");
        productForm.setIoWebcam("HD Webcam");
        productForm.setIoWifi("Wi-Fi 6 (802.11ax)");
        productForm.setPowerLife("Up to 9.3 Hours");
        productForm.setPowerBatteryCapacity("29 Wh");
        productForm.setPowerBatteryCell("2");
        productForm.setPowerBatteryType("Lithium Polymer");
        productForm.setSoftwareOs("Window 11");
        productForm.setPhysicColor("Graphite Grey");
        productForm.setPhysicDemensions("16.60 (W) x 0.99 (H) x 25.30 (D) cm");
        productForm.setPhysicWeight("1.92 lb");
        productForm.setWarranty("1 year");


        return productForm;
    }

    public static ProductForm getProductWatch(){
        ProductForm productForm = new ProductForm();

        
        productForm.setName("V8 Automatic Chronograph Men's Watch");
        productForm.setDescription("Description");
        productForm.setPrice(245.67);
        productForm.setItemInStock(99);
        
        productForm.setModel("T035.407.16.051.03");


        // productForm.setBrand(1);
        productForm.setSeries("Analog");
        productForm.setWatchLabel("Swiss made");
        productForm.setMovement("Analog");
        productForm.setEngine("ETA Caliber C01.211");
        productForm.setPowerReserve("45 hours");
        productForm.setCaseBack("Transparent");
        productForm.setCaseMaterial("Stainless Steel");
        productForm.setCaseShape("Round");
        productForm.setCaseSize(45.0);
        productForm.setCaseThickness(14.0);
        productForm.setBandColor("Black");
        productForm.setBandLenght(0.0);
        productForm.setBandMaterial("Leather");
        productForm.setBandType("Strap");
        productForm.setBandWidth(22.0);
        productForm.setDialCrystal("Scratch Resistant Sapphire");
        productForm.setDialType("Analog");
        productForm.setWaterResistance("100");

        return productForm;
    }
    

    public ProductForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductPropertyId() {
        return productPropertyId;
    }

    public void setProductPropertyId(int product_property) {
        this.productPropertyId = product_property;
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

    public boolean isNewItem() {
        return newItem;
    }

    public void setNewItem(boolean newItem) {
        this.newItem = newItem;
    }

    public boolean isHighlight() {
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

    public char getProductType() {
        return productType;
    }

    public void setProductType(char productType) {
        this.productType = productType;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
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

    public List<Image> getImageOnClouds() {
        return imageOnClouds;
    }

    public void setImageOnClouds(List<Image> imageOnClouds) {
        this.imageOnClouds = imageOnClouds;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
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
