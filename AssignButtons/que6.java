package javafiles.Assign2Buttons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class que6 extends Application {
    Text txt = null;

    @Override

    public void start(Stage pr) throws Exception {
        pr.getIcons().add(new Image("assets/images/core2web.png"));
        pr.setTitle("Core2Web");
        pr.setHeight(700);
        pr.setWidth(1000);

        txt = new Text(390, 250, "Core2Web.in");
        txt.setFill(Color.BLACK);
        txt.setFont(new Font(35));

        String bs = "-fx-background-color:yellow;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:180px;";

        Button show = new Button("Core2Web-Java");

        show.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Java-2024");
            }
        });

        Button show1 = new Button("Core2Web-Super-X");

        show1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Super-X 2024");
            }
        });

        Button show2 = new Button("Core2Web-DSA");

        show2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("DSA-2024");
            }
        });

        show.setStyle(bs);
        show1.setStyle(bs);
        show2.setStyle(bs);

        VBox vb = new VBox(show);
        vb.setLayoutX(400);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        VBox vb1 = new VBox(show1);
        vb1.setLayoutX(400);
        vb1.setLayoutY(350);
        vb1.setAlignment(Pos.CENTER);

        VBox vb2 = new VBox(show2);
        vb2.setLayoutX(400);
        vb2.setLayoutY(400);
        vb2.setAlignment(Pos.CENTER);

        Label lb = new Label("Core2web.in");
        lb.setPadding(new Insets(230, 50, 100, 375));
        lb.setStyle("-fx-font-size:40px; -fx-font-weight:bold;");

        Group gr = new Group(vb, vb1, vb2, txt);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        pr.setScene(scene);
        pr.show();
    }
}
