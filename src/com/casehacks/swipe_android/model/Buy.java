package com.casehacks.swipe_android.model;

public class Buy {

    private String name;
    private Double price;

    public Buy(String name, Double price) {
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
