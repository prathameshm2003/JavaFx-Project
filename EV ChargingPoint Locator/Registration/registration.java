package com.evlocator.Registration;

import java.util.HashMap;
import java.util.Map;

import com.evlocator.firebaseConfig.DataService;
import com.evlocator.dashboards.Home;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class registration extends Application {
    // Declare labels
    private Label Name;
    private Label Address;
    private Label City;
    private Label Country;
    private Label CompanyName;
    private Label VehicleModel;
    private Label ChargingType;
    private Label PhnNum;
    private Label email;
    private Label Title;
    private Label EV;
    // private DataService dataServices;

    @Override
    public void start(Stage stage) {
        // Scene

        Title = new Label("EV Registration");

        Name = new Label("Name");
        Name.setFont(Font.font("Copperplate Gothic Light", 18));
        Name.setTranslateX(370);
        Name.setTranslateY(225);
        Name.setTextFill(Color.BLACK);
        TextField NameTextField = new TextField();

        NameTextField.setPrefWidth(421);
        NameTextField.setPrefHeight(40);

        Address = new Label("Address");
        Address.setFont(Font.font("Copperplate Gothic Light", 18));
        Address.setTextFill(Color.BLACK);
        Address.setTranslateX(370);
        Address.setTranslateY(300);
        TextField AddressTextField = new TextField();
        AddressTextField.setPrefWidth(421);
        AddressTextField.setPrefHeight(40);

        City = new Label("City");
        City.setFont(Font.font("Copperplate Gothic Light", 18));
        City.setTextFill(Color.BLACK);
        City.setTranslateX(370);
        City.setTranslateY(375);
        TextField CityTextField = new TextField();
        CityTextField.setPrefWidth(200);
        CityTextField.setPrefHeight(40);

        Country = new Label("Google map Link");
        Country.setFont(Font.font("Copperplate Gothic Light", 18));
        Country.setTextFill(Color.BLACK);
        Country.setTranslateX(590);
        Country.setTranslateY(375);
        TextField CountryTextField = new TextField();
        CountryTextField.setPrefWidth(200);
        CountryTextField.setPrefHeight(40);

        CompanyName = new Label("Company Name");
        CompanyName.setFont(Font.font("Copperplate Gothic Light", 18));
        CompanyName.setTextFill(Color.BLACK);
        CompanyName.setTranslateX(370);
        CompanyName.setTranslateY(450);
        TextField CompanyNameTextField = new TextField();
        CompanyNameTextField.setPrefWidth(421);
        CompanyNameTextField.setPrefHeight(40);

        VehicleModel = new Label("Charger Model");
        VehicleModel.setFont(Font.font("Copperplate Gothic Light", 18));
        VehicleModel.setTextFill(Color.BLACK);
        VehicleModel.setTranslateX(370);
        VehicleModel.setTranslateY(530);
        TextField VehicleModelTextField = new TextField();
        VehicleModelTextField.setPrefWidth(421);
        VehicleModelTextField.setPrefHeight(40);

        ChargingType = new Label("Charging Voltage");
        ChargingType.setFont(Font.font("Copperplate Gothic Light", 18));
        ChargingType.setTextFill(Color.BLACK);
        ChargingType.setTranslateX(370);
        ChargingType.setTranslateY(605);
        TextField ChargingTypeTextField = new TextField();
        ChargingTypeTextField.setPrefWidth(421);
        ChargingTypeTextField.setPrefHeight(40);

        PhnNum = new Label("Phone Number");
        PhnNum.setFont(Font.font("Copperplate Gothic Light", 18));
        PhnNum.setTextFill(Color.BLACK);
        PhnNum.setTranslateX(370);
        PhnNum.setTranslateY(685);
        TextField PhnNumTextField = new TextField();
        PhnNumTextField.setPrefWidth(421);
        PhnNumTextField.setPrefHeight(40);

        email = new Label("Email Id");
        email.setFont(Font.font("Copperplate Gothic Light", 18));
        email.setTextFill(Color.BLACK);
        email.setTranslateX(370);
        email.setTranslateY(760);
        TextField emailTextField = new TextField();
        emailTextField.setPrefWidth(421);
        emailTextField.setPrefHeight(40);

        VBox NameVBox = new VBox(NameTextField);
        NameVBox.setLayoutX(370);
        NameVBox.setLayoutY(250);
        NameVBox.setAlignment(Pos.CENTER);

        VBox AddressVBox = new VBox(AddressTextField);
        AddressVBox.setLayoutX(370);
        AddressVBox.setLayoutY(325);
        AddressVBox.setAlignment(Pos.CENTER);

        VBox CityVBox = new VBox(CityTextField);
        CityVBox.setLayoutX(370);
        CityVBox.setLayoutY(400);
        CityVBox.setAlignment(Pos.CENTER);

        VBox CountryVBox = new VBox(CountryTextField);
        CountryVBox.setLayoutX(590);
        CountryVBox.setLayoutY(400);
        CountryVBox.setAlignment(Pos.CENTER);

        VBox CompanyNameVBox = new VBox(CompanyNameTextField);
        CompanyNameVBox.setLayoutX(370);
        CompanyNameVBox.setLayoutY(475);
        CompanyNameVBox.setAlignment(Pos.CENTER);

        VBox VehicleModelVBox = new VBox(VehicleModelTextField);
        VehicleModelVBox.setLayoutX(370);
        VehicleModelVBox.setLayoutY(555);
        VehicleModelVBox.setAlignment(Pos.CENTER);

        VBox ChargingTypeVBox = new VBox(ChargingTypeTextField);
        ChargingTypeVBox.setLayoutX(370);
        ChargingTypeVBox.setLayoutY(630);
        ChargingTypeVBox.setAlignment(Pos.CENTER);

        VBox PhnNumVBox = new VBox(PhnNumTextField);
        PhnNumVBox.setLayoutX(370);
        PhnNumVBox.setLayoutY(710);
        PhnNumVBox.setAlignment(Pos.CENTER);

        VBox emailVBox = new VBox(emailTextField);
        emailVBox.setLayoutX(370);
        emailVBox.setLayoutY(785);
        emailVBox.setAlignment(Pos.CENTER);

        EV = new Label("EV REGISTRATION");
        EV.setFont(Font.font("Copperplate Gothic Bold", 40));
        EV.setTextFill(Color.BLACK);
        EV.setTranslateX(700);
        EV.setTranslateY(25);

        String bs2 = "-fx-background-color:lightgreen;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;";
        Button Submitbutton = new Button("Submit");
        Submitbutton.setFont(Font.font("Copperplate Gothic Light", 20));
        Submitbutton.setLayoutX(370);
        Submitbutton.setLayoutY(850);
        Submitbutton.setStyle(bs2);
        Submitbutton.setPrefWidth(421); // Set preferred width
        Submitbutton.setPrefHeight(50); // Set preferred height

        Submitbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSubmitB(stage, NameTextField.getText(), PhnNumTextField.getText(),
                        emailTextField.getText(), ChargingTypeTextField.getText(), VehicleModelTextField.getText(),
                        AddressTextField.getText(), CityTextField.getText(), CountryTextField.getText(),
                        CompanyNameTextField.getText()); // Handle
                // signup
            }
        });

        Group root = new Group();

        // Load the first background image
        Image image1 = new Image("/backg.png"); // Replace with your first image path
        ImageView imageView1 = new ImageView(image1);
        imageView1.fitWidthProperty().bind(stage.widthProperty());
        imageView1.fitHeightProperty().bind(stage.heightProperty());

        // Load the second background image
        Image image2 = new Image("/Register.png"); // Replace with your second image path
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(1300); // Adjust width as needed
        imageView2.setFitHeight(900); // Adjust height as needed
        imageView2.setPreserveRatio(true);
        imageView2.setX((1935 - imageView2.getFitWidth()) / 2);
        imageView2.setY((1050 - imageView2.getFitHeight()) / 2);
        // imageView2.setTranslateX(150); // Adjust the position of the second image
        // imageView2.setTranslateY(100);
        // imageView2.setPreserveRatio(true);
        // imageView2.setOpacity(0); // Adjust the opacity if needed

        // Add ImageViews to the Group
        root.getChildren().addAll(imageView1, imageView2);

        Group root1 = new Group();

        ObservableList<String> items = FXCollections.observableArrayList("Option1", "Option2", "Option3");
        ComboBox<String> comboBox = new ComboBox<>(items);
        comboBox.setValue("Select option");

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String selectedOption = comboBox.getValue();
                System.out.println("Selected Option: " + selectedOption);
            }
        });

        // Navigation Button
        Button homeButton = new Button("< BACK");
        homeButton.setLayoutX(70);
        homeButton.setLayoutY(50);
        homeButton.setStyle(
                "-fx-background-color:lightblue;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;");
        homeButton.setPrefWidth(100);
        homeButton.setPrefHeight(40);
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                navigateToHome(stage); // Navigate to home page
            }
        });

        root1.getChildren().add(comboBox);

        Group group = new Group(Title, root, Submitbutton, NameVBox, AddressVBox, CityVBox, CountryVBox,
                CompanyNameVBox,
                VehicleModelVBox,
                ChargingTypeVBox, PhnNumVBox, emailVBox, Name, Address,
                City, Country, CompanyName, VehicleModel, ChargingType, PhnNum, email, EV, homeButton);

        Scene scene = new Scene(group, 50, 50);
        stage.setScene(scene);
        stage.setTitle("My Java Project");
        stage.setResizable(true);
        stage.setX(0);
        stage.setY(0);
        stage.setWidth(2000);
        stage.setHeight(1000);
        stage.setMaximized(true);
        stage.show();

    }

    private void handleSubmitB(Stage pr, String name, String phone, String email, String chargingtype,
            String vehicleModel, String address, String city, String country, String companyName) {
        DataService dataServices; // Local instance of DataService
        try {
            dataServices = new DataService(); // Initialize DataService instance
            // Create a map to hold user data
            Map<String, Object> data = new HashMap<>();
            data.put("Name", name);
            data.put("Phn num", phone);
            data.put("email", email);
            data.put("chargingType", chargingtype);
            data.put("Vehicle model", vehicleModel);
            data.put("address", address);
            data.put("city", city);
            data.put("gmaplink", country);
            data.put("companyName", companyName);

            // Add user data to Firestore
            dataServices.addData("locations", name, data);
            System.out.println("Details submitted successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
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