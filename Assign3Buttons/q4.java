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

public class q4 extends Application {

    Text txt1 = null;

    @Override

    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image("assets/images/core2web.png"));
        primaryStage.setTitle("MyButtons");
        primaryStage.setHeight(700);
        primaryStage.setWidth(1000);

        txt1 = new Text(260, 321, "Enter Pwd :");
        txt1.setFill(Color.BLACK);
        txt1.setFont(new Font(20));

        PasswordField ps = new PasswordField();

        Button show = new Button("show");

        Label password = new Label();
        show.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                System.out.println(ps.getText());

                // password.setText(ps.getText());

            }
        });

        VBox vb = new VBox(20, ps, show, password);
        vb.setLayoutX(390);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Group gr = new Group(vb, txt1);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
