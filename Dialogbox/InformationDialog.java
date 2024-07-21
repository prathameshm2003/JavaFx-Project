import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InformationDialog extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Show Information Dialog");
        btn.setOnAction(e -> showAlert());

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Information Dialog Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("This is an information dialog");
        alert.setContentText("You have successfully created an information dialog box.");

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
