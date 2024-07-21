package javafiles.Assign2Buttons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class que5 extends Application {
    @Override

    public void start(Stage pr) throws Exception {
        pr.getIcons().add(new Image("assets/images/core2web.png"));
        pr.setTitle("Core2Web");
        pr.setHeight(700);
        pr.setWidth(1000);

        String bs = "-fx-background-color:blue; -fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:180px;";

        Button show = new Button("Core2Web-Java");
        show.setStyle("-fx-font-weight: bold;");
        show.setPrefSize(20, 20);

        Button show1 = new Button("Core2Web-Super-X");
        show1.setStyle("-fx-font-weight: bold;");
        show1.setPrefSize(20, 20);

        Button show2 = new Button("Core2Web-DSA");
        show2.setStyle("-fx-font-weight: bold;");
        show2.setPrefSize(20, 20);

        show.setStyle(bs);
        show1.setStyle(bs);
        show2.setStyle(bs);

        Label lb = new Label("Core2web.in");
        lb.setPadding(new Insets(320, 50, 100, 375));
        lb.setStyle("-fx-font-size:40px; -fx-font-weight:bold;");

        VBox vb = new VBox(show);
        vb.setLayoutX(400);
        vb.setLayoutY(400);
        vb.setAlignment(Pos.CENTER);

        VBox vb1 = new VBox(show1);
        vb1.setLayoutX(400);
        vb1.setLayoutY(450);

        VBox vb2 = new VBox(show2);
        vb2.setLayoutX(400);
        vb2.setLayoutY(500);
        // vb.setAlignment(Pos.CENTER);

        Group gr = new Group(vb, vb1, vb2, lb);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        pr.setScene(scene);
        pr.show();
    }
}
