package backEnd.patrones.creacional.abstractFactory.concrete_Factory.Unit;

import backEnd.patrones.creacional.abstractFactory.abstract_Factory.Army_Unit;
import backEnd.patrones.creacional.abstractFactory.abstract_Product.Unit;
import backEnd.patrones.creacional.abstractFactory.concrete_Product.Unit.*;

public class Factory_Infantry implements Army_Unit {
    @Override
    public Unit createUnit() {
        Infantry newUnit =  new Infantry();
        newUnit.setUnitCode(newUnit.generateUnitCode());
        newUnit.setUnitAttack(newUnit.generateUnitAttack());
        newUnit.setUnitDefense(newUnit.generateUnitDefense());
        newUnit.setUnitHP(newUnit.generateUnitHP());

        return newUnit;
    }
}
