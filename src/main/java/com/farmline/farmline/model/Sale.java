package com.farmline.farmline.model;

import java.util.Date;

public class Sale {
    private int id;
    private int produceId;
    private int quantitySold;
    private double totalAmount;
    private Date saleDate;

    public Sale() {}

    public Sale(int id, int produceId, int quantitySold, double totalAmount, Date saleDate) {
        this.id = id;
        this.produceId = produceId;
        this.quantitySold = quantitySold;
        this.totalAmount = totalAmount;
        this.saleDate = saleDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProduceId() { return produceId; }
    public void setProduceId(int produceId) { this.produceId = produceId; }

    public int getQuantitySold() { return quantitySold; }
    public void setQuantitySold(int quantitySold) { this.quantitySold = quantitySold; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public Date getSaleDate() { return saleDate; }
    public void setSaleDate(Date saleDate) { this.saleDate = saleDate; }
}
