package com.farmline.farmline.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.farmline.farmline.services.WeatherService;

public class WeatherController {
    @FXML private Label weatherLabel;

    private WeatherService weatherService = new WeatherService();

    @FXML
    private void handleFetchWeather() {
        // Fetch and display formatted weather data
        String weatherData = weatherService.getFormattedWeatherData();
        weatherLabel.setText(weatherData);
    }

    @FXML
    private void goToProduce() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/farmline/farmline/views/produce.fxml"));
            Stage stage = (Stage) weatherLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToSales() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/farmline/farmline/views/sales.fxml"));
            Stage stage = (Stage) weatherLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        handleFetchWeather(); // Fetch weather data when the view loads
    }
}