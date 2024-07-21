package javafiles.Home;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
//import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MyPane extends Application {
    Label lb = null;

    @Override
    public void start(Stage pr) {

        pr.setTitle("Practical Stage");
        pr.setHeight(800);
        pr.setWidth(1000);
        pr.getIcons().add(new Image("assets/images/core2web.png"));

        Label lb = new Label("Good Morning");
        lb.setFont(new Font(40));
        lb.setAlignment(Pos.CENTER);
        lb.setLayoutX(350);

        Pane pane = new Pane(lb);
        pane.setOpacity(1);
        pane.setVisible(true);
        // pane.setStyle("-fx-Background-Color:Orange");
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        Scene scene = new Scene(pane, 1000, 800);

        pr.setScene(scene);
        pr.setTitle("MyPane");
        pr.show();

    }

}
