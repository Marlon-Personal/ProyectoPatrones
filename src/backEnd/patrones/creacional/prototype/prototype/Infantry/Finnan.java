package backEnd.patrones.creacional.prototype.prototype.Infantry;


import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.creacional.prototype.iPrototype.Infantry;

public class Finnan extends Infantry {

   public Finnan(){
       super();
       this.setName("Finnan");
       this.setMovement(6);
   }


    @Override
    public Infantry clone() {
        return new Finnan();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }

}
