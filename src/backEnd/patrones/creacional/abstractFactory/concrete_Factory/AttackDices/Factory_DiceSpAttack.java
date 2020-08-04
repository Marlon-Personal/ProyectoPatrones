package backEnd.patrones.creacional.abstractFactory.concrete_Factory.AttackDices;

import backEnd.patrones.creacional.abstractFactory.abstract_Factory.Dice_Obj;
import backEnd.patrones.creacional.abstractFactory.abstract_Product.Dice;
import backEnd.patrones.creacional.abstractFactory.concrete_Product.*;


public class Factory_DiceSpAttack implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceSpAttack newDice = new DiceSpAttack();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
