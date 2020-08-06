package UI.tl;

        import backEnd.patrones.controller.creacionales.abstractFactory.ControllerAbstractFactory;
        import com.jfoenix.controls.JFXButton;
        import javafx.animation.Animation;
        import javafx.animation.KeyFrame;
        import javafx.animation.RotateTransition;
        import javafx.animation.Timeline;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.geometry.Insets;
        import javafx.scene.Group;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.input.ContextMenuEvent;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.scene.text.Text;
        import javafx.scene.transform.Rotate;
        import javafx.util.Duration;

        import java.net.URL;
        import java.util.ResourceBundle;

public class ControllerHome implements Initializable {
    @FXML private AnchorPane panelTablero;
    @FXML private AnchorPane tirarDadoP;
    @FXML private AnchorPane preDado;
    @FXML private AnchorPane panelInvocar;
    @FXML private JFXButton terminarTurno;
    @FXML private JFXButton tirarDado;
    @FXML private JFXButton invocar;
    @FXML private HBox tableroP;
    @FXML private Label AETHELFLAED;
    @FXML private Label KJARTAN;
    @FXML private Label FINNAN;
    @FXML private Label BEOCCA;
    @FXML private Label artilleria;
    @FXML private Label tanque;
    @FXML private Label infanteria;
    @FXML private Rectangle rectangulo;
    private ControllerAbstractFactory gestorAbstractFactory=new ControllerAbstractFactory();
    int seconds=0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
 System.out.println("xdvdxcv");
        tableroP.getChildren().clear();
        for (int i = 0; i <8 ; i++) {
            VBox vbox = new VBox();
            for(int j=0; j<9;j++){
                Button button=new Button();
                button.setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  #b1b1b1;");
                vbox.getChildren().add(button);
            }

            tableroP.getChildren().add(vbox);
        }
    }

    public void invocar(ActionEvent event) {
        panelInvocar.setVisible(true);
        terminarTurno.setOpacity(0.22);
        tirarDado.setOpacity(0.22);
    }

    public void cerrarInvocar(MouseEvent mouseEvent) {
        panelInvocar.setVisible(false);
        terminarTurno.setOpacity(1);
        tirarDado.setOpacity(1);
    }

    public void jugadoresInfanteria(MouseEvent mouseEvent) {
        artilleria.setVisible(false);
        tanque.setVisible(false);
        infanteria.setVisible(false);
        AETHELFLAED.setVisible(true);
        KJARTAN.setVisible(true);
        FINNAN.setVisible(true);
        BEOCCA.setVisible(true);
    }

    public void AETHELFLAEDJ(ContextMenuEvent contextMenuEvent) {
    }

    public void KJARTANJ(MouseEvent mouseEvent) {
    }

    public void FINNANJ(MouseEvent mouseEvent) {
    }

    public void BEOCCAJ(MouseEvent mouseEvent) {
    }

    public void tirarDadoA(ActionEvent event) {
        preDado.setVisible(true);
        tirarDadoP.setVisible(true);
        rectangulo.setStrokeWidth(5);
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(500);
        rotate.setDuration(Duration.millis(1000));
        rotate.setAutoReverse(true);
        rotate.setNode(rectangulo);
        rotate.play();
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            seconds++;
            if(seconds>3){
                rotate.pause();
                preDado.setVisible(false);
                tirarDadoP.setVisible(false);
            }
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
