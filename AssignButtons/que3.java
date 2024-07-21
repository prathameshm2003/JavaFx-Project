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

public class que3 extends Application {
    @Override

    public void start(Stage pr) throws Exception {
        pr.getIcons().add(new Image("assets/images/core2web.png"));
        pr.setTitle("Core2Web");
        pr.setHeight(700);
        pr.setWidth(1000);

        Button show = new Button("Core2Web-Java");

        Button show1 = new Button("Core2Web-Super-X");

        Button show2 = new Button("Core2Web-DSA");

        VBox vb = new VBox(show);
        vb.setLayoutX(0);
        vb.setLayoutY(0);

        VBox vb1 = new VBox(show1);
        vb1.setLayoutX(0);
        vb1.setLayoutY(100);

        VBox vb2 = new VBox(show2);
        vb2.setLayoutX(0);
        vb2.setLayoutY(50);
        // vb.setAlignment(Pos.CENTER);

        Group gr = new Group(vb, vb1, vb2);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        pr.setScene(scene);
        pr.show();
    }
}
