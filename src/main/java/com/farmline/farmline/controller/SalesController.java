package com.farmline.farmline.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import com.farmline.farmline.model.Sale;
import com.farmline.farmline.services.DatabaseService;

public class SalesController {
    @FXML private TextField produceIdField;
    @FXML private TextField quantitySoldField;
    @FXML private TextField totalAmountField;
    @FXML private TextField saleDateField;
    @FXML private Label statusLabel;
    @FXML private ListView<String> salesList;

    private DatabaseService dbService = new DatabaseService();

    @FXML
    private void handleAddSale() {
        int produceId = Integer.parseInt(produceIdField.getText());
        int quantitySold = Integer.parseInt(quantitySoldField.getText());
        double totalAmount = Double.parseDouble(totalAmountField.getText());
        String saleDate = saleDateField.getText();

        if (dbService.addSale(produceId, quantitySold, totalAmount, saleDate)) {
            statusLabel.setText("Sale recorded successfully!");
            loadSalesList();
        } else {
            statusLabel.setText("Failed to record sale.");
        }
    }

    private void loadSalesList() {
        salesList.getItems().clear();
        for (Sale sale : dbService.getAllSales()) {
            salesList.getItems().add(sale.toString());
        }
    }

    @FXML
    private void goToProduce() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/farmline/farmline/views/produce.fxml"));
            Stage stage = (Stage) produceIdField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToWeather() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/farmline/farmline/views/weather.fxml"));
            Stage stage = (Stage) produceIdField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        loadSalesList();
    }
}
