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
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.concurrent.ExecutionException;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

public class LoginController {

    private Stage primaryStage; // The primary stage for displaying scenes
    private Scene loginScene; // Scene for the login page
    private Scene userScene; // Scene for the user dashboard
    private DataService dataService; // Service to interact with Firestore
    public static String key; // Static key to store the logged-in username

    // Constructor to initialize the LoginController with the primary stage
    public LoginController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        dataService = new DataService(); // Initialize DataService instance
        initScenes(); // Initialize scenes
    }

    // Method to initialize all scenes
    private void initScenes() {
        initLoginScene(); // Initialize the login scene
    }

    // Method to initialize the login scene
    private void initLoginScene() {

        Text styledText11 = new Text("UserName");
        styledText11.setFill(Color.WHITE);
        styledText11.setFont(Font.font("Copperplate Gothic Bold", 20));
        TextField userTextField = new TextField(); // TextField for username input

        Text styledText12 = new Text("Password");
        styledText12.setFill(Color.WHITE);
        styledText12.setFont(Font.font("Copperplate Gothic Bold", 20));
        PasswordField passField = new PasswordField(); // PasswordField for password input

        String bs = "-fx-background-color:lightgreen;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;";
        Button loginButton = new Button("Login"); // Button to trigger login action
        loginButton.setStyle(bs);
        loginButton.setFont(Font.font("Copperplate Gothic Bold", 20));
        String bs1 = "-fx-background-color:lightgreen;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;";
        Button signupButton = new Button("Signup"); // Button to navigate to signup scene
        signupButton.setStyle(bs1);
        signupButton.setFont(Font.font("Copperplate Gothic Bold", 20));

        // Set action for the login button
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Login");
                handleLogin(userTextField.getText(), passField.getText()); // Handle login
                userTextField.clear(); // Clear username field
                passField.clear(); // Clear password field
            }
        });

        // Set action for the signup button
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Signup");
                showSignupScene(); // Show signup scene
                userTextField.clear(); // Clear username field
                passField.clear(); // Clear password field
            }
        });

        styledText11.setStyle("-fx-text-fill: white;");
        styledText12.setStyle("-fx-text-fill: white;");

        // Create VBox layouts for the fields and buttons
        VBox fieldBox1 = new VBox(10, styledText11, userTextField);
        fieldBox1.setMaxSize(300, 30);
        VBox fieldBox2 = new VBox(10, styledText12, passField);
        fieldBox2.setMaxSize(300, 30);
        HBox buttonBox = new HBox(50, loginButton, signupButton);
        buttonBox.setMaxSize(350, 30);
        buttonBox.setAlignment(Pos.CENTER);

        userTextField.setStyle("-fx-set-pref-width:350");
        passField.setStyle("-fx-set-pref-width:350");

        Image image = new Image("Evcar.jpg"); // Replace with your image path

        // Creating an ImageView to display the image
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(2000);
        imageView.setFitHeight(1200);
        imageView.setPreserveRatio(true);

        // Creating a VBox layout container
        VBox vbox = new VBox();
        vbox.getChildren().add(imageView);

        VBox vbox1 = new VBox(20, fieldBox1, fieldBox2, buttonBox);
        vbox1.setStyle(
                "-fx-background-image:url('electric-car-with-headlights-glowing-and-plugged-into-a-charging-station.jpg')");
        vbox1.setAlignment(Pos.CENTER);
        loginScene = new Scene(vbox1, 600, 600);
    }

    // Method to initialize the user scene
    private void initUserScene() {
        Home userPage = new Home(primaryStage); // Create UserPage instance
        userScene = new Scene(userPage.createUserScene(primaryStage)); // Create user scene
        primaryStage.setScene(userScene);
        // primaryStage.setX(600);
        // primaryStage.setY(250);
        primaryStage.setMaximized(true);
    }

    // Method to get the login scene
    public Scene getLoginScene(Stage primaryStage2) {
        return loginScene;
    }

    // Method to show the login scene
    public void showLoginScene() {
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    // Method to handle login action
    private void handleLogin(String username, String password) {
        try {
            // Authenticate user
            if (dataService.authenticateUser(username, password)) {
                key = username; // Store the username in the static key
                initUserScene(); // Initialize user scene
                primaryStage.setScene(userScene); // Show user scene
                primaryStage.setTitle("User Dashboard");
            } else {
                System.out.println("Invalid credentials");
                key = null;
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // Method to show the signup scene
    private void showSignupScene() {
        SignupController signupController = new SignupController(this); // Create SignupController instance
        Scene signupScene = signupController.createSignupScene(primaryStage); // Create signup scene
        primaryStage.setScene(signupScene);
        primaryStage.setTitle("My Java Project");
        primaryStage.setResizable(true);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setWidth(2000);
        primaryStage.setHeight(1000);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

}
