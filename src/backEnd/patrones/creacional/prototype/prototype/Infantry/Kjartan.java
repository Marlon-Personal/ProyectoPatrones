package backEnd.patrones.creacional.prototype.prototype.Infantry;


import backEnd.patrones.creacional.prototype.iPrototype.Infantry;

public class Kjartan extends Infantry {

   public Kjartan(){
       super();
       this.setName("Kjartan");
       this.setMovement(5);
   }


    @Override
    public Infantry clone() {
        return new Kjartan();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }
}
