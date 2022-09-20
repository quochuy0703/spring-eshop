package com.huymq.springeshop.entity;

public interface LaptopPropertyInterface {
    
    default public String getScreenSize(){
        return null;
    };
   
    default public String getScreenResolution(){
        return null;
    };
    
    default public String getProcessorType(){
        return null;
    };
    
    default public String getProcessorCore(){
        return null;
    };
    
    default public String getProcessorSpeed(){
        return null;
    };
    
    default public String getProcessorCache() {
        return null;
    };
    

  
    default public void setScreenSize(String screenSize) {
       
    }
   
    default public void setScreenResolution(String screenResolution) {
       
    }
    
    
    default public void setProcessorCore(String processorCore) {
        
    }
    
    default public void setProcessorSpeed(String processorSpeed) {
      
    }
    
    default public void setProcessorCache(String processorCache) {
     
    }
    
    default public void setProcessorType(String processorType) {
        
    }


}
