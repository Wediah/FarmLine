package com.farmline.farmline.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.farmline.farmline.services.WeatherService;
import javafx.stage.Stage;

public class WeatherController {
    @FXML
    private Label weatherLabel;

    private WeatherService weatherService = new WeatherService();

    @FXML
    private void handleFetchWeather() {
        String weatherData = weatherService.getWeatherData();
        if (weatherData != null) {
            weatherLabel.setText(weatherData);
        } else {
            weatherLabel.setText("Failed to fetch weather data.");
        }
    }

    @FXML
    private void handleNavigateToLogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            Stage stage = (Stage) weatherLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}