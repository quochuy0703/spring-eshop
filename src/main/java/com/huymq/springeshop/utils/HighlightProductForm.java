package com.huymq.springeshop.utils;

public class HighlightProductForm {
    private String highlightDesc;
    private String title;
    private boolean highlight;
    private boolean edit;
    
    public String getHighlightDesc() {
        return highlightDesc;
    }
    public void setHighlightDesc(String highlightDesc) {
        this.highlightDesc = highlightDesc;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isHighlight() {
        return highlight;
    }
    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }
    public boolean isEdit() {
        return edit;
    }
    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    
}
