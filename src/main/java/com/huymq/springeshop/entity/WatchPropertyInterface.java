package com.huymq.springeshop.entity;

public interface WatchPropertyInterface {

   


    public String getSeries();


    public boolean isGender();


    public String getWatchLabel();


    public String getMovement();


    public String getEngine();


    public char getType();


   
    
    public void setSeries(String series);
    public void setGender(boolean gender);
    public void setWatchLabel(String watchLabel);
    public void setMovement(String movement);
    public void setEngine(String engine);
    public void setType(char type);


    default public String getPowerReserve() {
        return null;
    }

    default public void setPowerReserve(String powerReserve) {
        
    }

    default public Double getCaseSize() {
        return null;
    }

    default public void setCaseSize(Double caseSize) {
       
    }

    default public Double getCaseThickness() {
        return null;
    }

    default  void setCaseThickness(Double caseThickness) {
        
    }

    default public String getCaseMaterial() {
        return null;
    }

    default public void setCaseMaterial(String caseMaterial) {
       
    }

    default public String getCaseShape() {
        return null;
    }

    default public void setCaseShape(String caseShape) {
        
    }

    default public String getCaseBack() {
        return null;
    }

    default public void setCaseBack(String caseBack) {
        
    }

    default public String getBandMaterial() {
        return null;
    }

    default public void setBandMaterial(String bandMaterial) {
        
    }

    default public String getBandType() {
        return null;
    }

    default public void setBandType(String bandType) {
        
    }

    default public String getBandColor() {
        return null;
    }

    default public void setBandColor(String bandColor) {
        
    }

    default public Double getBandLenght() {
        return null;
    }

    default public void setBandLenght(Double bandLenght) {
        
    }

    default public Double getBandWidth() {
        return null;
    }

    default public void setBandWidth(Double bandWidth) {
       
    }

    default public String getDialType() {
        return null;
    }

    default public void setDialType(String dialType) {
       
    }

    default public String getDialCrystal() {
        return null;
    }

    default public void setDialCrystal(String dialCrystal) {
        
    }

    default public String getWaterResistance() {
        return null;
    }

    default public void setWaterResistance(String waterResistance) {
        
    }


    
    
}
