package javafiles.Assign3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;

public class q3 extends Application {
    Text txt = null;
    Text txt1 = null;

    @Override

    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image("assets/images/core2web.png"));
        primaryStage.setTitle("MyButtons");
        primaryStage.setHeight(700);
        primaryStage.setWidth(1000);

        String bs = "-fx-background-color:yellow;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:180px;";

        txt = new Text(255, 323, "Enter Num :");
        txt.setFill(Color.BLACK);
        txt.setFont(new Font(20));

        TextField tx = new TextField();
        // int integer = Integer.parseInt(tx.getText());

        Button show = new Button("Square");
        Button show1 = new Button("Sqroot");

        show.setStyle(bs);
        show1.setStyle(bs);

        show.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                int number = Integer.parseInt(tx.getText());
                int sq = number * number;
                System.out.println(sq);
            }
        });

        show1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String input = tx.getText().trim();

                double number = Double.parseDouble(input);
                double sqroot = Math.sqrt(number);
                System.out.println(sqroot);
            }
        });

        VBox vb = new VBox(20, tx, show, show1);
        vb.setLayoutX(370);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Group gr = new Group(vb, txt);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
