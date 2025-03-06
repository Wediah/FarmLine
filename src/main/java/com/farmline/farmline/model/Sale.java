package com.farmline.farmline.model;

import java.util.Date;

public class Sale {
    private int id;
    private int produceId;
    private int quantitySold;
    private double totalAmount;
    private String saleDate;

    public Sale(int id, int produceId, int quantitySold, double totalAmount, String saleDate) {
        this.id = id;
        this.produceId = produceId;
        this.quantitySold = quantitySold;
        this.totalAmount = totalAmount;
        this.saleDate = saleDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public int getProduceId() { return produceId; }
    public int getQuantitySold() { return quantitySold; }
    public double getTotalAmount() { return totalAmount; }
    public String getSaleDate() { return saleDate; }

    @Override
    public String toString() {
        return "Sale ID: " + id + ", Produce ID: " + produceId + ", Qty Sold: " + quantitySold + ", Total: $" + totalAmount + ", Date: " + saleDate;
    }
}
