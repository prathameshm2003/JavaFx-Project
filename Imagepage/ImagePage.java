package javafiles.imagePage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;

public class ImagePage extends Application {
    Text txt = null;

    public void start(Stage imgStage) {

        imgStage.setTitle("stage practical");
        imgStage.getIcons().add(new Image("assets/images/core2web.png"));
        // pr.setResizable(false);
        imgStage.setX(0);
        imgStage.setY(0);
        imgStage.setWidth(1800);
        imgStage.setHeight(1000);

        txt = new Text(650, 40, "#Programming Languages");
        txt.setFill(Color.BLACK);
        txt.setFont(new Font(35));

        Image ig = new Image("assets/images/C.jpg");
        ImageView iv = new ImageView(ig);
        iv.setFitWidth(200);
        iv.setPreserveRatio(true);
        Label j1 = new Label("  C ");
        j1.setFont(new Font(40));
        j1.setAlignment(Pos.CENTER);
        j1.setPrefHeight(200);
        VBox vb = new VBox(20, j1);
        HBox hb = new HBox(15, iv, vb);
        hb.setPrefWidth(500);
        hb.setLayoutX(50);
        hb.setLayoutY(70);

        Image ig1 = new Image("assets/images/java.jpg");
        ImageView iv1 = new ImageView(ig1);
        iv1.setFitWidth(200);
        iv1.setPreserveRatio(true);
        Label j2 = new Label("  Java ");
        j2.setFont(new Font(40));
        j2.setAlignment(Pos.CENTER);
        j2.setPrefHeight(200);
        VBox vb1 = new VBox(20, j2);
        HBox hb1 = new HBox(15, iv1, vb1);
        hb1.setPrefWidth(500);
        hb1.setLayoutX(50);
        hb1.setLayoutY(370);

        Image ig2 = new Image("assets/images/Python.jpg");
        ImageView iv2 = new ImageView(ig2);
        iv2.setFitWidth(200);
        iv2.setPreserveRatio(true);
        Label j3 = new Label("  Python ");
        j3.setFont(new Font(40));
        j3.setAlignment(Pos.CENTER);
        j3.setPrefHeight(200);
        VBox vb2 = new VBox(20, j3);
        HBox hb2 = new HBox(15, iv2, vb2);
        hb2.setPrefWidth(600);
        hb2.setLayoutX(50);
        hb2.setLayoutY(670);

        Image ig3 = new Image("assets/images/springboot.jpg");
        ImageView iv3 = new ImageView(ig3);
        iv3.setFitWidth(350);
        iv3.setPreserveRatio(true);
        Label j4 = new Label("  Springboot ");
        j4.setFont(new Font(40));
        j4.setAlignment(Pos.BASELINE_CENTER);
        j4.setPrefHeight(200);
        VBox vb3 = new VBox(20, j4);
        HBox hb3 = new HBox(15, iv3, vb3);
        hb3.setPrefWidth(700);
        hb3.setLayoutX(1200);
        hb3.setLayoutY(70);

        Image ig4 = new Image("assets/images/chatgpt.jpg");
        ImageView iv4 = new ImageView(ig4);
        iv4.setFitWidth(200);
        iv4.setPreserveRatio(true);
        Label j5 = new Label("  ReactJS ");
        j5.setFont(new Font(40));
        j5.setAlignment(Pos.BASELINE_CENTER);
        j5.setPrefHeight(200);
        VBox vb4 = new VBox(20, j5);
        HBox hb4 = new HBox(15, iv4, vb4);
        hb4.setPrefWidth(700);
        hb4.setLayoutX(1200);
        hb4.setLayoutY(370);

        Image ig5 = new Image("assets/images/nodejs.jpg");
        ImageView iv5 = new ImageView(ig5);
        iv5.setFitWidth(200);
        iv5.setPreserveRatio(true);
        Label j6 = new Label("  NodeJS ");
        j6.setFont(new Font(40));
        j6.setAlignment(Pos.BASELINE_CENTER);
        j6.setPrefHeight(200);
        VBox vb5 = new VBox(20, j6);
        HBox hb5 = new HBox(15, iv5, vb5);
        hb5.setPrefWidth(700);
        hb5.setLayoutX(1200);
        hb5.setLayoutY(670);

        Group gr = new Group(hb, hb1, hb2, hb3, hb4, hb5, txt);
        Scene image = new Scene(gr, 1800, 1000, Color.AQUA);

        image.setFill(Color.LIGHTBLUE);

        // image.setCursor(Cursor.OPEN_HAND);

        imgStage.setScene(image);

        imgStage.show();

    }
}
