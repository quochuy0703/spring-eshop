package com.huymq.springeshop.utils;

public class AddToCartForm {
    private int productId;
    private int quantity;

    
    public AddToCartForm() {
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
