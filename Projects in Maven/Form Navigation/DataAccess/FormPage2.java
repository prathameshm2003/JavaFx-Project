package com.c2w.dataAccess;

import com.c2w.controller.FormNavigationApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FormPage2 {
    private FormNavigationApp app;
    private GridPane view;
    private TextField field2;

    // Constructor for FormPage2
    public FormPage2(FormNavigationApp app) {
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

        // Create and add a label for Field 2
        Label label2 = new Label("Field 2:");
        field2 = new TextField();

        // Create a button to navigate back to the previous page
        Button backButton = new Button("Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.navigateToPage1(); // Navigate to Page1 when button is clicked
            }
        });

        // Create a button to navigate to the next page
        Button nextButton = new Button("Next");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.navigateToPage3(); // Navigate to Page3 when button is clicked
            }
        });

        // Create a button to clear the text field
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setField2Value(null); // Clear the text field when button is clicked
            }
        });

        // Add components to the GridPane
        view.add(label2, 0, 0); // Add label to column 0, row 0
        view.add(field2, 1, 0); // Add text field to column 1, row 0
        view.add(backButton, 0, 1); // Add back button to column 0, row 1
        view.add(nextButton, 1, 1); // Add next button to column 1, row 1
        view.add(clearButton, 2, 1); // Add clear button to column 2, row 1
    }

    // Method to get the view of the page
    public GridPane getView() {
        return view;
    }

    // Method to get the value of Field 2
    public String getField2Value() {
        return field2.getText();
    }

    // Method to set the value of Field 2
    public void setField2Value(String value) {
        field2.setText(value);
    }
}