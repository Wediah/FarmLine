package com.farmline.farmline.services;

import com.farmline.farmline.model.Produce;
import com.farmline.farmline.model.Sale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3307/farmers_market";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add produce
    public boolean addProduce(String name, int quantity, double price) {
        String query = "INSERT INTO produce (name, quantity, price) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, quantity);
            stmt.setDouble(3, price);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all produce
    public List<Produce> getAllProduce() {
        List<Produce> produceList = new ArrayList<>();
        String query = "SELECT * FROM produce";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produce produce = new Produce(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                );
                produceList.add(produce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produceList;
    }

    // Add sale
    public boolean addSale(int produceId, int quantitySold, double totalAmount, String saleDate) {
        String query = "INSERT INTO sales (produce_id, quantity_sold, total_amount, sale_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, produceId);
            stmt.setInt(2, quantitySold);
            stmt.setDouble(3, totalAmount);
            stmt.setString(4, saleDate);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all sales
    public List<Sale> getAllSales() {
        List<Sale> salesList = new ArrayList<>();
        String query = "SELECT * FROM sales";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Sale sale = new Sale(
                        rs.getInt("id"),
                        rs.getInt("produce_id"),
                        rs.getInt("quantity_sold"),
                        rs.getDouble("total_amount"),
                        rs.getString("sale_date")
                );
                salesList.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesList;
    }
}