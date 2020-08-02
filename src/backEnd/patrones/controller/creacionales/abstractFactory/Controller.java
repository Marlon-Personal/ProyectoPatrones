package backEnd.patrones.controller.creacionales.abstractFactory;


import backEnd.patrones.creacional.abstractFactory.abstract_Factory.Army_Unit;
import backEnd.patrones.creacional.abstractFactory.abstract_Factory.Dice_Obj;
import backEnd.patrones.creacional.abstractFactory.abstract_Product.Dice;
import backEnd.patrones.creacional.abstractFactory.abstract_Product.Unit;
import backEnd.patrones.creacional.abstractFactory.concrete_Factory.*;
import backEnd.patrones.creacional.abstractFactory.concrete_Factory.AttackDices.*;
import backEnd.patrones.creacional.abstractFactory.concrete_Factory.Unit.*;

import java.util.*;

public class Controller {

    public static ArrayList<Dice> diceArray = new ArrayList<Dice>();

    public static String throwDice() {
        throwInvocationDices();
        throwAttackDices();

        return "\n" + "Dados lanzados de manera exitosa" + "\n";
    }


    /**Esta función habilita el lanzamiento de los dados para invocación y y llama a la función que guarda
     *en el arreglo de dados el tipo de invocación obtenida.
     */

    public static void throwInvocationDices() {
        Dice_Obj moUnit;

        for (int i = 0; i < 2; i++) {
            int diceResult = Helper.throwDice();
            if (diceResult == 1 || diceResult == 2 || diceResult == 3) {
                moUnit = new Factory_DiceInfantry();
                System.out.println("El resultado del dado fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));
            } else if (diceResult == 4 || diceResult == 5) {
                moUnit = new Factory_DiceArtillery();
                System.out.println("El resultado del dado fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));
            } else {
                moUnit = new Factory_DiceTank();
                System.out.println("El resultado del dado fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));
            }
        }
    }
    /**Esta funcion es la que crea la instancia del dado y la guarda en el array**/
    public static String CreateDiceFactory(Dice_Obj pFactory) {
        Dice objDice = pFactory.createDiceInstance();
        addToArray(objDice);
        return objDice.getType();
    }

    /**Esta función habilita que las instancias obtenidas sean guardadas en el array**/
    private static void addToArray(Dice pObjDice) {
        int att, spAtt, mov, inf, art, tank;
        att = countDicesPerUnit("DadoAtaque");
        spAtt = countDicesPerUnit("DadoAtaqueEspecial");
        mov = countDicesPerUnit("DadoMovimiento");
        inf = countDicesPerUnit("DadoInfanteria");
        art = countDicesPerUnit("DadoArtilleria");
        tank = countDicesPerUnit("DadoTanque");

        if (pObjDice.getType().equals("DadoArtilleria")||pObjDice.getType().equals("DadoInfanteria")||pObjDice.getType().equals("DadoTanque")){
            if(inf+art+tank<6){
                diceArray.add(pObjDice);
            } else {
                System.out.println("No se pueden agregar más dados de invocación, se ha alcanzado el tope máximo de 6");
            }
        } else {
            switch (pObjDice.getType()){
                case "DadoAtaque":
                    if(att < 3){
                        diceArray.add(pObjDice);
                    } else {
                        System.out.println("No se pueden agregar más dados de ataque, se ha alcanzado el tope máximo de 3");
                    }
                    break;
                case "DadoAtaqueEspecial":
                    if(spAtt < 2){
                        diceArray.add(pObjDice);
                    } else {
                        System.out.println("No se pueden agregar más dados de ataque especial, se ha alcanzado el tope máximo de 3");
                    }
                    break;
                case "DadoMovimiento":
                    if(mov < 3){
                        diceArray.add(pObjDice);
                    } else {
                        System.out.println("No se pueden agregar más dados de movimiento, se ha alcanzado el tope máximo de 3");
                    }
                    break;
            }
        }
    }

    /**Esta función nos ayuda a contar cuantas instancias de invocación hay actualmente para poder invocar las tropas.
     * Recuerden que
     * Infanteria requiere como mínimo 2 instancias para invocar
     * Artilleria requiere como mínimo 3 instancias para invocar
     * Tanques requieren como mínimo 4 instancias para invocar
     **/
    public static String countInvocationDices() {
        int artillery = 0, infantry = 0, tanks = 0;
        for (int i = 0; i < diceArray.size(); i++) {
            if (diceArray.get(i).getType().equals("DadoArtilleria")) {
                artillery++;
            } else if (diceArray.get(i).getType().equals("DadoInfanteria")) {
                infantry++;
            } else if (diceArray.get(i).getType().equals("DadoTanque")) {
                tanks++;
            }
        }
        return "Dados disponibles:" + "\n" +
                "Infantería: " + infantry + "\n" +
                "Artillería: " + artillery + "\n" +
                "Tanque: " + tanks + "\n";
    }


    /**Esta función se asegura de que existan la cantidad de tropas necesarias para la invocación
     * Como es de validación, imprime en pantalla cuando no es posible crear la tropa.
     * Cuando es posible crear la tropa, llama a la siguiente función que instancia la tropa
     */
    public static void summonUnitMain(int unitType) {

        switch (unitType) {
            case 1:
                if (countDicesPerUnit("DadoInfanteria") >= 2) {
                    summonUnit(unitType);
                } else {
                    System.out.println("No se puede invocar la infantería, insuficientes dados");
                }
                break;

            case 2:
                if (countDicesPerUnit("DadoArtilleria") >= 3) {
                    summonUnit(unitType);
                } else {
                    System.out.println("No se puede invocar la artillería, insuficientes dados");
                }
                break;

            case 3:
                if (countDicesPerUnit("DadoTanque") >= 4) {
                    summonUnit(unitType);
                } else {
                    System.out.println("No se puede invocar el tanque, insuficientes dados");
                }
                break;

            default:
                break;

        }

    }

    /**Esta función simplemente hace un conteo indivual por tipo de tropa para reconcer de manera más rápida si es posible invocar
     * la tropa dependiendo de la cantidad de instancias del dado guardadas en el array
     */

    public static int countDicesPerUnit(String diceType) {
        int total = 0;
        for (int i = 0; i < diceArray.size(); i++) {
            if (diceArray.get(i).getType().equals(diceType)) {
                total++;
            }
        }
        return total;
    }


    /**Esta función se encarga de crear la tropa dependiendo del tipo de objeto seleccionado. Luego llama a la funcion
     * que guarda la tropa en el arreglo y elimina las instancias de dados utilizadas para poder llamar la tropa
     *
     * */
    public static void summonUnit(int unitType) {
        Army_Unit moUnit;

        switch (unitType) {
            case 1:
                moUnit = new Factory_Infantry();
                System.out.println(CreateUnitFactory(moUnit));
                removeDicesUnit("DadoInfanteria");
                break;

            case 2:
                moUnit = new Factory_Artillery();
                System.out.println(CreateUnitFactory(moUnit));
                removeDicesUnit("DadoArtilleria");
                break;

            case 3:
                moUnit = new Factory_Tank();
                System.out.println(CreateUnitFactory(moUnit));
                removeDicesUnit("DadoTanque");
                break;

            default:
                break;
        }


    }

    /**Función que crea la tropa y la guarda en el arreglo**/
    public static String CreateUnitFactory(Army_Unit pFactory) {
        Unit objUnit = pFactory.createUnit();
        addToArmyArray(objUnit);
        return objUnit.getUnitInformation();
    }

    /**Funcion que remueve las instancias utilizadas de el arreglo de invocaciones**/
    public static void removeDicesUnit(String diceType) {
        int dicesRemoved = 0;
        switch (diceType) {
            case "DadoInfanteria":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <2) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
                break;
            case "DadoArtilleria":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <3) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
                break;
            case "DadoTanque":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <4) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
            case "DadoAtaque":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <1) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
            case "DadoAtaqueEspecial":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <1) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
            case "DadoMovimiento":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <1) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
            default:
                break;
        }
    }

    private static HashMap<Integer, Unit> armyArray = new HashMap<Integer, Unit>();

    private static void addToArmyArray(Unit pObjUnit) {
        armyArray.put(pObjUnit.getCode(), pObjUnit);
    }

    public static String getInfoArmy() {
        String msData="";
        for(Map.Entry<Integer, Unit> entry : armyArray.entrySet()){
            msData = msData + entry.getValue().getUnitInformation() + "\n";
        }

        return msData;
    }




    //Nuevas funcionalidades

    /**Funcionalidad que permite lanzar los dados de ataque, ataque especial y movimiento
     * El CreateDiceFactory para estos dados y para los dados de invocación es el mismo**/
    public static void throwAttackDices() {
        Dice_Obj moUnit;


        int diceResult = Helper.throwDice();
        if (diceResult == 1 || diceResult == 2) {
            moUnit = new Factory_DiceAttack();
            System.out.println("El resultado del dado de ataques y movimiento fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));
        } else if (diceResult == 4 || diceResult == 5) {
            moUnit = new Factory_DiceSpAttack();
            System.out.println("El resultado del dado de ataques y movimiento fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));
        } else {
            moUnit = new Factory_DiceMovement();
            System.out.println("El resultado del dado de ataques y movimiento fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));

        }
    }


    /**Esta función es igual a countInvocationDices(). En caso de ser necesario se pueden unir. La razón por la cual están separadas,
     * es para poder trabajarlas mejor en cosola a la hora de debuggear
     * **/
    public static String countAttackDices() {
        int spAtt = 0, att = 0, mov = 0;

        for (int i = 0; i < diceArray.size(); i++) {
            if (diceArray.get(i).getType().equals("DadoAtaque")) {
                att++;
            } else if (diceArray.get(i).getType().equals("DadoAtaqueEspecial")) {
                spAtt++;
            } else if (diceArray.get(i).getType().equals("DadoMovimiento")) {
                mov++;
            }
        }
        return "Dados de acción disponibles:" + "\n" +
                "Ataque: " + att + "\n" +
                "Ataque Especial: " + spAtt + "\n" +
                "Movimiento: " + mov + "\n";
    }


    /**Esta función valida que hayan los dados suficientes para poder realizar la acción de ataque, ataque especial o movimiento**/
    public static void performActionMain(int unitType) {

        switch (unitType) {
            case 1:
                if (countDicesPerUnit("DadoAtaque") >= 1) {
                    useAttack(unitType);
                } else {
                    System.out.println("No se puede realizar el ataque, insuficientes dados");
                }
                break;

            case 2:
                if (countDicesPerUnit("DadoAtaqueEspecial") >= 1) {
                    useAttack(unitType);
                } else {
                    System.out.println("No se puede realizar el ataque especial, insuficientes dados");
                }
                break;

            case 3:
                if (countDicesPerUnit("DadoMovimiento") >= 1) {
                    useAttack(unitType);
                } else {
                    System.out.println("No se puede realizar el movimiento, insuficientes dados");
                }
                break;

            default:
                break;

        }

    }

    /**Esta función define que tipo de acción se va a emplear, las acciones pueden ser ataque, ataque especial o moviemiento
     * Migue llama las funciones de el en esta parte**/
    public static void useAttack(int unitType) {
        Army_Unit moUnit;

        switch (unitType) {
            case 1:
                //Funcionalidad de ataque va aqui
                System.out.println("Se ha efectuado el ataque");
                removeDicesUnit("DadoAtaque");
                break;

            case 2:
                //Funcionalidad de ataque especial va aqui
                System.out.println("Se ha efectuado el ataque especial");
                removeDicesUnit("DadoAtaqueEspecial");
                break;

            case 3:
                //Funcionalidad de movimiento va aqui
                System.out.println("Se ha movido la tropa");
                removeDicesUnit("DadoMovimiento");
                break;

            default:
                break;
        }

    }
}