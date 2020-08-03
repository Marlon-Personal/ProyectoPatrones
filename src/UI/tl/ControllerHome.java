package UI.tl;

        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.geometry.Insets;
        import javafx.scene.control.Button;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;
        import javafx.scene.paint.Color;
        import javafx.scene.text.Text;

        import java.net.URL;
        import java.util.ResourceBundle;

public class ControllerHome implements Initializable {
    @FXML private AnchorPane panelTablero;
    @FXML private HBox tableroP;
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
 /*   @FXML private HBox tableroP;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableroP.getChildren().clear();
        for (int i = 0; i <8 ; i++) {
            VBox vbox = new VBox();
            for(int j=0; j<9;j++){
                Button button=new Button();
                button.setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black;");
                vbox.getChildren().add(button);
            }

            tableroP.getChildren().add(vbox);
        }
    }*/
}
