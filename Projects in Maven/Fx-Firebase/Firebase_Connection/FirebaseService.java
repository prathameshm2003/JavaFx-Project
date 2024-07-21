package com.firebase.firebase_connection;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import com.firebase.controller.LoginController;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FirebaseService handles Firebase authentication operations like sign up, login, and logout.
 */
public class FirebaseService {

    private TextField emailField;
    private PasswordField passwordField;
    private LoginController loginController;

    public FirebaseService(LoginController loginController, TextField emailField, PasswordField passwordField) {
        this.loginController = loginController;
        this.emailField = emailField;
        this.passwordField = passwordField;
    }

    /**
     * Signs up a new user using Firebase Authentication.
     * @return true if user sign up was successful, false otherwise.
     */
    public boolean signUp() {
        String email = emailField.getText();
        String password = passwordField.getText();
        try {
            // Create user request
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password)
                    .setDisabled(false);

            // Create user in Firebase Auth
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Successfully created user: " + userRecord.getUid());
            showAlert("Success", "User created successfully.");
            return true;
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to create user: " + e.getMessage());
            return false;
        }
    }

    /**
     * Logs in a user using Firebase Authentication.
     * @return true if user login was successful, false otherwise.
     */
    public boolean login() {
        String email = emailField.getText();
        String password = passwordField.getText();
        try {
            // Firebase API key (replace with your actual API key)
            String apiKey = "AIzaSyCzGIbCVDBO2G5Qh1aTcHoKBJhP-7KKHvY";
            // Firebase authentication URL
            URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + apiKey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);

            // Request body for login
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("email", email);
            jsonRequest.put("password", password);
            jsonRequest.put("returnSecureToken", true);

            // Send request
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonRequest.toString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Check response
            if (conn.getResponseCode() == 200) {
                showAlert(true);
                return true;
            } else {
                showAlert("Invalid Login", "Invalid credentials!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(false);
            return false;
        }
    }

    /**
     * Shows an alert dialog with the specified title and message.
     * @param title The title of the alert dialog.
     * @param message The message to display in the alert dialog.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Shows a welcome or invalid login message and updates the scene accordingly.
     * @param isLoggedIn true if login was successful, false otherwise.
     */
    private void showAlert(boolean isLoggedIn) {
        Label msg = new Label(isLoggedIn ? "Welcome" : "Invalid Login");
        msg.setAlignment(Pos.CENTER);
        Button logoutButton = new Button("Logout");
        VBox vBox = new VBox(100, msg, logoutButton);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginController.initializeLoginScene();
            }
        });
        Scene scene = new Scene(vBox, 400, 200);
        loginController.setPrimaryStageScene(scene);
    }
}
