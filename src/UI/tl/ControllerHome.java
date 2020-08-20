package UI.tl;
import UI.principal.ToScene;
import UI.tl.Controller;
import backEnd.patrones.comportamiento.observador.observadores.ContollerObservador;
import backEnd.patrones.controller.comportamiento.visitor.ControllerVisitor;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import main.Main;

import java.io.File;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ControllerHome implements Initializable {

    @FXML private  AnchorPane finJuego;
    @FXML private AnchorPane pFiguras;
    @FXML private AnchorPane panelVStropas;
    @FXML private AnchorPane panelAtaques;
    @FXML private AnchorPane panelDado2;
    @FXML private AnchorPane panelInvocar2;
    @FXML private AnchorPane panelInvocarInfanteria;
    @FXML private AnchorPane panelInvocarArtilleria;
    @FXML private AnchorPane panelInvocarTanque;
    @FXML private  AnchorPane panelResult;
    @FXML private  AnchorPane panelResult2;
    @FXML private  AnchorPane panelInfoTropas;
    @FXML private AnchorPane panelMovimientos;
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
    @FXML private Label TInfanteria;
    @FXML private Label TNombre;
    @FXML private Label TCodigo;
    @FXML private Label TAtaque;
    @FXML private Label TMovimiento;
    @FXML private Label TDefensa;
    @FXML private Label TPasos;
    @FXML private Label setArribaAbajo;
    @FXML private Label setDerecha;
    @FXML private Label setIzquierda;
    @FXML private Label labelError;
    @FXML private Label labelError2;
    @FXML private Label labelAtaqueT1;
    @FXML private Label labelAtaqueT2;
    @FXML private Label labelAtaqueT3;
    @FXML private Label setArribaAbajoAtaque;
    @FXML private Label setDerechaAtaque;
    @FXML private Label setIzquierdaAtaque;
    @FXML private Label tipoAtaqueI;
    @FXML private Label tipoAtaqueD;
    @FXML private Label tipoAtaqueA;
    @FXML private Label nombreAtaqueTropas1;
    @FXML private Label nombreAtaqueTropas2;
    @FXML private Label tipoAtaqueTropas2;
    @FXML private Label tipoAtaqueTropas1;
    @FXML private Label ataqueAtaqueTropas1;
    @FXML private Label ataqueAtaqueTropas2;
    @FXML private Label defensaAtaqueTropas1;
    @FXML private Label defensaAtaqueTropas2;
    @FXML private Label vidaAtaqueTropas1;
    @FXML private Label vidaAtaqueTropas2;
    @FXML private Label resultVS;
    @FXML private Label vidaTorre1;
    @FXML private Label vidaTorre2;
    @FXML private TextField arribaAbajoTxt;
    @FXML private TextField izquierdaTxt;
    @FXML private TextField derechaTxt;
    @FXML private Rectangle rectangulo;
    @FXML private Label labelCambioMovimiento;
    @FXML private JFXButton btnAtaqueArriba;
    @FXML private JFXButton btnAtaqueDerecha;
    @FXML private JFXButton btnAtaqueIzquierda;
    @FXML private Label labelAtaqueArriba;
    @FXML private Label labelAtaqueDerecha;
    @FXML private Label labelAtaqueIzquierda;
    private int jugador=1;
    private String color="red";
    private String idB;
    private String idB2;
    private String nombTropaEnemiga;
    String urlTropaCambiar;
    String tipoTropa;
    String tropaCambiar;
    private int seconds=0;
    private int contSecond=0;
    private String urlTropa;
    RotateTransition rotate = new RotateTransition();
    private ControllerVisitor getGestorVisitor=new ControllerVisitor();
    private ContollerObservador gestorObservador=new ContollerObservador();
    private ControllerVisitor gestorVisitor=new ControllerVisitor();
    private ControllerPrototype gestorPrototype=new ControllerPrototype();
    private ControllerAbstractFactory gestorAbstractFactory=new ControllerAbstractFactory();
    HashMap<String, String> Tropas= new HashMap<String, String>();
    HashMap<String, String> TropasURL= new HashMap<String, String>();
    ArrayList<TropaJugador>tropaJugadors=new ArrayList<>();
    ArrayList<String>ids=new ArrayList<>();
    int px=0;
    int pj=0;
    int p1=0;
    String tropaActual="N/A";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gestorAbstractFactory.startPlayer1();
        gestorPrototype.startPlayer1();
        getGestorVisitor.startPlayer1();
        tablerosP.getChildren().clear();
        for (int i = 0; i <8 ; i++) {
            px++;
            VBox vbox = new VBox();
            for(int j=0; j<9;j++){
                Pane pane=new Pane();
                pane.setId(i+","+j);
                pane.setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color:  #2b3d52; -fx-background-color: #517d80;");
                pane.setOnMouseClicked(event -> {
                    verificarFigura(pane.getId());
                });
                vbox.getChildren().add(pane);
            }

            tablerosP.getChildren().add(vbox);
        }
    }

    public void verificarFigura(String id){

        idB=id;
        String[] arrOfStr = id.split(",", 2);
         p1= Integer.parseInt(arrOfStr[1]);
         pj=Integer.parseInt(arrOfStr[0]);
         if(tropaActual.equals("N/A")){
             buscarHasMap();
             if(ids.contains(id)){
                 String data[]=gestorPrototype.serchInfoArmyUI(buscarHasMap2(id));
                 for (int i = 0; i <data.length ; i++) {
                     tropaCambiar=data[0];
                     TInfanteria.setText(data[5]);
                     TNombre.setText(data[0]);
                     TCodigo.setText(data[1]);
                     TAtaque.setText(data[2]);
                     TDefensa.setText(data[3]);
                     TMovimiento.setText(data[4]);
                     tablerosP.setVisible(false);
                     panelInfoTropas.setVisible(true);
                 }
             }else {
                 tablerosP.setVisible(false);
                 pFiguras.setVisible(true);
             }
         }else{
             if(jugador==1){

             }
             TropaJugador tropaJugador=new TropaJugador(jugador,tropaActual,urlTropa,idB,tipoTropa);
             tropaJugadors.add(tropaJugador);
             tropaActual="N/A";
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
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/3.png";
        tropaActual="Aethelflaed";
        tipoTropa="INFANTERIA";
        updateInfoCant();
    }

    public void KJARTANJ(MouseEvent mouseEvent) {
        String data=gestorAbstractFactory.summonUnitMainUI(1, "Kjartan");
        panelInvocarInfanteria.setVisible(false);
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/2.png";
        tropaActual="Kjartan";
        tipoTropa="INFANTERIA";
        updateInfoCant();
    }

    public void FINNANJ(MouseEvent mouseEvent) {
        String data=gestorAbstractFactory.summonUnitMainUI(1, "Finnan");
        panelInvocarInfanteria.setVisible(false);
        panelInvocar2.setVisible(false);
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/1.png";
        tropaActual="Finnan";
        tipoTropa="INFANTERIA";
        updateInfoCant();
    }

    public void buscarHasMap(){
       /* for (String i : Tropas.keySet()) {
          System.out.println("key: " + i + " value: " + Tropas.get(i));
            ids.add(Tropas.get(i));
        }*/
        for (TropaJugador obj:tropaJugadors) {
            ids.add(obj.getLocalidad1());
        }
    }

    public String buscarHasMap2(String id){
        String data="";
        for (TropaJugador obj:tropaJugadors){
            if(obj.getLocalidad1().equals(id)){
                data=obj.getNombreTropa();
            }
        }
        return data;
    }
    public String buscarHasMap3(){
        String data="";
        for (TropaJugador obj:tropaJugadors){
            if(obj.getNombreTropa().equals(tropaCambiar)){
                data=obj.getUrlImg();
            }
        }
        return data;
    }
    public void BEOCCAJ(MouseEvent mouseEvent) {
        String data=gestorAbstractFactory.summonUnitMainUI(1, "Beocca");
        panelInvocarInfanteria.setVisible(false);
        panelInvocar2.setVisible(false);
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/4.png";
        tropaActual="Beocca";
        tipoTropa="INFANTERIA";
        updateInfoCant();
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

    public void updateInfoCant(){
        int data[]=gestorAbstractFactory.countInvocationDicesTestUI();
        int data2[]=gestorAbstractFactory.countAttackDicesUI();
        infanteria.setText(String.valueOf(data[0]));
        artilleria.setText(String.valueOf(data[1]));
        tanque.setText(String.valueOf(data[2]));
        ataque.setText(String.valueOf(data2[0]));
        ataqueEspecial.setText(String.valueOf(data2[1]));
        movimiento.setText(String.valueOf(data2[2]));
    }

    public void deleteTropa(){
        String idNuevo= "90"+","+"10";
        for (TropaJugador obj:tropaJugadors){
            if(obj.getLocalidad1().equals(idB2)){
                obj.setLocalidad1("90"+","+"10");
            }
        }
        for (int i = 0; i <ids.size() ; i++) {
            if(ids.get(i).equals(idB2)){

                ids.remove(idB2);
            }
        }

    }

    public void cambiarJugador(ActionEvent event) {
        gestorAbstractFactory.endTurn();
        gestorPrototype.endTurn();
        gestorVisitor.endTurn();
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
            gestorVisitor.limpiarVisitadores();
        }else if(jugador==2){
            jugador=1;
            infanteria.setText(String.valueOf(data[0]));
            artilleria.setText(String.valueOf(data[1]));
            tanque.setText(String.valueOf(data[2]));
            ataque.setText(String.valueOf(data2[0]));
            ataqueEspecial.setText(String.valueOf(data2[1]));
            movimiento.setText(String.valueOf(data2[2]));
            campoNombreJ.setText("Tracy");
            gestorVisitor.limpiarVisitadores();
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
            Pane button = (Pane) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
            button.setBackground(background);
            if(jugador==1){
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");

                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
                //node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                //   "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
            }else{
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  yellow;");

                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
                //node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                //   "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
            }

        }else if(p1==0){
            if(jugador==1){
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);

                // node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                // "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
                node4.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
            }else{
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);

                // node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                // "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
                node4.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
            }

        }
        else{
            if(jugador==1){
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
               //node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        //"    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  white;");
            }else{
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
               // node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                    //    "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
            }
        }
        verificarVidas();
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
            if(jugador==1){
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
                node3.getChildren().get(Integer.parseInt(arrOfStr[1])-2).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                //node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                // "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
            }else{
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane) node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
                node3.getChildren().get(Integer.parseInt(arrOfStr[1])-2).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                //node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                // "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
            }


        }
        else{
            if(jugador==1){
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button2 = (Pane) node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1);
                button2.setBackground(background);

                //node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                //  "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:pink;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");;
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  red;");
            }else{
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button3 = (Pane) node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1);
                button3.setBackground(background);

                //node3.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                // "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");;
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:  yellow;");
            }
        }
        verificarVidas();
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
            if(jugador==1){
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane)node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
               // node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                       // "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
            }else{
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane)node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1);
                button.setBackground(background);

                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                //node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                //"    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:green;");
                node4.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
            }

        }
        else{
            if(jugador==1){
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane)node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red;");
                //node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                //"    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:red ;");
            }else{
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(urlTropa).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane)node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button.setBackground(background);
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                //node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        //"    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow;");
                node.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("    -fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52; -fx-background-color:yellow ;");
            }
        }
        verificarVidas();
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
        rotate.pause();
        panelDado2.setVisible(false);
        mostrarResultados(data1,data2,data3);
    }

    public void cerrarFigura(MouseEvent mouseEvent) {
        pFiguras.setVisible(false);
        tablerosP.setVisible(true);
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
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/8.png";
        tropaActual="Guthrum";
        tipoTropa="TANQUE";
        updateInfoCant();
    }

    public void HAESTEN(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(3, "Haesten");
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/7.png";
        tropaActual="Haesten";
        tipoTropa="TANQUE";
        updateInfoCant();
    }

    public void ODDA(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(3, "Odda");
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/6.png";
        tropaActual="Odda";
        tipoTropa="TANQUE";
        updateInfoCant();
    }

    public void BRIDA(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(3, "Brida");
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/5.png";
        tropaActual="Brida";
        tipoTropa="TANQUE";
        updateInfoCant();
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
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/10.png";
        tropaActual="Uhthred";
        tipoTropa="ARTILLERIA";
        updateInfoCant();
    }

    public void OSFERTH(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(2, "Osferth");
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/11.png";
        tropaActual="Osferth";
        tipoTropa="ARTILLERIA";
        updateInfoCant();
    }

    public void ISEULT(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(2, "Iseult");
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/12.png";
        tropaActual="Iseult";
        tipoTropa="ARTILLERIA";
        updateInfoCant();
    }

    public void LEOFIRC(MouseEvent mouseEvent) {
        panelInvocar2.setVisible(false);
        panelInvocarInfanteria.setVisible(false);
        String data=gestorAbstractFactory.summonUnitMainUI(2, "Leofirc");
        panelResult2.setVisible(true);
        panelInvocar2.setVisible(false);
        resultInvocacion.setText(data);
        urlTropa="../img/DIBUJITOS/13.png";
        tropaActual="Leofirc";
        tipoTropa="ARTILLERIA";
        updateInfoCant();
    }

    public void cerrarInfoTropa(MouseEvent mouseEvent) {
        panelInfoTropas.setVisible(false);
        tablerosP.setVisible(true);
    }

    public void validarMovimientos(ActionEvent event) {
        int cont1 = 0,cont2 = 0,cont3 = 0;
        String[] arrOfStr = idB.split(",", 2);
        VBox node11;
       // VBox node11=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])-1);
        VBox node1=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node3=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
        VBox node5;
        VBox node4=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+2);
        //VBox node5=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+3);
        if(jugador==1){
            for (int i = 0; i <Integer.parseInt(arrOfStr[0])+1 ; i++) {
                if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])-i).getStyle().contains("red")){
                    cont1++;
                }
            }
        }else{
            for (int i = 0; i <Integer.parseInt(arrOfStr[0])+1 ; i++) {
                if(node2.getChildren().get(Integer.parseInt(arrOfStr[1])+i).getStyle().contains("yellow")){
                    cont1++;
                }
            }
        }
        int cap2=8-Integer.parseInt(arrOfStr[0]);
        for (int i = 0; i <cap2-1 ; i++) {
            node5=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+(i+1));
            if(jugador==1){
                if (node5.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont2++;
                }
            }else{
                if (node5.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont2++;
                }
            }

        }
        for (int i = 0; i <Integer.parseInt(arrOfStr[0]); i++) {
            node11=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])-(i+1));
            if(jugador==1){

                if (node11.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("red")){
                    cont3++;
                }
            }else{

                if (node11.getChildren().get(Integer.parseInt(arrOfStr[1])).getStyle().contains("yellow")){
                    cont3++;
                }
            }
        }
        setDerecha.setText(String.valueOf(cont2));
        setIzquierda.setText(String.valueOf(cont3));
        setArribaAbajo.setText(String.valueOf(cont1));
        if(jugador==1){
            labelCambioMovimiento.setText("Arriba");
        }else {
            labelCambioMovimiento.setText("Abajo");
        }
        tablerosP.setVisible(false);
        panelInfoTropas.setVisible(false);
        panelMovimientos.setVisible(true);
    }

    public void updateImg(String id){
        for (String tipo:ids) {
            if(tipo.equals(idB)){
                ids.remove(idB);
                break;
            }
        }
        ids.add(id);
        for (TropaJugador obj:tropaJugadors){
            if(obj.getNombreTropa().equals(tropaCambiar)){
                obj.setLocalidad1(id);
            }
        }
    }

    public void moverAbajoArriba(ActionEvent event) {
        if(gestorAbstractFactory.performActionMainUI(3)){
            String[] arrOfStr = idB.split(",", 2);
            VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
            int max= Integer.parseInt(arribaAbajoTxt.getText());

            if(jugador==1){
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(buscarHasMap3()).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane)node2.getChildren().get(Integer.parseInt(arrOfStr[1])-max);
                button.setBackground(background);
                updateImg(button.getId());
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
                updateInfoCant();
            }else{
                BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(buscarHasMap3()).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                Pane button = (Pane)node2.getChildren().get(Integer.parseInt(arrOfStr[1])+max);
                button.setBackground(background);
                updateImg(button.getId());
                node2.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  yellow;");
                updateInfoCant();
            }
        }else {
            labelError.setVisible(true);
        }
        verificarVidas();
    }

    public void cerrarMovimiento(MouseEvent mouseEvent) {
        panelMovimientos.setVisible(false);
        tablerosP.setVisible(true);
    }

    public void moverDerecha(ActionEvent event) {
        if(gestorAbstractFactory.performActionMainUI(3)){
            String[] arrOfStr = idB.split(",", 2);
            int max= Integer.parseInt(derechaTxt.getText());
            int max2=max-1;
            VBox node5;
            VBox node1=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
            VBox node6 =(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+(max2+1));
            node5=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
            BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(buscarHasMap3()).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundImage);
            Pane button = (Pane)node6.getChildren().get(Integer.parseInt(arrOfStr[1]));
            button.setBackground(background);
            updateImg(button.getId());
            updateInfoCant();
            if(jugador==1){
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
            }else{
                node1.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  yellow;");
            }

        }
        verificarVidas();
    }

    public void moverIzquierda(ActionEvent event) {
        if(gestorAbstractFactory.performActionMainUI(3)){
            String[] arrOfStr = idB.split(",", 2);
            int max= Integer.parseInt(izquierdaTxt.getText());
            int max2=max-1;
            VBox node6 =(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+(max2-1));
            BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(buscarHasMap3()).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundImage);
            Pane button = (Pane)node6.getChildren().get(Integer.parseInt(arrOfStr[1]));
            button.setBackground(background);
            updateImg(button.getId());
            updateInfoCant();


            String idProv=button.getId();
            String[] arrOfStr2 = idProv.split(",", 2);
            VBox node1 =(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr2[0])+1);
            Pane button2 = (Pane)node1.getChildren().get(Integer.parseInt(arrOfStr2[1]));

            if(jugador==1){
                button2.setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
            }else{
                button2.setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  yellow;");
            }

        }
        verificarVidas();
    }

    public void aumentarAtaque(ActionEvent event) {
        gestorVisitor.aumentarAtaqueUI(buscarHasMap2(idB),jugador);
        updateInfoCant();
    }

    public void cerrarAtaque(MouseEvent mouseEvent) {
        panelAtaques.setVisible(false);
        tablerosP.setVisible(true);
    }

    public void validarAtaques(ActionEvent event){
        int cont1 = 0,cont2 = 0,cont3 = 0;
        String[] arrOfStr = idB.split(",", 2);
        String data[]=new String[2];
        String derecha=arrOfStr[0];
        int num= Integer.parseInt(derecha);
        String valiId;
        int numTipo= Integer.parseInt(arrOfStr[0]);
        String tipo=(numTipo+1)+","+arrOfStr[1];

        //derecha
        if(/*ids.contains((arrOfStr[0]+1)+","+arrOfStr[1])*/ ids.contains(tipo)){
            valiId=(numTipo+1)+","+arrOfStr[1];
            cont1++;
            data=buscarTipoNombre(valiId);
            labelAtaqueT2.setText(data[0]);

        //izquierda
        }else if(ids.contains((num-1)+","+arrOfStr[1])){
            cont2++;
            valiId=(num-1)+","+arrOfStr[1];
            data=buscarTipoNombre(valiId);
            labelAtaqueT3.setText(data[0]);
        }
        //jugador1
        if(jugador==1){
            String arriba=arrOfStr[1];
            int num2= Integer.parseInt(arriba);
            if(ids.contains(arrOfStr[0]+","+(num2-1))){
                valiId=(arrOfStr[0])+","+(num2-1);
                cont3++;
                data=buscarTipoNombre(valiId);
                labelAtaqueT1.setText(data[0]);
            }
        }else {
            String arriba=arrOfStr[1];
            int num2= Integer.parseInt(arriba);
            if(ids.contains(arrOfStr[0]+","+(num2+1))){
                cont3++;
            }
        }
        setArribaAbajoAtaque.setText(String.valueOf(cont3));
        setDerechaAtaque.setText(String.valueOf(cont1));
        setIzquierdaAtaque.setText(String.valueOf(cont2));
        panelInfoTropas.setVisible(false);
        panelAtaques.setVisible(true);
    }

    public String[] buscarTipoNombre(String id){
        String data[]=new String[2];
        for (TropaJugador obj:tropaJugadors) {
            if(obj.getLocalidad1().equals(id)){
                data[0]=obj.getNombreTropa();
                data[1]=obj.getLocalidad2();
                idB2=obj.getLocalidad1();
                nombTropaEnemiga=obj.getNombreTropa();
            }
        }
        return data;
    }

    public void atacarAbajoArriba(ActionEvent event) {
        gestorPrototype.pruebaCambiarVida(nombTropaEnemiga);
        if(gestorAbstractFactory.performActionMainUI(1)){
            String data[]=gestorPrototype.serchInfoArmyUIJugador1(buscarHasMap2(idB));
            for (int i = 0; i <data.length ; i++) {
                nombreAtaqueTropas1.setText(data[0]);
                tipoAtaqueTropas1.setText(data[3]);
                ataqueAtaqueTropas1.setText(data[2]);
                defensaAtaqueTropas1.setText(data[5]);
                vidaAtaqueTropas1.setText(data[4]);
            }
            String data2[]=gestorPrototype.serchInfoArmyUIJugador2(nombTropaEnemiga);
            for (int i = 0; i <data2.length ; i++) {
                nombreAtaqueTropas2.setText(data2[0]);
                tipoAtaqueTropas2.setText(data2[3]);
                ataqueAtaqueTropas2.setText(data2[2]);
                defensaAtaqueTropas2.setText(data2[5]);
                vidaAtaqueTropas2.setText(data2[4]);
            }
            int ataqueMy= Integer.parseInt(ataqueAtaqueTropas1.getText());
            int defensaEnemiga= Integer.parseInt(tipoAtaqueTropas2.getText());
            if(ataqueMy<defensaEnemiga){
                resultVS.setText("EL ATAQUE ES MENOR A LA DENFENSA NI COSQUILLAS LE HIZO");
            }else if(ataqueMy==defensaEnemiga){
                resultVS.setText("TROPAS DE IGUAL NIVEL");
            }
            else {
                if(jugador==1){
                    if (gestorPrototype.vidaTropaMenosJugador2(nombreAtaqueTropas2.getText())){
                        String[] arrOfStr = idB.split(",", 2);
                        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
                        node2.getChildren().get(Integer.parseInt(arrOfStr[1])-1).setStyle("-fx-pref-height: 70;\n" +
                                "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  yellow;");
                        deleteTropa();
                    }

                }else{
                    if (gestorPrototype.vidaTropaMenosJugador1(nombreAtaqueTropas1.getText())){
                        String[] arrOfStr = idB.split(",", 2);
                        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
                        node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("-fx-pref-height: 70;\n" +
                                "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
                        deleteTropa();
                    }
                }
                resultVS.setText("TROPA AFECTADA VIDA--");
            }
        }else{
            resultVS.setText("NO TIENES LOS DADOS SUFUCIENTES");
        }
        verificarVidas();
        resultVS.setVisible(false);
        panelVStropas.setVisible(true);
    }

    public void revelarGanador(ActionEvent event) {
        resultVS.setVisible(true);
    }

    public void cerrarResultVS(MouseEvent mouseEvent) {
        resultVS.setVisible(false);
        panelVStropas.setVisible(false);
        panelAtaques.setVisible(false);
        tablerosP.setVisible(true);
    }

    public void atacarDerecha(ActionEvent event) {
        gestorPrototype.pruebaCambiarVida(nombTropaEnemiga);
        if(gestorAbstractFactory.performActionMainUI(1)){
            String data[]=gestorPrototype.serchInfoArmyUIJugador1(buscarHasMap2(idB));
            for (int i = 0; i <data.length ; i++) {
                nombreAtaqueTropas1.setText(data[0]);
                tipoAtaqueTropas1.setText(data[3]);
                ataqueAtaqueTropas1.setText(data[2]);
                defensaAtaqueTropas1.setText(data[5]);
                vidaAtaqueTropas1.setText(data[4]);
            }
            String data2[]=gestorPrototype.serchInfoArmyUIJugador2(nombTropaEnemiga);
            for (int i = 0; i <data2.length ; i++) {
                nombreAtaqueTropas2.setText(data2[0]);
                tipoAtaqueTropas2.setText(data2[3]);
                ataqueAtaqueTropas2.setText(data2[2]);
                defensaAtaqueTropas2.setText(data2[5]);
                vidaAtaqueTropas2.setText(data2[4]);
            }
            int ataqueMy= Integer.parseInt(ataqueAtaqueTropas1.getText());
            int defensaEnemiga= Integer.parseInt(tipoAtaqueTropas2.getText());
            if(ataqueMy<defensaEnemiga){
                resultVS.setText("EL ATAQUE ES MENOR A LA DENFENSA NI COSQUILLAS LE HIZO");
            }else if(ataqueMy==defensaEnemiga){
                resultVS.setText("TROPAS DE IGUAL NIVEL");
            }else{
                if(jugador==1){
                    if (gestorPrototype.vidaTropaMenosJugador2(nombreAtaqueTropas2.getText())){
                        String[] arrOfStr = idB.split(",", 2);
                        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
                        node2.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                                "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  yellow;");
                        deleteTropa();
                    }

                }else{
                    if (gestorPrototype.vidaTropaMenosJugador1(nombreAtaqueTropas1.getText())){
                        String[] arrOfStr = idB.split(",", 2);
                        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])+1);
                        node2.getChildren().get(Integer.parseInt(arrOfStr[1])).setStyle("-fx-pref-height: 70;\n" +
                                "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
                        deleteTropa();
                    }
                } resultVS.setText("TROPA AFECTADA VIDA--");
            }
        }else{
            resultVS.setText("NO TIENES LOS DADOS SUFUCIENTES");
        }
        verificarVidas();
        resultVS.setVisible(false);
        panelVStropas.setVisible(true);
    }

    public void atacarIzquierda(ActionEvent event) {
        gestorPrototype.pruebaCambiarVida(nombTropaEnemiga);
        if(gestorAbstractFactory.performActionMainUI(1)){
            String data[]=gestorPrototype.serchInfoArmyUIJugador1(buscarHasMap2(idB));
            for (int i = 0; i <data.length ; i++) {
                nombreAtaqueTropas1.setText(data[0]);
                tipoAtaqueTropas1.setText(data[3]);
                ataqueAtaqueTropas1.setText(data[2]);
                defensaAtaqueTropas1.setText(data[5]);
                vidaAtaqueTropas1.setText(data[4]);
            }
            String data2[]=gestorPrototype.serchInfoArmyUIJugador2(nombTropaEnemiga);
            for (int i = 0; i <data2.length ; i++) {
                nombreAtaqueTropas2.setText(data2[0]);
                tipoAtaqueTropas2.setText(data2[3]);
                ataqueAtaqueTropas2.setText(data2[2]);
                defensaAtaqueTropas2.setText(data2[5]);
                vidaAtaqueTropas2.setText(data2[4]);
            }
            int ataqueMy= Integer.parseInt(ataqueAtaqueTropas1.getText());
            int defensaEnemiga= Integer.parseInt(tipoAtaqueTropas2.getText());
            if(ataqueMy<defensaEnemiga){
                resultVS.setText("EL ATAQUE ES MENOR A LA DENFENSA NI COSQUILLAS LE HIZO");
            }else if(ataqueMy==defensaEnemiga){
                resultVS.setText("TROPAS DE IGUAL NIVEL");
            }else{
                if(jugador==1){
                    if (gestorPrototype.vidaTropaMenosJugador2(nombreAtaqueTropas2.getText())){
                        String[] arrOfStr = idB.split(",", 2);
                        VBox node1 =(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0])-1);
                        Pane button2 = (Pane)node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                        button2.setStyle("-fx-pref-height: 70;\n" +
                                "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  yellow;");
                        deleteTropa();
                    }

                }else{
                    if (gestorPrototype.vidaTropaMenosJugador1(nombreAtaqueTropas1.getText())){
                        String[] arrOfStr = idB.split(",", 2);
                        VBox node2=(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
                        node2.getChildren().get(Integer.parseInt(arrOfStr[1])+1).setStyle("-fx-pref-height: 70;\n" +
                                "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:  red;");
                        deleteTropa();
                    }
                }
                resultVS.setText("TROPA AFECTADA VIDA--");
            }
        }else{
            resultVS.setText("NO TIENES LOS DADOS SUFUCIENTES");
        }
        verificarVidas();
        resultVS.setVisible(false);
        panelVStropas.setVisible(true);
    }

    public void ataqueEspecial(ActionEvent event) {
    }

    public void verificarVidas() {
        int cont1=0;
        int cont2=0;
        int cantVida=0;
        int vida1=3;
        int vida2=3;
        String idSplit;
        for (TropaJugador obj:tropaJugadors){
            idSplit=obj.getLocalidad1();
            String[] arrOfStr = idSplit.split(",", 2);
            if(obj.getJugador()==1 && arrOfStr[1].equals("0")){
                cont1++;
                VBox node1 =(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
                Pane button2 = (Pane)node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button2.setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:red;");
                deleteTropa();
                cantVida= Integer.parseInt(vidaTorre1.getText());
                vidaTorre1.setText(String.valueOf(cantVida-1));
                if(gestorObservador.actualizarCastle1()){
                    tablerosP.setVisible(false);
                    finJuego.setVisible(true);
                }
            }
            if(obj.getJugador()==2 && arrOfStr[1].equals("8")){
                cont2++;
                VBox node1 =(VBox)tablerosP.getChildren().get(Integer.parseInt(arrOfStr[0]));
                Pane button2 = (Pane)node1.getChildren().get(Integer.parseInt(arrOfStr[1]));
                button2.setStyle("-fx-pref-height: 70;\n" +
                        "    -fx-pref-width: 70; -fx-border-color: #2b3d52;-fx-background-color:yellow;");
                deleteTropa();
                 cantVida= Integer.parseInt(vidaTorre1.getText());
                vidaTorre2.setText(String.valueOf(cantVida-1));
                if(gestorObservador.actualizarCastle2()){
                    tablerosP.setVisible(false);
                    finJuego.setVisible(true);
                }
            }

        }
      //  System.out.println("Llegaron arriba "+cont1);
       // System.out.println("Llegaron abajo "+cont2);
       // System.out.println(gestorObservador.actualizarCastle1());
    }

    public void cerrarJuego(MouseEvent mouseEvent) {
        new ToScene().toScene("../sample/sample.fxml", mouseEvent);
    }

    public void ataqueEspecialVida(ActionEvent event) {
        gestorVisitor.aumentarVida(buscarHasMap2(idB),jugador);
        updateInfoCant();
    }

    public void ataqueEspecialDefensa(ActionEvent event) {
        gestorVisitor.aumentarDefensa(buscarHasMap2(idB),jugador);
        updateInfoCant();
    }
}
