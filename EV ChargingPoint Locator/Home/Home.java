package com.evlocator.dashboards;

import com.evlocator.ContactDetails.Contact;
import com.evlocator.Registration.registration;
import com.evlocator.NearbyPoints.NearbyPoints;
import com.evlocator.controller.LoginController;
import com.evlocator.firebaseConfig.DataService;
import com.google.cloud.firestore.DocumentSnapshot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class Home {
    // private Stage primaryStage;

    static String userName; // Static variable to store the username
    private DataService dataService; // Service to interact with Firestore
    VBox vb; // VBox to hold the user scene components
    private Stage primaryStage;

    public Home(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createUserScene(primaryStage);
    }

    // Method to create the user scene
    public VBox createUserScene(Stage stage) {
        Label dataLabel = new Label();

        try {
            String key = LoginController.key; // Get the username key from LoginController
            System.out.println("Value of key: " + key);
            DocumentSnapshot dataObject = dataService.getData("users", key); // Get user data from Firestore

            userName = dataObject.getString("username"); // Fetch the username from the dataObject

            System.out.println("username fetched: " + userName);
            dataLabel.setText(userName); // Set the username in the label
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Load the background image
        Image backgroundImage = new Image("/backg.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1900); // Adjust width as needed
        backgroundImageView.setFitHeight(950); // Adjust height as needed
        backgroundImageView.setPreserveRatio(false);

        backgroundImageView.setX((1915 - backgroundImageView.getFitWidth()) / 2);
        backgroundImageView.setY((980 - backgroundImageView.getFitHeight()) / 2);

        Image backgroundImages = new Image("station.png");
        ImageView backgroundImageViews = new ImageView(backgroundImages);
        backgroundImageViews.setFitWidth(1650); // Adjust width as needed
        backgroundImageViews.setFitHeight(700); // Adjust height as needed
        backgroundImageViews.setPreserveRatio(true);

        backgroundImageViews.setX((3450 - backgroundImageViews.getFitWidth()) / 2);
        backgroundImageViews.setY((1000 - backgroundImageViews.getFitHeight()) / 2);

        Image backgroundImageone = new Image("Ellipse 7.png");
        ImageView backgroundImageViewone = new ImageView(backgroundImageone);
        backgroundImageViewone.setFitWidth(1100); // Adjust width as needed
        backgroundImageViewone.setFitHeight(900); // Adjust height as needed
        backgroundImageViewone.setPreserveRatio(true);

        backgroundImageViewone.setX((3070 - backgroundImageViewone.getFitWidth()) / 2);
        backgroundImageViewone.setY((936 - backgroundImageViewone.getFitHeight()) / 2);

        Image backgroundImage1 = new Image("Rectangle 8.png");
        ImageView backgroundImageView1 = new ImageView(backgroundImage1);
        backgroundImageView1.setFitWidth(800); // Adjust width as needed
        backgroundImageView1.setFitHeight(500); // Adjust height as needed
        backgroundImageView1.setPreserveRatio(true);

        backgroundImageView1.setX((4370 - backgroundImageView1.getFitWidth()) / 2);
        backgroundImageView1.setY((536 - backgroundImageView1.getFitHeight()) / 2);

        Image backgroundImage2 = new Image("Rectangle 9.png");
        ImageView backgroundImageView2 = new ImageView(backgroundImage2);
        backgroundImageView2.setFitWidth(800); // Adjust width as needed
        backgroundImageView2.setFitHeight(500); // Adjust height as needed
        backgroundImageView2.setPreserveRatio(true);

        backgroundImageView2.setX((4370 - backgroundImageView2.getFitWidth()) / 2);
        backgroundImageView2.setY((1425 - backgroundImageView2.getFitHeight()) / 2);

        Image backgroundImage3 = new Image("Ellipse 2.png");
        ImageView backgroundImageView3 = new ImageView(backgroundImage3);
        backgroundImageView3.setFitWidth(130); // Adjust width as needed
        backgroundImageView3.setFitHeight(80); // Adjust height as needed
        backgroundImageView3.setPreserveRatio(true);

        backgroundImageView3.setX((3620 - backgroundImageView3.getFitWidth()) / 2);
        backgroundImageView3.setY((1735 - backgroundImageView3.getFitHeight()) / 2);

        Image backgroundImage4 = new Image("logo.png");
        ImageView backgroundImageView4 = new ImageView(backgroundImage4);
        backgroundImageView4.setFitWidth(100); // Adjust width as needed
        backgroundImageView4.setFitHeight(80); // Adjust height as needed
        backgroundImageView4.setPreserveRatio(true);

        backgroundImageView4.setX((300 - backgroundImageView3.getFitWidth()) / 2);
        backgroundImageView4.setY((235 - backgroundImageView3.getFitHeight()) / 2);

        Color lightBlueColor = Color.rgb(202, 220, 236);

        // Create buttons
        Button button1 = createStyledButton("HOME", 100);
        Button button2 = createStyledButton("NEARBY POINTS", 100);
        Button button3 = createStyledButton("ADD-NEW", 100);
        Button button4 = createStyledButton("CONTACT", 100);
        Button button6 = createStyledButton("GO-TO-MAP", 100);

        // Set button positions manually
        button1.setLayoutX(300);
        button1.setLayoutY(100);

        button2.setLayoutX(650);
        button2.setLayoutY(100);

        button3.setLayoutX(1050);
        button3.setLayoutY(100);

        button4.setLayoutX(1350);
        button4.setLayoutY(100);

        String bs2 = "-fx-background-color:lightgreen;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;";
        button6.setLayoutX(100);
        button6.setLayoutY(650);
        button6.setStyle(bs2);

        button4.setOnAction(event -> navigateToContact(stage));
        button3.setOnAction(event -> openRegistrationPage(stage));
        button2.setOnAction(event -> navigateToNearbypoints(stage));

        Text styledText = new Text("L E T ' S      C R E A T E");

        // Setting the font and style
        styledText.setFont(Font.font("Times New Roman", 30));

        VBox vBox = new VBox(styledText);
        vBox.setLayoutX(100);
        vBox.setLayoutY(330);
        vBox.setAlignment(Pos.CENTER);

        Text styledText11 = new Text("F U T U R E");

        // Setting the font and style
        styledText11.setFont(Font.font("Consolas", FontWeight.BOLD, 115));

        VBox vBox1 = new VBox(styledText11);
        vBox1.setLayoutX(90);
        vBox1.setLayoutY(380);
        vBox1.setAlignment(Pos.CENTER);

        Text styledText13 = new Text("'Empowering Electric Journeys,Everywhere'");

        // Setting the font and style
        styledText13.setFont(Font.font("Copperplate Gothic Light", FontWeight.BOLD, 30));

        VBox vBox3 = new VBox(styledText13);
        vBox3.setLayoutX(900);
        vBox3.setLayoutY(850);
        vBox3.setAlignment(Pos.CENTER);

        Text styledText12 = new Text("EV-Charging Point Locator");

        // Setting the font and style
        styledText12.setFont(Font.font("Arial Rounded MT ", 20));

        VBox vBox2 = new VBox(styledText12);
        vBox2.setLayoutX(100);
        vBox2.setLayoutY(500);
        vBox2.setAlignment(Pos.CENTER);

        Group group = new Group(backgroundImageView, backgroundImageViewone, backgroundImageViews, backgroundImageView1,
                backgroundImageView2, backgroundImageView3, backgroundImageView4, button1, button2, button3, button4,
                button6, vBox, vBox1, vBox2, vBox3);
        group.setStyle("-fx-background-color: #" + lightBlueColor.toString().substring(2) + ";");

        vb = new VBox(350, group);
        vb.setStyle("-fx-background-color:lightblue"); // Set background color for
        // the VBox

        return vb;

    }

    // Method to create styled button
    private Button createStyledButton(String text, double minWidth) {
        String buttonStyle = "-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: grey; -fx-border-width: 0px; -fx-min-width:2px "
                + minWidth + "px;";
        Button button = new Button(text);
        button.setStyle(buttonStyle);
        button.setFont(Font.font("Arial Rounded MT Bold", FontWeight.BOLD, 20));
        return button;
    }

    private void navigateToContact(Stage stage) {
        Contact contactPage = new Contact();
        try {
            contactPage.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VBox getVb() {
        return vb;
    }

    private void openRegistrationPage(Stage stage) {
        registration registrationPage = new registration();
        // Stage registrationStage = new Stage();
        try {
            registrationPage.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void navigateToNearbypoints(Stage stage) {
        NearbyPoints NearbyPointsPage = new NearbyPoints();
        // Stage NearbyPointsStage = new Stage();
        try {
            NearbyPointsPage.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
