package backEnd.patrones.creacional.prototype.prototype.Artillery;

import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.creacional.prototype.iPrototype.Artillery;


public class Leofric extends Artillery {

   public Leofric(){
       super();
       this.setName("Leofric");
       this.setMovement(3);
   }


    @Override
    public Artillery clone() {
        return new Leofric();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }

}
