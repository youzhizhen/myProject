package com.liying.refactor;

public class Rental {
    
    private Moive movie;
    private int daysRented;
    
    public Rental(Moive movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
    public Moive getMovie() {
        return movie;
    }
    public void setMovie(Moive movie) {
        this.movie = movie;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }
    
}
