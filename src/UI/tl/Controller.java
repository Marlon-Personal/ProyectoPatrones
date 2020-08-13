package UI.tl;

import UI.principal.ToScene;
import UI.principal.Util;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.awt.*;
import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private AnchorPane panelLogin;
    @FXML private ImageView img1;
    @FXML private Label nombreJ1;
    @FXML private Label nombreJ2;
    public String jugadorN1;
    public String jugadorN2;
    int seconds=0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GaussianBlur selectGlow = new GaussianBlur(16.75f);
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            seconds++;
            if(seconds>3){
                img1.setEffect(selectGlow);
                img1.setStyle("  -fx-opacity: 0.93;");
                panelLogin.setVisible(true);
            }
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void login(ActionEvent event) {
        jugadorN1=nombreJ1.getText();
        jugadorN2=nombreJ2.getText();
        new ToScene().toScene("../sample/home.fxml", event);
    }
}
