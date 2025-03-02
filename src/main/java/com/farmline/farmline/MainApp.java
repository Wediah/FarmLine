package com.farmline.farmline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("/com/farmline/farmline/views/login.fxml"));

            // Set up the scene and stage
            primaryStage.setTitle("Farmers' Market Management");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}