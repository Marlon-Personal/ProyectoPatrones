package backEnd.patrones.comportamiento.observador.observadores;

public class ContollerObservador {

    private ObservadorGame observadorGame = new ObservadorGame();
    private Castle castle1=new Castle();
    private Castle castle2=new Castle();

    public ContollerObservador(){
        castle1.addObserver(observadorGame);
        castle2.addObserver(observadorGame);
    }

    public boolean actualizarCastle1(){
        return castle1.recibirAtaque();
    }
    public boolean actualizarCastle2(){
        return castle2.recibirAtaque();
    }
}
