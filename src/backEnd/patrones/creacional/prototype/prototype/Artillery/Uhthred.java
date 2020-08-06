package backEnd.patrones.creacional.prototype.prototype.Artillery;


import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.creacional.prototype.iPrototype.Artillery;


public class Uhthred extends Artillery {

   public Uhthred(){
       super();
       this.setName("Uhthred");
       this.setMovement(4);
   }


    @Override
    public Artillery clone() {
        return new Uhthred();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }

}
