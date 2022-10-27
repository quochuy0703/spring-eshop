package com.huymq.springeshop.entity;

import java.util.UUID;

public interface ProductJsonInterface {


    public int getId() ;


    public UUID getUuid();


    public String getName() ;


    public String getDescription() ;


    public double getPrice() ;


    public int getItemInStock() ;


    


    public String getModel() ;


    public String getImageUrl() ;
    public String getImageUrlShow() ;


    public char getProductType() ;


    public int getCountSeen() ;


    public int getCountSale() ;


    public int getStarOne() ;


    public int getStarTwo() ;


    public int getStarThree() ;


    public int getStarFour() ;


    public int getStarFive() ;


    public String getTitle() ;


    public String getHighlightImage() ;

    public String getHighlightDesc() ;


    public Brand getBrand();



    

}
