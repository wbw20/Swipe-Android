package com.casehacks.swipe_android.model;

public class Sell {

    private String name;
    private Double price;

    public Sell(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String name() {
        return name;
    }

    public Double price() {
        return price;
    }
}
