package backEnd.patrones.creacional.prototype.prototype.Tank;


import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.creacional.prototype.iPrototype.Tank;

public class Brida extends Tank {

   public Brida(){
       super();
       this.setName("Brida");
       this.setMovement(2);
   }


    @Override
    public Tank clone() {
        return new Brida();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }

}
