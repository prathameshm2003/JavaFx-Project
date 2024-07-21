package javafiles.Home;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeWindow extends Application {
    Text txt = null;

    @Override
    public void start(Stage pr) throws Exception {
        pr.setTitle("stage practical");
        pr.getIcons().add(new Image("assets/images/core2web.png"));
        // pr.setResizable(false);
        pr.setX(0);
        pr.setY(0);
        pr.setWidth(1800);
        pr.setHeight(1000);

        txt = new Text(20, 40, "Good Morning");
        txt.setFill(Color.DARKCYAN);
        txt.setFont(new Font(35));

        Text gd = new Text(1000, 40, "Have a nice day");
        gd.setFill(Color.DARKCYAN);
        gd.setFont(new Font(35));
        gd.setFont(new Font(30));

        Text java = new Text("Java");
        java.setFont(new Font(40));
        java.setFill(Color.YELLOW);
        Text python = new Text("Python");
        python.setFont(new Font(40));
        python.setFill(Color.BLUE);
        Text cpp = new Text("CPP");
        cpp.setFont(new Font(40));

        Text web = new Text(10, 10, "web");
        web.setFont(new Font(40));
        web.setFill(Color.LIGHTBLUE);
        Text backend = new Text(10, 10, "backend");
        backend.setFont(new Font(40));
        Text app = new Text(10, 10, "App");
        app.setFont(new Font(40));

        VBox vb = new VBox(20, java, python, cpp);
        vb.setLayoutX(400);
        vb.setLayoutY(100);

        VBox vb1 = new VBox(20, web, backend, app);
        vb1.setLayoutX(800);
        vb1.setLayoutY(100);

        Group group = new Group(vb1, vb, txt, gd);
        Scene scene = new Scene(group, 450, 100);
        scene.setFill(Color.MAROON);
        scene.setCursor(Cursor.OPEN_HAND);

        pr.setScene(scene);

        pr.show();
    }
}
