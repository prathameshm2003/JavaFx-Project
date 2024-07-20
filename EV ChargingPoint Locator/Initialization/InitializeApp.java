package com.evlocator.initialize;

import com.evlocator.controller.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class InitializeApp extends Application {

    // Entry point for the JavaFX application
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create an instance of LoginController with the primary stage
        LoginController loginController = new LoginController(primaryStage);
        // Set the initial scene to the login scene from the LoginController
        primaryStage.setScene(loginController.getLoginScene(primaryStage));
        // Set the title of the primary stage window
        primaryStage.setTitle("Login");
        // Show the primary stage window
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

}
