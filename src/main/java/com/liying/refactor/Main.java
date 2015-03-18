package com.liying.refactor;

import java.util.List;

import com.google.common.collect.Lists;

public class Main {
    
    public static void main(String[] args) {
        Moive m = new Moive("平凡的世界", Moive.CHILDREN);
        Rental r1 = new Rental(m, 6);
        List<Rental> rentals = Lists.newArrayList();
        rentals.add(r1);
        Customer c = new Customer("liying", rentals );
        System.out.println(c.statement());
    }

}
