package com.farmline.farmline.services;

import java.sql.*;

public class SalesService {
    public boolean recordSale(int produceId, int quantitySold, double totalAmount) {
        try (Connection conn = DatabaseService.getConnection()) {
            String query = "INSERT INTO sales (produce_id, quantity_sold, total_amount, sale_date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, produceId);
            stmt.setInt(2, quantitySold);
            stmt.setDouble(3, totalAmount);
            stmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            stmt.executeUpdate();

            query = "UPDATE produce SET quantity = quantity - ? WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, quantitySold);
            stmt.setInt(2, produceId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}