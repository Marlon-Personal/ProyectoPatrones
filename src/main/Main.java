package main;

import backEnd.patrones.controller.creacionales.abstractFactory.ControllerAbstractFactory;
import backEnd.patrones.controller.creacionales.prototype.ControllerPrototype;
import backEnd.patrones.creacional.prototype.iPrototype.Unit;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    public static ControllerAbstractFactory c = new ControllerAbstractFactory();
    public static ControllerPrototype cp = new ControllerPrototype();

    public static void main(String[] args) {
        int option = 0;

        do {
            option = showMainMenu();
            processFunction(option);
        } while (option !=5 );

    }


    private static int showMainMenu() {

        printer("Menú principal");
        printer("Seleccione una opción");
        printer("1. Lanzar dados");
        printer("2. Invocar tropas");
        printer("3. Realizar acciones (movimientos o ataques)");
        printer("5. Salir");

        return scan.nextInt();
    }

    public static void processFunction(int option ) {
        switch (option) {
            case 1:
              c.throwDice();
                break;
            case 2:
               summonTroopsMenu();
                break;
            case 3:
              actionsMenu();
                break;
            case 5:
                printer("Gracias por usar el sistema");
                break;
            default:
                printer("Opcion invalida");
                break;
        }
    }

    public static void summonTroopsMenu() {
        //printer(c.countInvocationDices());
        printer("Seleccione el tipo de unidad a invocar:");
        printer("1. Infantería");
        printer("2. Artillería");
        printer("3. Tanque");
        int option = scan.nextInt();
        String characther;

        printer("Seleccione una tropa de la lista");
        if(option ==1){
            printer(cp.returnInfantry());
        } else
        if(option == 2){
            printer(cp.returnArtillery());
        } else
        if(option == 3){
            printer(cp.returnTank());
        }
        characther = scan.next();
        c.summonUnitMain(option, characther);
    }

    public static void actionsMenu() {
        printer(c.countAttackDices());
        printer("Seleccione el tipo de acción a utilizar:");
        printer("1. Ataque");
        printer("2. Ataque Especial");
        printer("3. Movimineto");
        int option = scan.nextInt();
        String name = null;
        Unit unit;
        printer("Seleccione la tropa que va a utilizar la acción");
        printer(cp.getInfoArmy());
        name = scan.next();
        unit = cp.searchUnit(name);

        printer(unit.getUnitInformation());
        c.performActionMain(option);
    }


    public static void printer(String pData) {
        System.out.println(pData);
    }

}
