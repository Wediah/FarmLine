package com.farmline.farmline.services;

import com.farmline.farmline.model.Produce;
import java.sql.*;

public class ProduceService {
    public boolean addProduce(String name, int quantity, double price) {
        try (Connection conn = DatabaseService.getConnection()) {
            String query = "INSERT INTO produce (name, quantity, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, quantity);
            stmt.setDouble(3, price);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}