package com.liying.refactor;

public class ChildrenPrice extends Price{

    @Override
    int getPriceCode() {
        return Moive.CHILDREN;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

}
