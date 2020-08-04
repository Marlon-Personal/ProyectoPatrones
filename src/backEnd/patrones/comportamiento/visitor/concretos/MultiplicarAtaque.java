package backEnd.patrones.comportamiento.visitor.concretos;

import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.creacional.prototype.iPrototype.Unit;

public class MultiplicarAtaque implements IVisitor {

    @Override
    public void visit(Unit unit) {
        unit.setUnitAttack(unit.getUnitAttack()*2);
    }

}
