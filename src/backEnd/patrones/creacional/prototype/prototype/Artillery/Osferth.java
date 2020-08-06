package backEnd.patrones.creacional.prototype.prototype.Artillery;

import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.creacional.prototype.iPrototype.Artillery;


public class Osferth extends Artillery {

   public Osferth(){
       super();
       this.setName("Osferth");
       this.setMovement(4);
   }


    @Override
    public Artillery clone() {
        return new Osferth();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }

}
