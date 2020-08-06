package backEnd.patrones.comportamiento.visitor.interfaces;

import backEnd.patrones.creacional.prototype.iPrototype.Unit;

public interface IVisitor {
    public void visit(Unit unit);
}
