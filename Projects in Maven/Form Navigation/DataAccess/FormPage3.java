package com.c2w.dataAccess;

import com.c2w.controller.FormNavigationApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FormPage3 {
    private FormNavigationApp app;
    private GridPane view;
    private TextField field3;

    // Constructor for FormPage3
    public FormPage3(FormNavigationApp app) {
        this.app = app;
        initialize();
    }

    // Initialize the layout and components
    private void initialize() {
        // Create a GridPane layout
        view = new GridPane();
        view.setPadding(new Insets(10)); // Set padding around the layout
        view.setHgap(10); // Set horizontal gap between columns
        view.setVgap(10); // Set vertical gap between rows

        // Create and add a label for Field 3
        Label label3 = new Label("Field 3:");

        // Create a text field for user input
        field3 = new TextField();

        // Create a button to navigate back to the previous page
        Button backButton = new Button("Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.navigateToPage2(); // Navigate to Page2 when button is clicked
            }
        });

        // Create a button to clear the text field
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setField3Value(null); // Clear the text field when button is clicked
            }
        });

        // Add components to the GridPane
        view.add(label3, 0, 0); // Add label to column 0, row 0
        view.add(field3, 1, 0); // Add text field to column 1, row 0
        view.add(backButton, 0, 1); // Add back button to column 0, row 1
        view.add(clearButton, 2, 1); // Add clear button to column 2, row 1
    }

    // Method to get the view of the page
    public GridPane getView() {
        return view;
    }

    // Method to get the value of Field 3
    public String getField3Value() {
        return field3.getText();
    }

    // Method to set the value of Field 3
    public void setField3Value(String value) {
        field3.setText(value);
    }
}