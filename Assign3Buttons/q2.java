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

public class q2 extends Application {
    Text txt = null;
    Text txt1 = null;

    @Override

    public void start(Stage primaryStage) throws Exception {

        primaryStage.getIcons().add(new Image("assets/images/core2web.png"));
        primaryStage.setTitle("MyButtons");
        primaryStage.setHeight(700);
        primaryStage.setWidth(1000);

        txt = new Text(255, 323, "Enter Text :");
        txt.setFill(Color.BLACK);
        txt.setFont(new Font(20));

        TextField tx = new TextField();

        Button show = new Button("Print");

        Label UserName = new Label();

        show.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println(tx.getText());

            }
        });
        Image ig = new Image("assets/images/core2web.png");
        ImageView iv = new ImageView(ig);
        iv.setFitWidth(200);
        iv.setPreserveRatio(true);
        iv.setLayoutX(355);
        iv.setLayoutY(80);

        VBox vb = new VBox(20, tx, show, UserName);
        vb.setLayoutX(370);
        vb.setLayoutY(300);
        vb.setAlignment(Pos.CENTER);

        Group gr = new Group(vb, iv, txt);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
