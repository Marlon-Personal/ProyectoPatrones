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

    public void aumentarAtaque(String name){
        unit=cp.searchUnit(name);
        if (unit!=null){
            iVisitor= new MultiplicarAtaque();
            iVisitor.visit(unit);
            historial.put(name,iVisitor);
        }
    }

    public void aumentarDefensa(String name){
        unit=cp.searchUnit(name);
        if (unit!=null){
            iVisitor= new MultiplicarDefensa();
            iVisitor.visit(unit);
            historial.put(name,iVisitor);

        }
    }

    public void aumentarVida(String name){
        unit=cp.searchUnit(name);
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
        unit=cp.searchUnit(name);
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

}
