package backEnd.patrones.creacional.abstractFactory.concrete_Factory.AttackDices;

import backEnd.patrones.creacional.abstractFactory.abstract_Factory.Dice_Obj;
import backEnd.patrones.creacional.abstractFactory.abstract_Product.Dice;
import backEnd.patrones.creacional.abstractFactory.concrete_Product.*;


public class Factory_DiceMovement implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceMovement newDice = new DiceMovement();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
