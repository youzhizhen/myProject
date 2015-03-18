package com.liying.refactor;

public class NewReleasePrice extends Price{

    @Override
    int getPriceCode() {
        return Moive.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
    @Override
    public int frequentRenterPoints(int daysRented) {
        return 2;
    }
}
