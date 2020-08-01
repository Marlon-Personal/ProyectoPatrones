package backEnd.patrones.creacional.abstractFactory.concrete_Factory;

import backEnd.patrones.creacional.abstractFactory.abstract_Factory.Dice_Obj;
import backEnd.patrones.creacional.abstractFactory.abstract_Product.Dice;
import backEnd.patrones.creacional.abstractFactory.concrete_Product.*;

public class Factory_DiceArtillery implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceArtillery newDice = new DiceArtillery();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
