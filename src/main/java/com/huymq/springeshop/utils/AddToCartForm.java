package com.huymq.springeshop.utils;

import java.util.UUID;

public class AddToCartForm {
    private int productId;
    private UUID uuid;
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
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    
}
