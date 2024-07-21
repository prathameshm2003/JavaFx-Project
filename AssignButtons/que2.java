package javafiles.Assign2Buttons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class que2 extends Application {

    @Override

    public void start(Stage pr) throws Exception {
        pr.getIcons().add(new Image("assets/images/core2web.png"));
        pr.setTitle("Core2Web");
        pr.setHeight(700);
        pr.setWidth(1000);

        Button show = new Button("Hello Super-X");

        show.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("Core2web");
                }
            }
        });

        VBox vb = new VBox(show);
        vb.setLayoutX(400);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Group gr = new Group(vb);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        pr.setScene(scene);
        pr.show();

    }
}