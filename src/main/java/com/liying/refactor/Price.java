package com.liying.refactor;

public abstract class Price {

    abstract int getPriceCode();
    
    abstract double getCharge(int daysRentals);
    
    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
