package com.imgapi.service;

import java.io.IOException;

import org.json.JSONObject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class APIService extends Application {

    // String to store the image URL
    static String imgURL = "";

    // Method to GET the image data from the API, assigns the value to imgURL
    public static void imageData() throws IOException {
        // Calling method DataUrls class to get the image
        StringBuffer response = new DataUrls().getResponseData();

        if (response != null) {
            // Parse the JSON response to get the image URL
            JSONObject obj = new JSONObject(response.toString());
            JSONObject urlObject = obj.getJSONObject("urls");

            // Assign the image URL to the static variable imgURL
            imgURL = urlObject.getString("small");
        } else {
            System.out.println("Response is empty");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Fetch the image data from the API
        imageData();

        // Create an Image object using the fetched image URL
        Image image = new Image(imgURL);

        // Create an ImageView and set the image
        ImageView imageView = new ImageView(image);

        // Create a FlowPane and add the ImageView to it
        Pane imgPane = new Pane();
        imgPane.getChildren().add(imageView);

        // Create the scene and set it on the stage
        Scene scene = new Scene(imgPane, image.getWidth(), image.getHeight());
        primaryStage.setScene(scene);

        // Set the title of the stage
        primaryStage.setTitle("ImageView Example");

        // Display the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
