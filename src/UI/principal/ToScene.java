package UI.principal;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToScene {
    public void toScene(String path, Event event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../sample/"+path));
        try {

            loader. load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent p = loader.getRoot();
        Platform.runLater( () -> p.requestFocus() );
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(p));
        stage.show();
    }
}
