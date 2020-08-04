package backEnd.patrones.comportamiento.observador.interfaces;

public interface Sujeto {
    void addObserver(Observador o);
    void removeObserver(Observador o);
    void notifyObservers();
}
