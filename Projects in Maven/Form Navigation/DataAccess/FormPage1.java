package com.c2w.dataAccess;

import com.c2w.controller.FormNavigationApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FormPage1 {
    private FormNavigationApp app;
    private GridPane view;
    private TextField field1;

    // Constructor for FormPage1
    public FormPage1(FormNavigationApp app) {
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

        // Create and add a label for Field 1
        Label label1 = new Label("Field 1:");
        field1 = new TextField();

        // Create a button to navigate to the next page
        Button nextButton = new Button("Next");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
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
                setField1Value(null); // Clear the text field when button is clicked
            }
        });

        // Add components to the GridPane
        view.add(label1, 0, 0); // Add label to column 0, row 0
        view.add(field1, 1, 0); // Add text field to column 1, row 0
        view.add(nextButton, 1, 1); // Add next button to column 1, row 1
        view.add(clearButton, 2, 1); // Add clear button to column 2, row 1
    }

    // Method to get the view of the page
    public GridPane getView() {
        return view;
    }

    // Method to get the value of Field 1
    public String getField1Value() {
        return field1.getText();
    }

    // Method to set the value of Field 1
    public void setField1Value(String value) {
        field1.setText(value);
    }

}