package com.c2w.controller;

import com.c2w.dataAccess.FormPage1;
import com.c2w.dataAccess.FormPage2;
import com.c2w.dataAccess.FormPage3;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FormNavigationApp extends Application {

    private Stage primaryStage;
    private Scene page1Scene, page2Scene, page3Scene;

    private FormPage1 page1;
    private FormPage2 page2;
    private FormPage3 page3;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        page1 = new FormPage1(this);
        page2 = new FormPage2(this);
        page3 = new FormPage3(this);

        Pane page1View = page1.getView();
        Pane page2View = page2.getView();
        Pane page3View = page3.getView();

        setBackgroundImage(page1View, "background.jpg");
        setBackgroundImage(page2View, "background.jpg");
        setBackgroundImage(page3View, "background.jpg");

        page1Scene = new Scene(page1View, 400, 300);
        page2Scene = new Scene(page2View, 400, 300);
        page3Scene = new Scene(page3View, 400, 300);

        primaryStage.setScene(page1Scene);
        primaryStage.setTitle("Form Navigation");
        primaryStage.show();
    }

    private void setBackgroundImage(Pane pane, String imageFileName) {
        BackgroundImage backgroundImage = new BackgroundImage(
                new javafx.scene.image.Image(getClass().getResource("/images/" + imageFileName).toExternalForm()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
    }

    public void navigateToPage1() {
        page2.setField2Value(page2.getField2Value());
        page1.setField1Value(page1.getField1Value());
        primaryStage.setScene(page1Scene);
    }

    public void navigateToPage2() {
        page1.setField1Value(page1.getField1Value());
        page3.setField3Value(page3.getField3Value());
        primaryStage.setScene(page2Scene);
    }

    public void navigateToPage3() {
        page2.setField2Value(page2.getField2Value());
        primaryStage.setScene(page3Scene);
    }
}
