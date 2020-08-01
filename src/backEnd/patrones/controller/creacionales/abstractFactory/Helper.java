package backEnd.patrones.controller.creacionales.abstractFactory;

import java.util.Random;

public class Helper {

    static int throwDice(){
        Random rand = new Random();

        int randomNum = rand.nextInt((6 - 1) + 1) + 1;
        return randomNum;
    }
}
