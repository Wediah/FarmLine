package com.farmline.farmline.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import com.farmline.farmline.services.ProduceService;
import javafx.stage.Stage;

public class ProduceController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField priceField;

    private ProduceService produceService = new ProduceService();

    @FXML
    private void handleAddProduce() {
        String name = nameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());

        if (produceService.addProduce(name, quantity, price)) {
            System.out.println("Produce added successfully!");
        } else {
            System.out.println("Failed to add produce.");
        }
    }

    @FXML
    private void handleNavigateToSales() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/sales.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}