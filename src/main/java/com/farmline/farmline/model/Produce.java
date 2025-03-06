package com.farmline.farmline.model;

public class Produce {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Produce(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (Qty: " + quantity + ", Price: $" + price + ")";
    }
}