package com.evlocator.controller;

import com.evlocator.dashboards.Home;
import com.evlocator.firebaseConfig.DataService;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class SignupController {

    private LoginController loginController; // Reference to LoginController for navigation

    // Constructor to initialize the SignupController with the LoginController
    // reference
    public SignupController(LoginController loginController) {
        this.loginController = loginController;
    }

    // Method to create the signup scene
    public Scene createSignupScene(Stage primaryStage) {

        Text styledText11 = new Text("UserName");
        TextField userTextField = new TextField(); // TextField for username input
        styledText11.setFill(Color.WHITE);
        styledText11.setFont(Font.font("Copperplate Gothic Bold", 20));

        Text styledText12 = new Text("Password");
        styledText12.setFont(Font.font("Copperplate Gothic Bold", 20));
        styledText12.setFill(Color.WHITE);
        PasswordField passField = new PasswordField(); // PasswordField for password input

        String bs = "-fx-background-color:lightgreen;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;";
        Button signupButton = new Button("Signup"); // Button to trigger signup action
        signupButton.setStyle(bs);
        signupButton.setFont(Font.font("Copperplate Gothic Bold", 20));

        // Create VBox layouts for the fields and button
        VBox fieldBox1 = new VBox(10, styledText11, userTextField);
        fieldBox1.setMaxSize(300, 30);
        VBox fieldBox2 = new VBox(10, styledText12, passField);
        fieldBox2.setMaxSize(300, 30);
        HBox buttonBox = new HBox(50, signupButton);
        buttonBox.setMaxSize(350, 30);
        buttonBox.setAlignment(Pos.CENTER);

        // Set action for the signup button
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSignup(primaryStage, userTextField.getText(), passField.getText()); // Handle signup
            }
        });

        Button Button = new Button("<Back");
        Button.setLayoutX(50);
        Button.setLayoutY(50);
        Button.setStyle(
                "-fx-background-color:lightblue;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;");
        Button.setPrefWidth(100);
        Button.setPrefHeight(40);

        Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                navigateToLogin(primaryStage);
            }

        });

        VBox vbox = new VBox(20, fieldBox1, fieldBox2, buttonBox, Button);
        vbox.setStyle(
                "-fx-background-image:url('electric-car-with-headlights-glowing-and-plugged-into-a-charging-station.jpg')");
        vbox.setAlignment(Pos.CENTER);
        return new Scene(vbox, 600, 600); // Return the created scene
    }

    // Method to handle signup action
    private void handleSignup(Stage primaryStage, String username, String password) {
        DataService dataService; // Local instance of DataService
        try {
            dataService = new DataService(); // Initialize DataService instance
            // Create a map to hold user data
            Map<String, Object> data = new HashMap<>();
            data.put("password", password);
            data.put("username", username);
            // Add user data to Firestore
            dataService.addData("Signup", username, data);
            System.out.println("User registered successfully");

            // Navigate back to the login scene
            loginController.showLoginScene();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void navigateToLogin(Stage primaryStage) {
        Scene loginScene = loginController.getLoginScene(primaryStage);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}
