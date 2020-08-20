package backEnd.patrones.controller.comportamiento.visitor;

import backEnd.patrones.comportamiento.visitor.concretos.*;
import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.controller.creacionales.prototype.ControllerPrototype;
import backEnd.patrones.creacional.prototype.iPrototype.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControllerVisitor {

    public static ControllerPrototype cp = new ControllerPrototype();
    private IVisitor iVisitor;
    private Unit unit;
    private HashMap<String, IVisitor>historial=new HashMap<String, IVisitor>();
    private ArrayList<String>limpiador= new ArrayList<String>();

    //Siempre que esté en true, es el turno del jugador 1
    public boolean jugador;

    public void aumentarAtaque(String name){
        unit=searchUnit(name);
        if (unit!=null){
            iVisitor= new MultiplicarAtaque();
            iVisitor.visit(unit);
            historial.put(name,iVisitor);
        }
    }
    public void aumentarAtaqueUI(String name,int jugador){
        if(jugador==1){
            unit= searchUnit2(name);
        }else {
            unit= searchUnit1(name);
        }
        if (unit!=null){
            iVisitor= new MultiplicarAtaque();
            iVisitor.visit(unit);
            historial.put(name,iVisitor);
        }
    }
    public void aumentarDefensa(String name,int jugador){
        if(jugador==1){
            unit= searchUnit2(name);
        }else {
            unit= searchUnit1(name);
        }
        if (unit!=null){
            iVisitor= new MultiplicarDefensa();
            iVisitor.visit(unit);
            historial.put(name,iVisitor);

        }
    }

    public void aumentarVida(String name,int jugador){
        if(jugador==1){
            unit= searchUnit2(name);
        }else {
            unit= searchUnit1(name);
        }
        if (unit!=null){
            iVisitor= new SumarVida();
            iVisitor.visit(unit);
            historial.put(name,iVisitor);
        }
    }

    public void limpiarVisitadores(){
        historial.forEach((k,v) -> limpiar(k,v));
        limpiarHistorial();
    }

    private void limpiar(String name, IVisitor visitor){
        unit=searchUnit(name);
        String tipo= visitor.getClass().getName().toString();
        if (unit!=null){
            if (tipo.equals("backEnd.patrones.comportamiento.visitor.concretos.MultiplicarAtaque")){
                iVisitor=new QuitarAtaque();
                iVisitor.visit(unit);
                limpiador.add(name);
            }
            else if (tipo.equals("backEnd.patrones.comportamiento.visitor.concretos.MultiplicarDefensa")) {
                iVisitor = new QuitarDefensa();
                iVisitor.visit(unit);
                limpiador.add(name);
            }
        }
    }

    private void limpiarHistorial(){
        for (String v:limpiador) {
            historial.remove(v);
        }
        limpiador.clear();
    }

    public void startPlayer1(){
        jugador = true;
    }

    public void endTurn(){
        if(jugador){
            jugador = false;
        } else {
            jugador = true;
        }
    }
    public Unit searchUnit2(String name){
        boolean exists = false;
            if(cp.armyArray.size()>0){
                for(Map.Entry<String, Unit> entry : cp.armyArray.entrySet()){
                    if(entry.getKey().equals(name)){
                        exists = true;
                    }
                }

            } else {
                return cp.armyArray.get(name);
            }

            if(exists){
                return cp.armyArray.get(name);
            } else {
                return null;
            }
    }
    public Unit searchUnit1(String name){
        boolean exists = false;
            if(cp.armyArray2.size()>0){
                for(Map.Entry<String, Unit> entry : cp.armyArray2.entrySet()){
                    if(entry.getKey().equals(name)){
                        exists = true;
                    }
                }

            } else {
                return cp.armyArray2.get(name);
            }

            if(exists){
                return cp.armyArray2.get(name);
            } else {
                return null;
            }
        }

    public Unit searchUnit(String name){
        boolean exists = false;
        if(jugador){
            if(cp.armyArray.size()>0){
                for(Map.Entry<String, Unit> entry : cp.armyArray.entrySet()){
                    if(entry.getKey().equals(name)){
                        exists = true;
                    }
                }

            } else {
                return cp.armyArray.get(name);
            }

            if(exists){
                return cp.armyArray.get(name);
            } else {
                return null;
            }
        } else {
            if(cp.armyArray2.size()>0){
                for(Map.Entry<String, Unit> entry : cp.armyArray2.entrySet()){
                    if(entry.getKey().equals(name)){
                        exists = true;
                    }
                }

            } else {
                return cp.armyArray2.get(name);
            }

            if(exists){
                return cp.armyArray2.get(name);
            } else {
                return null;
            }
        }

    }
}
