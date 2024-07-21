package com.firebase.controller;

import java.io.FileInputStream;
import java.io.IOException;
import com.firebase.firebase_connection.FirebaseService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * LoginController manages the login UI and interactions with FirebaseService.
 */
public class LoginController extends Application {
    private Stage primaryStage;
    private FirebaseService firebaseService;
    @SuppressWarnings("unused")
    private Scene scene;

    public void setPrimaryStageScene(Scene scene) {
        primaryStage.setScene(scene);
    }

    public void initializeLoginScene() {
        Scene loginScene = createLoginScene();
        this.scene = loginScene;
        primaryStage.setScene(loginScene);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Initialize Firebase App
        try {
            FileInputStream serviceAccount = new FileInputStream("fx_firebase/src/main/resources/fx-auth-fb.json");
            @SuppressWarnings("deprecation")
            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://fx-authentication-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create initial login scene
        Scene scene = createLoginScene();
        this.scene = scene;
        primaryStage.setTitle("Firebase Auth Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Creates the initial login scene.
     * 
     * @return The Scene object representing the login UI.
     */
    private Scene createLoginScene() {
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button signUpButton = new Button("Sign Up");
        Button loginButton = new Button("Log In");

        firebaseService = new FirebaseService(this, emailField, passwordField);

        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                firebaseService.signUp();
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                firebaseService.login();
            }
        });

        VBox fieldBox = new VBox(20, emailField, passwordField);
        HBox buttonBox = new HBox(20, loginButton, signUpButton);
        VBox comBox = new VBox(10, fieldBox, buttonBox);
        Pane viewPane = new Pane(comBox);
        return new Scene(viewPane, 400, 200);
    }
}
