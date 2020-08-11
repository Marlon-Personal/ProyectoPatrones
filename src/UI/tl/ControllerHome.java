package UI.tl;
import UI.tl.Controller;
import backEnd.patrones.controller.creacionales.abstractFactory.ControllerAbstractFactory;
import backEnd.patrones.controller.creacionales.prototype.ControllerPrototype;
import com.jfoenix.controls.JFXButton;
import com.sun.org.apache.bcel.internal.generic.FADD;
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
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ControllerHome implements Initializable {

    @FXML private AnchorPane pFiguras;
    @FXML private AnchorPane panelDado2;
    @FXML private AnchorPane panelInvocar2;
    @FXML private AnchorPane panelInvocarInfanteria;
    @FXML private AnchorPane panelInvocarArtilleria;
    @FXML private AnchorPane panelInvocarTanque;
    @FXML private  AnchorPane panelResult;
    @FXML private  AnchorPane panelResult2;
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
    @FXML private Label resultDado3;
    @FXML private Label campoNombreJ;
    @FXML private Label resultInvocacion;
    @FXML private Rectangle rectangulo;
    private int jugador=1;
    private String color="red";
    private String idB;
    private int seconds=0;
    private int contSecond=0;
    private String urlTropa;
    RotateTransition rotate = new RotateTransition();
    private ControllerPrototype gestorPrototype=new ControllerPrototype();
    private ControllerAbstractFactory gestorAbstractFactory=new ControllerAbstractFactory();

    int px=0;
    int pj=0;
    int p1=0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gestorAbstractFactory.startPlayer1();
        gestorPrototype.startPlayer1();
        tablerosP.getChildren().clear();
        for (int i = 0; i <8 ; i++) {
            px++;
            VBox vbox = new VBox();
            for(int j=0; j<9;j++){
                Button button=new Button();
                button.setId(i+","+j);
                button.setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color:  #2b3d52; -fx-background-color: #517d80;");
                button.setOnAction(event -> {
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
        else if(p1!=8 && p1!=0){
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
        panelInvocar2.setVisible(true);
        terminarTurno.setOpacity(0.60);
        tirarDado.setOpacity(0.60);
    }

    public void cerrarInvocar(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        terminarTurno.setOpacity(1);
        tirarDado.setOpacity(1);
    }

    public void jugadoresInfanteria(MouseEvent mouseEvent) {
        panelInvocarInfanteria.setVisible(true);
    }

    public void AETHELFLAEDJ(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(1, "Aethelflaed");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/3.png";
    }

    public void KJARTANJ(MouseEvent mouseEvent) {
        String data=gestorAbstractFactory.summonUnitMainUI(1, "Kjartan");
        panelInvocarInfanteria.setVisible(false);
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/2.png";
    }

    public void FINNANJ(MouseEvent mouseEvent) {
        String data=gestorAbstractFactory.summonUnitMainUI(1, "Finnan");
        panelInvocarInfanteria.setVisible(false);
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/1.png";

    }

    public void BEOCCAJ(MouseEvent mouseEvent) {
        String data=gestorAbstractFactory.summonUnitMainUI(1, "Beoccan");
        panelInvocarInfanteria.setVisible(false);
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/4.png";
    }

    public String invocacionDada1(){
         return gestorAbstractFactory.throwInvocationDicesUI();

    }
    public String invocacionDada3(){
         return gestorAbstractFactory.throwInvocationDicesUI2();

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
    }

    public void mostrarResultados(String data1,String data2,String data3){
        int num1=0;
        int num2=0;
        int num3=0;
        if(data1.equals("DadoArtilleria")){
            num1= Integer.parseInt(artilleria.getText());
            artilleria.setText(String.valueOf(num1+1));
            data1="ARTILLERIA";
        }else if(data1.equals("DadoInfanteria")){
            num1= Integer.parseInt(infanteria.getText());
            infanteria.setText(String.valueOf(num1+1));
            data1="INFANTERIA";
        }else if(data1.equals("DadoTanque")){
            num1= Integer.parseInt(tanque.getText());
            tanque.setText(String.valueOf(num1+1));
            data1="TANQUE";
        }
        if(data3.equals("DadoArtilleria")){
            num3= Integer.parseInt(artilleria.getText());
            artilleria.setText(String.valueOf(num3+1));
            data3="ARTILLERIA";
        }else if(data3.equals("DadoInfanteria")){
            num3= Integer.parseInt(infanteria.getText());
            infanteria.setText(String.valueOf(num3+1));
            data3="INFANTERIA";
        }else if(data3.equals("DadoTanque")){
            num3= Integer.parseInt(tanque.getText());
            tanque.setText(String.valueOf(num3+1));
            data3="TANQUE";
        }
        if(data2.equals("DadoMovimiento")){
            num2= Integer.parseInt(movimiento.getText());
            movimiento.setText(String.valueOf(num2+1));
            data2="MOVIMIENTO";
        }else if(data2.equals("DadoAtaque")){
            num2= Integer.parseInt(ataque.getText());
            ataque.setText(String.valueOf(num2+1));
            data2="ATAQUE";
        }else if(data2.equals("DadoAtaqueEspecial")){
            num2= Integer.parseInt(ataqueEspecial.getText());
            ataqueEspecial.setText(String.valueOf(num2+1));
            data2="ATAQUE ESPECIAL";
        }
        panelResult.setVisible(true);
        resultDado1.setText(data1);
        resultDado2.setText(data2);
        resultDado3.setText(data3);
    }

    public void cambiarJugador(ActionEvent event) {
        gestorAbstractFactory.endTurn();
        gestorPrototype.endTurn();
        int data[]=gestorAbstractFactory.countInvocationDicesTestUI();
        int data2[]=gestorAbstractFactory.countAttackDicesUI();
        if(jugador==1){
            jugador=2;
            infanteria.setText(String.valueOf(data[0]));
            artilleria.setText(String.valueOf(data[1]));
            tanque.setText(String.valueOf(data[2]));
            ataque.setText(String.valueOf(data2[0]));
            ataqueEspecial.setText(String.valueOf(data2[1]));
            movimiento.setText(String.valueOf(data2[2]));
            campoNombreJ.setText("Paola");
        }else if(jugador==2){
            jugador=1;
            infanteria.setText(String.valueOf(data[0]));
            artilleria.setText(String.valueOf(data[1]));
            tanque.setText(String.valueOf(data[2]));
            ataque.setText(String.valueOf(data2[0]));
            ataqueEspecial.setText(String.valueOf(data2[1]));
            movimiento.setText(String.valueOf(data2[2]));
            campoNombreJ.setText("Tracy");
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
            BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundImage);
            Button button = (Button) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
            button.setBackground(background);
            node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                   "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");

            node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
            //node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                 //   "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
        }else if(p1==0){
            node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
            node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
            node4.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
        }
        else{
            if(jugador==1){
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Button button = (Button) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
               // node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                       // "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
            }else{
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Button button = (Button) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
               // node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                    //    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
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
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
            node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
            node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
            node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");

        }
        else{
            if(jugador==1){
                node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");;
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
            }else{
                node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");;
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
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
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
            node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
            node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
        }
        else{
            if(jugador==1){

                node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
            }else{

                node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow ;");
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
        String data3=invocacionDada3();
        System.out.println(data1);
        System.out.println(data2);
        rotate.pause();
        panelDado2.setVisible(false);
        mostrarResultados(data1,data2,data3);
    }

    public void cerrarFigura(MouseEvent mouseEvent) {
        pFiguras.setVisible(false);
    }

    public void cerrarInvocacin(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarTanque.setVisible(false);
        panelInvocarArtilleria.setVisible(false);
        terminarTurno.setOpacity(1);
        tirarDado.setOpacity(1);
    }

    public void cerrarInvocacin2(MouseEvent mouseEvent) {
        panelInvocarInfanteria.setVisible(false);
        panelInvocar2.setVisible(false);
        panelInvocarTanque.setVisible(false);
        panelInvocarArtilleria.setVisible(false);
        terminarTurno.setOpacity(1);
        tirarDado.setOpacity(1);
    }

    public void cerrarResultados2(MouseEvent mouseEvent) {
        panelResult2.setVisible(false);
        panelInvocarArtilleria.setVisible(false);
        panelInvocarTanque.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        terminarTurno.setOpacity(1);
        tirarDado.setOpacity(1);
    }

    public void cerrarTanque(MouseEvent mouseEvent) {
        panelInvocarTanque.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        panelInvocarArtilleria.setVisible(false);
        panelInvocar2.setVisible(false);
        terminarTurno.setOpacity(1);
        tirarDado.setOpacity(1);
    }

    public void cerrarIArtilleria(MouseEvent mouseEvent) {
        panelInvocarArtilleria.setVisible(false);
        panelInvocarArtilleria.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        panelInvocar2.setVisible(false);
        terminarTurno.setOpacity(1);
        tirarDado.setOpacity(1);
    }

    public void GUTHRUM(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(3, "Guthrum");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/8.png";
    }

    public void HAESTEN(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(3, "Haesten");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/7.png";
    }

    public void ODDA(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(3, "Odda");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/6.png";
    }

    public void BRIDA(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(3, "Brida");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/5.png";
    }

    public void jugadoresArtilleria(MouseEvent mouseEvent) {
        panelInvocarArtilleria.setVisible(true);
    }

    public void jugadoresTanque(MouseEvent mouseEvent) {
        panelInvocarTanque.setVisible(true);
    }

    public void UHTHRED(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(2, "Uhthred");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/10.png";
    }

    public void OSFERTH(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(2, "Osferth");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/11.png";
    }

    public void ISEULT(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(2, "Iseult");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/12.png";
    }

    public void LEOFIRC(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(2, "Leofirc");
        panelResult2.setVisible(true);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/13.png";
    }
}
