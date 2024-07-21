package javafiles.Assign3;

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

public class q1 extends Application {
    Text txt = null;

    @Override

    public void start(Stage pr) throws Exception {
        pr.getIcons().add(new Image("assets/images/core2web.png"));
        pr.setTitle("Core2Web");
        pr.setHeight(700);
        pr.setWidth(1000);

        String bs = "-fx-background-color:yellow;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:180px;";

        Button show = new Button("January");

        show.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Jan");
            }
        });

        Button show1 = new Button("Febuary");

        show1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Feb");
            }
        });

        Button show2 = new Button("March");

        show2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Mar");
            }
        });

        Button show3 = new Button("April");

        show3.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Apr");
            }
        });

        Button show4 = new Button("May");

        show4.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("May");
            }
        });

        Button show5 = new Button("June");

        show5.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Jun");
            }
        });

        show.setStyle(bs);
        show1.setStyle(bs);
        show2.setStyle(bs);
        show3.setStyle(bs);
        show4.setStyle(bs);
        show5.setStyle(bs);

        VBox vb = new VBox(show);
        vb.setLayoutX(400);
        vb.setLayoutY(200);
        vb.setAlignment(Pos.CENTER);

        VBox vb1 = new VBox(show1);
        vb1.setLayoutX(400);
        vb1.setLayoutY(250);
        vb1.setAlignment(Pos.CENTER);

        VBox vb2 = new VBox(show2);
        vb2.setLayoutX(400);
        vb2.setLayoutY(300);
        vb2.setAlignment(Pos.CENTER);

        VBox vb3 = new VBox(show3);
        vb3.setLayoutX(400);
        vb3.setLayoutY(350);
        vb3.setAlignment(Pos.CENTER);

        VBox vb4 = new VBox(show4);
        vb4.setLayoutX(400);
        vb4.setLayoutY(400);
        vb4.setAlignment(Pos.CENTER);

        VBox vb5 = new VBox(show5);
        vb5.setLayoutX(400);
        vb5.setLayoutY(450);
        vb5.setAlignment(Pos.CENTER);

        Label lb = new Label("Core2web.in");
        lb.setPadding(new Insets(230, 50, 100, 375));
        lb.setStyle("-fx-font-size:40px; -fx-font-weight:bold;");

        Group gr = new Group(vb, vb1, vb2, vb3, vb4, vb5);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        pr.setScene(scene);
        pr.show();
    }
}
