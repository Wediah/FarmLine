package com.farmline.farmline.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import com.farmline.farmline.model.Produce;
import com.farmline.farmline.services.DatabaseService;

public class ProduceController {
    @FXML private TextField nameField;
    @FXML private TextField quantityField;
    @FXML private TextField priceField;
    @FXML private Label statusLabel;
    @FXML private ListView<String> produceList;

    private DatabaseService dbService = new DatabaseService();

    @FXML
    private void handleAddProduce() {
        String name = nameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());

        if (dbService.addProduce(name, quantity, price)) {
            statusLabel.setText("Produce added successfully!");
            loadProduceList();
        } else {
            statusLabel.setText("Failed to add produce.");
        }
    }

    private void loadProduceList() {
        produceList.getItems().clear();
        for (Produce produce : dbService.getAllProduce()) {
            produceList.getItems().add(produce.toString());
        }
    }

    @FXML
    private void goToSales() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/farmline/farmline/views/sales.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToWeather() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/farmline/farmline/views/weather.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        loadProduceList();
    }
}