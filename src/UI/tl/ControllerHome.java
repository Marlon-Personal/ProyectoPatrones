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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ControllerHome implements Initializable {
    @FXML private AnchorPane panelTablero;
    @FXML private AnchorPane pFiguras;
    @FXML private AnchorPane pFigura1;
    @FXML private AnchorPane pFigura2;
    @FXML private AnchorPane pFigura3;
    @FXML private AnchorPane panelDado2;
    @FXML private AnchorPane preDado;
    @FXML private AnchorPane panelInvocar;
    @FXML private  AnchorPane panelResult;
    @FXML private JFXButton terminarTurno;
    @FXML private JFXButton tirarDado;
    @FXML private JFXButton invocar;
    @FXML private HBox tablerosP;
    @FXML private Label AETHELFLAED;
    @FXML private Label KJARTAN;
    @FXML private Label FINNAN;
    @FXML private Label BEOCCA;
    @FXML private Label artilleria;
    @FXML private Label tanque;
    @FXML private Label infanteria;
    @FXML private Label ataqueEspecial;
    @FXML private Label movimiento;
    @FXML private Label ataque;
    @FXML private Label resultDado2;
    @FXML private Label resultDado1;
    @FXML private Rectangle rectangulo;
    @FXML private Image logoDado;
    private int jugador=1;
    private String color="red";
    private String idB;
    private int seconds=0;
    private int contSecond=0;
    RotateTransition rotate = new RotateTransition();

    private ControllerAbstractFactory gestorAbstractFactory=new ControllerAbstractFactory();

    int px=0;
    int pj=0;
    int p1=0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablerosP.getChildren().clear();
        for (int i = 0; i <8 ; i++) {
            px++;
            VBox vbox = new VBox();
            for(int j=0; j<9;j++){
                Button button=new Button();
                button.setId(i+","+j);
                button.setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  #79a8b1;");
                button.setOnAction(event -> {
                    String id=button.getId();
                   verificarFigura(button.getId());
                });
                vbox.getChildren().add(button);
            }

            tablerosP.getChildren().add(vbox);
        }
    }

    public void verificarFigura(String id){
        int cont=0;
        int cont2=0;
        int cont3=0;
        idB=id;
        String[] arrOfStr = id.split(",", 2);
        System.out.printf(arrOfStr[0]+"\n");
        System.out.printf(arrOfStr[1]+"\n");
         p1= Integer.parseInt(arrOfStr[1]);
        //este es el que selecciona
        VBox node1=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node3=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node4=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        if(p1==8){
            if(jugador==1){
                cont=0;
                cont2=0;
                cont3=0;
                if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("yellow")){
                    cont++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont++;
                }

                if( node3.getChildren().get(Integer.parseInt(arrOfStr[1])-2).getStyle().contains("yellow")){
                    cont2++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont2++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("yellow")){
                    cont2++;
                }else if(node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("yellow")){
                    cont2++;
                }

                if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont3++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("yellow")){
                    cont3++;
                }else if(node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("yellow")){
                    cont3++;
                }
            }else{
                cont=0;
                cont2=0;
                cont3=0;
                if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("red")){
                    cont++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont++;
                }

                if( node3.getChildren().get(Integer.parseInt(arrOfStr[1])-2).getStyle().contains("red")){
                    cont2++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont2++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("red")){
                    cont2++;
                }else if(node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("red")){
                    cont2++;
                }

                if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont3++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("red")){
                    cont3++;
                }else if(node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("red")){
                    cont3++;
                }
            }
        }
        else if(p1!=0){
            if(jugador==1){
                cont=0;
                cont2=0;
                cont3=0;
                if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("yellow")){
                    cont++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont++;
                }

                if( node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1).getStyle().contains("yellow")){
                    cont2++;
                }else if(node.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont2++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("yellow")){
                    cont2++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont2++;
                }

                if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).getStyle().contains("yellow")){
                    cont3++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont3++;
                }else if(node.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont3++;
                }
            }else{
                if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("red")){
                    cont++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont++;
                }

                if( node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1).getStyle().contains("red")){
                    cont2++;
                }else if(node.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont2++;
                }else if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).getStyle().contains("red")){
                    cont++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont2++;
                }

                if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).getStyle().contains("red")){
                    cont3++;
                }else if(node1.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont3++;
                }else if(node.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont3++;
                }
            }
        }
        if(cont==0 && cont2==0 && cont3==0){
            tablerosP.setVisible(false);
            pFiguras.setVisible(true);
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
    public String invocacionDada1(){
        return gestorAbstractFactory.throwInvocationDicesUI();
    }
    public String invocacionDada2(){
        return gestorAbstractFactory.throwAttackDicesUI();
    }
    public void tirarDadoA(ActionEvent event) {
        seconds=0;
        panelDado2.setVisible(true);
        rectangulo.setStrokeWidth(5);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(500);
        rotate.setDuration(Duration.millis(1000));
        rotate.setAutoReverse(true);
        rotate.setNode(rectangulo);
        rotate.play();
    /*    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            seconds++;
            if(seconds>3){
                rotate.pause();
                panelDado2.setVisible(false);
                mostrarResultados(data1,data2);
            }
        }),
                new KeyFrame(Duration.seconds(1))

        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();*/
    }
    public void mostrarResultados(String data1,String data2){
        int num1=0;
        int num2=0;
        if(data1.equals("DadoArtilleria")){
            num1= Integer.parseInt(artilleria.getText());
            artilleria.setText(String.valueOf(num1+1));
        }else if(data1.equals("DadoInfanteria")){
            num1= Integer.parseInt(infanteria.getText());
            infanteria.setText(String.valueOf(num1+1));
        }else if(data1.equals("DadoTanque")){
            num1= Integer.parseInt(tanque.getText());
            tanque.setText(String.valueOf(num1+1));
        }else if(data2.equals("DadoMovimiento")){
            num2= Integer.parseInt(movimiento.getText());
            movimiento.setText(String.valueOf(num2+1));
        }else if(data2.equals("DadoAtaque")){
            num2= Integer.parseInt(ataque.getText());
            ataque.setText(String.valueOf(num2+1));
        }else if(data2.equals("DadoAtaqueEspecial")){
            num2= Integer.parseInt(ataqueEspecial.getText());
            ataqueEspecial.setText(String.valueOf(num2+1));
        }
        panelResult.setVisible(true);
        resultDado1.setText(data1);
        resultDado2.setText(data2);
    }
    public void cambiarJugador(ActionEvent event) {
        if(jugador==1){
            jugador=2;
            color="GREEN";
        }else if(jugador==2){
            jugador=1;
            color="RED";
        }
    }

    public void pFigura1MO(MouseEvent mouseEvent) {
        String[] arrOfStr = idB.split(",", 2);
        VBox node1=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node3=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node4=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        pFiguras.setVisible(false);
        tablerosP.setVisible(true);
        if(p1==8){
            node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
            node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  red;");
            node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  red;");
        }else{
            if(jugador==1){
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  red;");
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  red;");
            }else{
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:yellow;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  yellow;");
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  yellow;");
            }
        }
    }

    public void pFigura2MO(MouseEvent mouseEvent) {
        String[] arrOfStr = idB.split(",", 2);
        VBox node1=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node3=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node4=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        pFiguras.setVisible(false);
        tablerosP.setVisible(true);
        if(p1==8){
            node3.getChildren().get(Integer.parseInt(arrOfStr[1])-2).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
            node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
            node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
            node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");

        }else{
            if(jugador==1){
                node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  red;");;
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  red;");
            }else{
                node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:yellow;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:yellow;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  yellow;");;
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:  yellow;");
            }
        }

    }

    public void pFigura3MO(MouseEvent mouseEvent) {
        String[] arrOfStr = idB.split(",", 2);
        VBox node1=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node3=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node4=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        pFiguras.setVisible(false);
        tablerosP.setVisible(true);
        if(p1==8){
            node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
            node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
            node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
        }else{
            if(jugador==1){

                node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:red;");
            }else{

                node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:yellow;");
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:yellow;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: black; -fx-background-color:yellow ;");
            }
        }

    }

    public void cerrarResultados(MouseEvent mouseEvent) {
        panelResult.setVisible(false);
        resultDado1.setText("");
        resultDado2.setText("");
    }

    public void detenerDado(MouseEvent mouseEvent) {
        String data1=invocacionDada1();
        String data2=invocacionDada2();
        System.out.println(data1);
        System.out.println(data2);
        rotate.pause();
        panelDado2.setVisible(false);
        mostrarResultados(data1,data2);
    }
}
