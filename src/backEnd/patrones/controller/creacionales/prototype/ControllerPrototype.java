package backEnd.patrones.controller.creacionales.prototype;

import backEnd.patrones.controller.creacionales.abstractFactory.ControllerAbstractFactory;
import backEnd.patrones.creacional.prototype.iPrototype.*;
import backEnd.patrones.creacional.prototype.prototype.Artillery.*;
import backEnd.patrones.creacional.prototype.prototype.Infantry.*;
import backEnd.patrones.creacional.prototype.prototype.Tank.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControllerPrototype {

    /**Llamado del controlador de la fabrica abstracta, la que implementa la logica de los dados**/
    public ControllerAbstractFactory c = new ControllerAbstractFactory();

    /**Array para las unidades que van siendo creadas**/
    public static HashMap<String, Unit> armyArray = new HashMap<String, Unit>();

    /**Array para las unidades que van siendo creadas del jugador 2**/
    public static HashMap<String, Unit> armyArray2 = new HashMap<String, Unit>();

    public boolean jugador;

    /**ArrayLists creados solo para imprimir los nombres de los personajes en pantalla,
     *se puede usar para pintar los personajes en el UI a la hora de hacer la selección de personaje**/
    public ArrayList<String> artilleryArray = new ArrayList<String>();
    public ArrayList<String> infantryArray = new ArrayList<String>();
    public ArrayList<String> tankArray = new ArrayList<String>();

    /**Constructor para llenar los arraylists con la lista de personajes disponibles**/
    public ControllerPrototype (){
        //Personajes de Artilleria
        artilleryArray.add("Osferth");
        artilleryArray.add("Leofric");
        artilleryArray.add("Iseult");
        artilleryArray.add("Uhthred");

        //Personajes de Infanteria
        infantryArray.add("Aethelflaed");
        infantryArray.add("Beocca");
        infantryArray.add("Finnan");
        infantryArray.add("Kjartan");

        //Personajes de Tanque
        tankArray.add("Brida");
        tankArray.add("Haesten");
        tankArray.add("Guthrum");
        tankArray.add("Odda");
    }


    /**Regresa la lista de personajes dentro del array de artilleria**/
    public String returnArtillery(){
        String list = "";
        for(int i = 0; i < artilleryArray.size(); i++){
            list += artilleryArray.get(i) + "\n";
        }
        return list;
    }

    /**Es llamado desde el controlador de la fabrica abstracta, donde se toma la lógica de los dados
     * Se encarga de crear el personaje de artilleria según su nombre*/
    public Artillery createArtilleryCharacter(String characther ){
        switch (characther){
            case "Leofric":
                if(funcionSingleton(characther)) {
                    return new Leofric();
                } else {
                    return null;
                }
            case "Osferth":
                if(funcionSingleton(characther)) {
                    return new Osferth();
                } else {
                    return null;
                }

            case "Iseult":
                if(funcionSingleton(characther)) {
                    return new Iseult();
                } else {
                    return null;
                }

            case "Uhthred":
                if(funcionSingleton(characther)) {
                    return new Uhthred();
                } else {
                    return null;
                }

            default:
                break;
        }
        return null;
    }


    /**Regresa la lista de personajes dentro del array de infanteria**/
    public String returnInfantry(){
        String list = "";
        for(int i = 0; i < infantryArray.size(); i++){
            list += infantryArray.get(i) + "\n";
        }
        return list;
    }



    /**Es llamado desde el controlador de la fabrica abstracta, donde se toma la lógica de los dados
     * Se encarga de crear el personaje de infanteria según su nombre*/
    public Infantry createInfantryCharacter(String characther ){
        switch (characther){
            case "Aethelflaed":
                if(funcionSingleton(characther)) {
                    return new Aethelflaed();
                } else {
                    return null;
                }
            case "Beocca":
                if(funcionSingleton(characther)) {
                    return new Beocca();
                } else {
                    return null;
                }
            case "Finnan":
                if(funcionSingleton(characther)) {
                    return new Finnan();
                } else {
                    return null;
                }
            case "Kjartan":
                if(funcionSingleton(characther)) {
                    return new Kjartan();
                } else {
                    return null;
                }
            default:
                break;
        }
        return null;
    }

    /**Regresa la lista de personajes dentro del array de tanque**/
    public String returnTank(){
        String list = "";
        for(int i = 0; i < tankArray.size(); i++){
            list += tankArray.get(i) + "\n";
        }
        return list;
    }

    /**Es llamado desde el controlador de la fabrica abstracta, donde se toma la lógica de los dados
     * Se encarga de crear el personaje de tanque según su nombre*/
    public Tank createTankCharacter(String characther){
        switch (characther){
            case "Brida":
                if(funcionSingleton(characther)){
                    return new Brida();
                } else return null;
            case "Heasten":
                if(funcionSingleton(characther)){
                    return new Haesten();
                } else return null;
            case "Guthrum":
                if(funcionSingleton(characther)){
                    return new Guthrum();
                } else return null;
            case "Odda":
                if(funcionSingleton(characther)){
                    return new Odda();
                } else return null;
            default:
                break;
        }
        return null;
    }

    public boolean funcionSingleton(String name){
        if(jugador){
            if(armyArray.size()>0){
                if(searchUnit(name) == null){
                    return true;
                }else{
                    System.out.println("El personaje ya ha sido agregado, no puede invocar dos veces el mismo personaje");
                    return false;
                }
            } else {
                return true;
            }
        } else {
            if(armyArray2.size()>0){
                if(searchUnit(name) == null){
                    return true;
                }else{
                    System.out.println("El personaje ya ha sido agregado, no puede invocar dos veces el mismo personaje");
                    return false;
                }
            } else {
                return true;
            }
        }

    }

    public void addToArmyArray(Unit pObjUnit, boolean jugador) {
        if(jugador){
            if(pObjUnit != null){
                armyArray.put(pObjUnit.getName(), pObjUnit);
            }
        } else {
            if(pObjUnit != null){
                armyArray2.put(pObjUnit.getName(), pObjUnit);
            }
        }

    }
    //funcion para buscar una tropa UI
    public String[] serchInfoArmyUI(String name) {
        String msData[]=new String[7];
        if(jugador){
            for (String i : armyArray.keySet()) {
                if(armyArray.get(i).getName().equals(name)){
                    msData[0]=armyArray.get(i).getName();
                    msData[1]= String.valueOf(armyArray.get(i).getCode());
                    msData[2]= String.valueOf(armyArray.get(i).getUnitAttack());
                    msData[3]= String.valueOf(armyArray.get(i).getUnitDefense());
                    msData[4]= String.valueOf(armyArray.get(i).getUnitHP());
                    msData[5]=armyArray.get(i).getUnitInformationUI();
                }
            }
        } else {
            for (String i : armyArray2.keySet()) {
                if(armyArray2.get(i).getName().equals(name)){
                    msData[0]=armyArray2.get(i).getName();
                    msData[1]= String.valueOf(armyArray2.get(i).getCode());
                    msData[2]= String.valueOf(armyArray2.get(i).getUnitAttack());
                    msData[3]= String.valueOf(armyArray2.get(i).getUnitDefense());
                    msData[4]= String.valueOf(armyArray2.get(i).getUnitHP());
                    msData[5]=armyArray2.get(i).getUnitInformationUI();
                }
            }
        }


        return msData;
    }

    public String getInfoArmy() {
        String msData="";
        if(jugador){
            for(Map.Entry<String, Unit> entry : armyArray.entrySet()){
                msData = msData + entry.getValue().getUnitInformation() + "\n";
            }
        } else {
            for(Map.Entry<String, Unit> entry : armyArray2.entrySet()){
                msData = msData + entry.getValue().getUnitInformation() + "\n";
            }
        }


        return msData;
    }

    public Unit searchUnit(String name){
        boolean exists = false;
        if(jugador){
            if(armyArray.size()>0){
                for(Map.Entry<String, Unit> entry : armyArray.entrySet()){
                    if(entry.getKey().equals(name)){
                        exists = true;
                    }
                }

            } else {
                return armyArray.get(name);
            }

            if(exists){
                return armyArray.get(name);
            } else {
                return null;
            }
        } else {
            if(armyArray2.size()>0){
                for(Map.Entry<String, Unit> entry : armyArray2.entrySet()){
                    if(entry.getKey().equals(name)){
                        exists = true;
                    }
                }

            } else {
                return armyArray2.get(name);
            }

            if(exists){
                return armyArray2.get(name);
            } else {
                return null;
            }
        }

    }

    public void endTurn(){
        if(jugador){
            jugador = false;
        } else {
            jugador = true;
        }
    }

    public void startPlayer1(){
        jugador = true;
    }

}
