package javafiles.Assign2Buttons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.Group;

public class que1 extends Application {
    @Override

    public void start(Stage pr) throws Exception {
        pr.getIcons().add(new Image("assets/images/core2web.png"));
        pr.setTitle("Core2Web");
        pr.setHeight(700);
        pr.setWidth(1000);

        Button show = new Button("Hello Super-X");

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
