package backEnd.patrones.comportamiento.observador.observadores;

import backEnd.patrones.comportamiento.observador.interfaces.Observador;

public class ObservadorGame implements Observador {
    @Override
    public void update(int lifes) {
        if (lifes<1){
            //Implementar game over
        }
    }
}
