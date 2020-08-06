package backEnd.patrones.creacional.prototype.prototype.Tank;


import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.creacional.prototype.iPrototype.Tank;

public class Odda extends Tank {

   public Odda(){
       super();
       this.setName("Odda");
       this.setMovement(2);
   }


    @Override
    public Tank clone() {
        return new Odda();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }

}
