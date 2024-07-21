package javafiles.Assign3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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

public class q5 extends Application {
    Text txt1 = null;
    Text txt2 = null;

    @Override

    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image("assets/images/core2web.png"));
        primaryStage.setTitle("MyButtons");
        primaryStage.setHeight(700);
        primaryStage.setWidth(1000);

        txt1 = new Text(230, 321, "Enter LoginId :");
        txt1.setFill(Color.BLACK);
        txt1.setFont(new Font(20));

        txt2 = new Text(260, 373, "Enter Pwd :");
        txt2.setFill(Color.BLACK);
        txt2.setFont(new Font(20));

        String FixedUsername = "Pm";
        String FixedPassword = "123";

        TextField tx = new TextField();
        PasswordField ps = new PasswordField();

        Button show = new Button("Login");

        String bs = "-fx-background-color:yellow;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:180px;";
        show.setStyle(bs);

        show.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String LoginId = tx.getText().trim();
                String Pwd = ps.getText();
                if (LoginId.equals(FixedUsername) && Pwd.equals(FixedPassword)) {
                    System.out.println("You are Welcome");
                } else {
                    System.out.println("Invalid Credentials");
                }
            }
        });

        VBox vb = new VBox(20, tx, ps, show);
        vb.setLayoutX(370);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Group gr = new Group(vb, txt1, txt2);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
