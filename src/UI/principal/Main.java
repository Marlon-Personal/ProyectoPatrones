package UI.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//prueba de comentario
    //prueba de comentario 2
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
        primaryStage.setTitle("CENFO-TECOS");
        primaryStage.setScene(new Scene(root, 782, 603));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
