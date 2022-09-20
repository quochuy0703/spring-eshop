package com.huymq.springeshop.utils;

public class ReviewForm {
    private int id;
    private int productId;
    private String content;
    private int star;

    
    @Override
    public String toString() {
        return "ReviewForm [content=" + content + ", id=" + id + ", productId=" + productId + "]";
    }
    public ReviewForm() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getStar() {
        return star;
    }
    public void setStar(int star) {
        this.star = star;
    }

    
}
