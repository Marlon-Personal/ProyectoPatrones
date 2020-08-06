package backEnd.patrones.estructurales.decorador;

import backEnd.patrones.creacional.prototype.iPrototype.Unit;

public abstract class TropaBoosteada implements Unit {
    protected Unit unit;

    public TropaBoosteada() {
    }

    public Unit getUnit() {
        return unit;
    }
}
