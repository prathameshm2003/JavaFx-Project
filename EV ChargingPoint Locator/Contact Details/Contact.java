package com.evlocator.ContactDetails;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

import com.evlocator.dashboards.Home;
import com.evlocator.firebaseConfig.DataService;

public class Contact extends Application {
    private Label Name;
    private Label Email;
    private Label PhnNum;
    private Label phoneNum;
    private Label email;

    @Override
    public void start(Stage pr) throws Exception {

        Image backgroundImage1 = new Image("Design_Contact Us.png");
        ImageView backgroundImageView1 = new ImageView(backgroundImage1);

        Image backgroundImage2 = new Image("Contact Us.png");
        ImageView backgroundImageView2 = new ImageView(backgroundImage2);
        backgroundImageView2.setFitWidth(1300); // Adjust width as needed
        backgroundImageView2.setFitHeight(1100); // Adjust height as needed
        backgroundImageView2.setPreserveRatio(true);
        backgroundImageView2.setX((1935 - backgroundImageView2.getFitWidth()) / 2);
        backgroundImageView2.setY((1380 - backgroundImageView2.getFitHeight()) / 2);

        Image backgroundImage3 = new Image("map.png");
        ImageView backgroundImageView3 = new ImageView(backgroundImage3);
        backgroundImageView3.setFitWidth(400); // Adjust width as needed
        backgroundImageView3.setFitHeight(600); // Adjust height as needed
        backgroundImageView3.setX((2400 - backgroundImageView3.getFitWidth()) / 2);
        backgroundImageView3.setY((975 - backgroundImageView3.getFitHeight()) / 2);

        ImageView Image1 = new ImageView("call.png");
        Image1.setFitWidth(25); // Adjust width as needed
        Image1.setFitHeight(25); // Adjust height as needed
        Image1.setPreserveRatio(true);
        Image1.setX((1020 - Image1.getFitWidth()) / 2);
        Image1.setY((1500 - Image1.getFitHeight()) / 2);

        phoneNum = new Label("9359125174");
        phoneNum.setTranslateX(530);
        phoneNum.setTranslateY(738);

        ImageView Image2 = new ImageView("email.png");
        Image2.setFitWidth(25); // Adjust width as needed
        Image2.setFitHeight(25); // Adjust height as needed
        Image2.setPreserveRatio(true);
        Image2.setX((1300 - Image2.getFitWidth()) / 2);
        Image2.setY((1500 - Image2.getFitHeight()) / 2);

        email = new Label("mandhareprathamesh729@gmail.com");
        email.setTranslateX(670);
        email.setTranslateY(738);

        Text styledText1 = new Text("Get in");

        // Setting the font and style
        styledText1.setFont(Font.font("Times New Roman", 60));

        VBox vBox1 = new VBox(styledText1);
        vBox1.setLayoutX(500);
        vBox1.setLayoutY(220);
        vBox1.setAlignment(Pos.CENTER);

        Text styledText2 = new Text("Touch");

        // Setting the font and style
        styledText2.setFont(Font.font("Times New Roman", 60));
        styledText2.setFill(Color.LIGHTGREEN);

        VBox vBox2 = new VBox(styledText2);
        vBox2.setLayoutX(685);
        vBox2.setLayoutY(220);
        vBox2.setAlignment(Pos.CENTER);

        Name = new Label("Name");
        Name.setTranslateX(500);
        Name.setTranslateY(300);
        TextField NameTextField = new TextField();
        NameTextField.setPrefWidth(421);
        NameTextField.setPrefHeight(40);

        VBox NameVBox = new VBox(NameTextField);
        NameVBox.setLayoutX(500);
        NameVBox.setLayoutY(330);
        NameVBox.setAlignment(Pos.CENTER);

        Email = new Label("Email");
        Email.setTranslateX(500);
        Email.setTranslateY(390);
        TextField EmailTextField = new TextField();
        EmailTextField.setPrefWidth(421);
        EmailTextField.setPrefHeight(40);

        VBox EmailVBox = new VBox(EmailTextField);
        EmailVBox.setLayoutX(500);
        EmailVBox.setLayoutY(420);
        EmailVBox.setAlignment(Pos.CENTER);

        PhnNum = new Label("Phone Number");
        PhnNum.setTranslateX(500);
        PhnNum.setTranslateY(480);
        TextField PhnNumTextField = new TextField();
        PhnNumTextField.setPrefWidth(421);
        PhnNumTextField.setPrefHeight(40);

        VBox PhnNumVBox = new VBox(PhnNumTextField);
        PhnNumVBox.setLayoutX(500);
        PhnNumVBox.setLayoutY(510);
        PhnNumVBox.setAlignment(Pos.CENTER);

        String bs2 = "-fx-background-color:lightgreen;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;";
        Button submitbutton = new Button("Submit");
        submitbutton.setLayoutX(500);
        submitbutton.setLayoutY(660);
        submitbutton.setStyle(bs2);
        submitbutton.setPrefWidth(421); // Set preferred width
        submitbutton.setPrefHeight(50); // Set preferred height

        submitbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSubmit(pr, NameTextField.getText(), EmailTextField.getText(), PhnNumTextField.getText());
            }
        });

        // Create a list of items for the ComboBox
        ObservableList<String> items = FXCollections.observableArrayList(
                "Friend's recommendation", "Internet search", "Advertisement", "Other");
        ComboBox<String> comboBox = new ComboBox<>(items);
        comboBox.setValue("How did you find us?");
        comboBox.setLayoutX(500);
        comboBox.setLayoutY(590);
        comboBox.setMinWidth(421);
        comboBox.setMaxWidth(300);
        comboBox.setMinHeight(30);
        comboBox.setMaxHeight(50);

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String selectedOption = comboBox.getValue();
                System.out.println("Selected Option: " + selectedOption);
            }
        });

        // Navigation Button
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
                navigateToHome(pr);
            }

        });

        Group grp = new Group(backgroundImageView1, backgroundImageView2, backgroundImageView3, Image1, Image2, vBox1,
                vBox2, Name, NameVBox,
                EmailVBox, PhnNum, PhnNumVBox, Email, comboBox, submitbutton, phoneNum, email, homeButton);

        Scene scene = new Scene(grp, 50, 50);
        pr.setScene(scene);
        pr.setTitle("My Java Project");
        pr.setResizable(true);
        pr.setX(0);
        pr.setY(0);
        pr.setWidth(2000);
        pr.setHeight(1000);
        pr.setMaximized(true);
        pr.show();
    }

    private void handleSubmit(Stage pr, String name, String email, String phone) {
        DataService dataService;
        try {
            dataService = new DataService();
            Map<String, Object> data = new HashMap<>();
            data.put("Name", name);
            data.put("Email", email);
            data.put("Phn Num", phone);
            dataService.addData("Contact Details", name, data);
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