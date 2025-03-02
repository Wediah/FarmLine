package com.farmline.farmline.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import com.farmline.farmline.services.SalesService;
import javafx.stage.Stage;

public class SalesController {
    @FXML
    private TextField produceIdField;
    @FXML
    private TextField quantitySoldField;
    @FXML
    private TextField totalAmountField;

    private SalesService salesService = new SalesService();

    @FXML
    private void handleRecordSale() {
        int produceId = Integer.parseInt(produceIdField.getText());
        int quantitySold = Integer.parseInt(quantitySoldField.getText());
        double totalAmount = Double.parseDouble(totalAmountField.getText());

        if (salesService.recordSale(produceId, quantitySold, totalAmount)) {
            System.out.println("Sale recorded successfully!");
        } else {
            System.out.println("Failed to record sale.");
        }
    }

    @FXML
    private void handleNavigateToWeather() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/weather.fxml"));
            Stage stage = (Stage) produceIdField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
