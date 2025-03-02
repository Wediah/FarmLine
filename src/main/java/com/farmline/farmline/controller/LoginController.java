package com.farmline.farmline.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import com.farmline.farmline.services.UserService;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;

    private UserService userService = new UserService();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (userService.loginUser(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (userService.registerUser(username, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed!");
        }
    }

    @FXML
    private void handleNavigateToProduce() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/produce.fxml"));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}