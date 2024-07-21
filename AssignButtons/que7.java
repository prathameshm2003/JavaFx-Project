package javafiles.Assign2Buttons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;

public class que7 extends Application {
    Text txt = null;

    @Override

    public void start(Stage pr) throws Exception {
        pr.getIcons().add(new Image("assets/images/core2web.png"));
        pr.setTitle("Core2Web");
        pr.setHeight(700);
        pr.setWidth(1000);

        txt = new Text(390, 250, "#Core2Web.in");
        txt.setFill(Color.BLACK);
        txt.setFont(new Font(35));

        String bs = "-fx-background-color:pink;-fx-text-fill:black;-fx-font-weight:bold;-fx-min-width:100px;";

        Button show1 = new Button("OS");

        Button show2 = new Button("C");

        Button show3 = new Button("CPP");

        Button show4 = new Button("JAVA");

        Button show5 = new Button("DSA");

        Button show6 = new Button("PYTHON");

        show1.setStyle(bs);
        show2.setStyle(bs);
        show3.setStyle(bs);
        show4.setStyle(bs);
        show5.setStyle(bs);
        show6.setStyle(bs);

        HBox hb1 = new HBox(10, show1, show2, show3);
        hb1.setPrefWidth(400);
        hb1.setLayoutX(350);
        hb1.setLayoutY(300);

        HBox hb2 = new HBox(10, show4, show5, show6);
        hb2.setPrefWidth(400);
        hb2.setLayoutX(350);
        hb2.setLayoutY(350);

        Label lb = new Label("#Core2web.in");
        lb.setPadding(new Insets(230, 60, 100, 375));
        lb.setStyle("-fx-font-size:40px; -fx-font-weight:bold;");

        Group gr = new Group(hb1, hb2, txt);

        Scene scene = new Scene(gr, 1000, 1000);
        scene.setFill(Color.LIGHTBLUE);
        pr.setScene(scene);
        pr.show();
    }
}
