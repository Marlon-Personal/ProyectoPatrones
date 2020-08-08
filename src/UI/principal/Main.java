package UI.principal;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("../sample/home.fxml"));
        primaryStage.setTitle("CENFO-TECOS");
        primaryStage.setScene(new Scene(root, 782, 603));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
