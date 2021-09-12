package com.example.orderfood;

public class Food {
    String name;
    int price;
    int sl;

    public Food(String name, int sl) {
        this.name = name;
        this.sl = sl;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSl() {
        return sl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
}
