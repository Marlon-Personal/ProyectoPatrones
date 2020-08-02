package backEnd.patrones.controller.creacionales.prototype;

import backEnd.patrones.creacional.prototype.iPrototype.*;
import backEnd.patrones.creacional.prototype.prototype.Artillery.*;
import backEnd.patrones.creacional.prototype.prototype.Infantry.*;
import backEnd.patrones.creacional.prototype.prototype.Tank.*;

import java.util.ArrayList;

public class ControllerPrototype {


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
    public static Artillery createArtilleryCharacter(String characther){
        switch (characther){
            case "Leofric":
                return new Leofric();
            case "Osferth":
                return new Osferth();
            case "Iseult":
                return new Iseult();
            case "Uhthred":
                return new Uhthred();
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
    public static Infantry createInfantryCharacter(String characther){
        switch (characther){
            case "Aethelflaed":
                return new Aethelflaed();
            case "Beocca":
                return new Beocca();
            case "Finnan":
                return new Finnan();
            case "Kjartan":
                return new Kjartan();
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
    public static Tank createTankCharacter(String characther){
        switch (characther){
            case "Brida":
                return new Brida();
            case "Heasten":
                return new Haesten();
            case "Guthrum":
                return new Guthrum();
            case "Odda":
                return new Odda();
            default:
                break;
        }
        return null;
    }





}
