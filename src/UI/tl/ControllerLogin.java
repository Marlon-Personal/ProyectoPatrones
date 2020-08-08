package UI.tl;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {
    @FXML private HBox pruebas;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pruebas.getChildren().clear();
        for (int i = 0; i <8 ; i++) {
            VBox vbox = new VBox();
            for(int j=0; j<9;j++){
                Button button=new Button();
                button.setOnAction(event -> {
                    System.out.println("czxcz");
                });
                button.setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  #b1b1b1;");
                button.setText("holii");
                vbox.getChildren().add(button);
            }

            pruebas.getChildren().add(vbox);
        }
    }
}

