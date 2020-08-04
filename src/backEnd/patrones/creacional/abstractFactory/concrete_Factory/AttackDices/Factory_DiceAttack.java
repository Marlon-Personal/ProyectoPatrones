package backEnd.patrones.creacional.abstractFactory.concrete_Factory.AttackDices;


import backEnd.patrones.creacional.abstractFactory.abstract_Factory.Dice_Obj;
import backEnd.patrones.creacional.abstractFactory.abstract_Product.Dice;
import backEnd.patrones.creacional.abstractFactory.concrete_Product.DiceAttack;

public class Factory_DiceAttack implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceAttack newDice = new DiceAttack();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
