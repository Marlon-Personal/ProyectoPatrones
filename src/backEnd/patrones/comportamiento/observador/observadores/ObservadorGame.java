package backEnd.patrones.comportamiento.observador.observadores;

import backEnd.patrones.comportamiento.observador.interfaces.Observador;

public class ObservadorGame implements Observador {
    @Override
    public boolean update(int lifes) {
        boolean result=false;
        if (lifes<1){
            //Implementar game over aqui va
            result =true;
        }
        return result;
    }
}
