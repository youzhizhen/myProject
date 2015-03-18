package com.liying.refactor;

public class RegularPrice extends Price{

    @Override
    int getPriceCode() {
        return Moive.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

}
