package backEnd.patrones.creacional.prototype.prototype.Infantry;


import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;
import backEnd.patrones.creacional.prototype.iPrototype.Infantry;

public class Aethelflaed extends Infantry {

   public Aethelflaed(){
       super();
       this.setName("Aethelflaed");
       this.setMovement(2);
   }


    @Override
    public Infantry clone() {
        return new Aethelflaed();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }


}
