package com.evlocator.NearbyPoints;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.evlocator.dashboards.Home;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class NearbyPoints extends Application {
    WebView webView = new WebView();
    public static Firestore db;

    public static void main(String[] args) {
        // Initialize Firebase
        initializeFirebase();
        launch(args);
    }

    private static void initializeFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream(
                    "locator/src/main/java/com/evlocator/firebaseConfig/ev-locator.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://ev-locator-1b393.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

            db = FirestoreClient.getFirestore();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a VBox for the charging station info boxes
        VBox stationInfoBox = new VBox(10);
        stationInfoBox.setPadding(new Insets(10));
        stationInfoBox.setAlignment(Pos.TOP_CENTER);

        // Fetch data from Firestore and populate the VBox
        fetchDataAndPopulate(stationInfoBox);

        // Make the VBox scrollable
        ScrollPane scrollPane = new ScrollPane(stationInfoBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setMaxWidth(400); // Set a fixed width for the info box pane

        Button homeButton = new Button("<Back");
        homeButton.setLayoutX(50);
        homeButton.setLayoutY(50);
        homeButton.setStyle(
                "-fx-background-color:lightblue;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;");
        homeButton.setPrefWidth(100);
        homeButton.setPrefHeight(40);

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                navigateToHome(primaryStage);
            }

        });

        BorderPane borderPane = new BorderPane();

        // Set the homeButton to the top-left corner
        BorderPane.setAlignment(homeButton, Pos.TOP_LEFT);
        BorderPane.setMargin(homeButton, new Insets(10));

        // Set the ScrollPane with station info boxes to the left
        borderPane.setLeft(scrollPane);

        // Set WebView to the center
        borderPane.setCenter(webView);

        // Add homeButton to the top-left corner of the BorderPane
        borderPane.setTop(homeButton);

        // Load background image
        Image backgroundImage = new Image("/doodle2.png");

        // Create a BackgroundImage
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));

        // Set the background to the BorderPane
        borderPane.setBackground(new Background(background));

        Scene scene = new Scene(borderPane, 1200, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("My Java Project");
        primaryStage.setResizable(true);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setWidth(2000);
        primaryStage.setHeight(1000);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void fetchDataAndPopulate(VBox stationInfoBox) {
        ApiFuture<QuerySnapshot> future = db.collection("locations").get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                String companyName = document.getString("companyName");
                String name = document.getString("Name");
                String address = document.getString("address");
                String googleMapsUrl = document.getString("gmaplink");

                VBox box = createInfoBox(companyName, name, address, googleMapsUrl);
                stationInfoBox.getChildren().add(box);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private VBox createInfoBox(String companyName, String name, String address, String googleMapsUrl) {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER_LEFT);
        box.setStyle("-fx-border-color: grey; -fx-border-width: 1px;-fx-background-color:lightblue;");

        Label companyLabel = new Label("Company: " + companyName);
        companyLabel.setFont(Font.font("Arial", 16));
        companyLabel.setTextFill(Color.BLACK);

        Label nameLabel = new Label("Name: " + name);
        nameLabel.setFont(Font.font("Arial", 16));
        nameLabel.setTextFill(Color.BLACK);

        Label addressLabel = new Label("Address: " + address);
        addressLabel.setFont(Font.font("Arial", 16));
        addressLabel.setTextFill(Color.BLACK);

        String bs = "-fx-background-color:lightgreen;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;";
        Button button = new Button("Get to Location");
        button.setStyle(bs);
        button.setPrefWidth(350); // Set the preferred width for the button
        button.setOnAction(event -> {
            try {
                String encodedUrl = "https://www.google.com/maps?q=" + URLEncoder.encode(googleMapsUrl, "UTF-8");
                webView.getEngine().load(encodedUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        box.getChildren().addAll(companyLabel, nameLabel, addressLabel, button);

        return box;
    }

    private void navigateToHome(Stage pr) {
        Home homePage = new Home(pr);
        Scene scene = new Scene(homePage.getVb());
        pr.setScene(scene);
        pr.show();
        try {
            homePage.createUserScene(pr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
