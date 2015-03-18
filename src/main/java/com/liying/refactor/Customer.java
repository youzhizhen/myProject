package com.liying.refactor;

import java.util.List;

import com.google.common.collect.Lists;

public class Customer {

    private String name;
    private List<Rental> rentals = Lists.newArrayList();

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }
    public String statement() {

        String result = "Rnetal Record for " + getName() + "/n";
        for (Rental each : rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getMovie().getPrice().getCharge(each.getDaysRented())) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\t";
        result += "Your rented " + String.valueOf(getTotalFrequrntPoints()) + " frequent renter points";

        return result;
    }

    //为了掉过多的临时变量（因为临时变量只有最该方法中有用的用函数代替可以再该类中到处使用）
    private double getTotalCharge(){
        double result = 0;
        for(Rental each : rentals){
            result += each.getMovie().getPrice().getCharge(each.getDaysRented());
        }
        return result;
    }
    
    
    private double getTotalFrequrntPoints(){
        double result = 0;
        for(Rental each : rentals){
            result += each.getMovie().getPrice().frequentRenterPoints(each.getDaysRented());
        }
        return result;
    }
    //1.找到所有的变量，值不变化的作为参数，值变化的（只有一个变量时）作为返回值
    //2.修改变量的名字
    //3.去掉调用函的多余变量（临时的变量多了多程序的性能有影响）
    //4.函数应该放到自己的对象里面（函数所使用的函数对象）
    //5.把不用的代码删除掉
    //6.用多态来代替switch case的逻辑计算
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

}
