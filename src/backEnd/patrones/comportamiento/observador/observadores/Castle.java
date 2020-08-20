package backEnd.patrones.comportamiento.observador.observadores;

import backEnd.patrones.comportamiento.observador.interfaces.Observador;
import backEnd.patrones.comportamiento.observador.interfaces.Sujeto;

import java.util.ArrayList;

public class Castle implements Sujeto {
    private int lifes=4;
    //img logo
    private ArrayList<Observador> observadores= new ArrayList<Observador>();

    @Override
    public void addObserver(Observador o) {
        observadores.add(o);
    }

    @Override
    public void removeObserver(Observador o) {

    }

    @Override
    public boolean notifyObservers() {
        for (Observador o: observadores) {
          return o.update(lifes);
        }
        return true;
    }

    public boolean recibirAtaque(){
        lifes--;
       return notifyObservers();
    }
}
