package UI.tl;

import javafx.animation.RotateTransition;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Creating Rectangle
        Rectangle rect = new Rectangle(200,100,200,200);
        rect.setFill(Color.LIMEGREEN);
        rect.setStroke(Color.HOTPINK);
        rect.setStrokeWidth(5);

        //Instantiating RotateTransition class
        RotateTransition rotate = new RotateTransition();

        //Setting Axis of rotation
        rotate.setAxis(Rotate.Z_AXIS);

        // setting the angle of rotation
        rotate.setByAngle(360);

        //setting cycle count of the rotation
        rotate.setCycleCount(500);

        //Setting duration of the transition
        rotate.setDuration(Duration.millis(1000));

        //the transition will be auto reversed by setting this to true
        rotate.setAutoReverse(true);

        //setting Rectangle as the node onto which the
// transition will be applied
        rotate.setNode(rect);

        //playing the transition
        rotate.play();

        //Configuring Group and Scene
        Group root = new Group();
        root.getChildren().add(rect);

    }
}

