package com.liying.refactor;

public class Moive {
    
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    
    private String title;
    private Price price;
    
    public Moive(String title, int priceCode) {
       this.title = title;
       setPriceCode(priceCode);
    }
    
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
        case REGULAR:
            price = new RegularPrice();
            break;
            
        case NEW_RELEASE:
            price = new NewReleasePrice();
            break;
            
        case CHILDREN:
            price = new ChildrenPrice();
            break;
        }
    }
}
