package backEnd.patrones.creacional.prototype.prototype.Infantry;


import backEnd.patrones.creacional.prototype.iPrototype.Infantry;

public class Beocca extends Infantry {

   public Beocca(){
       super();
       this.setName("Beocca");
       this.setMovement(6);
   }


    @Override
    public Infantry clone() {
        return new Beocca();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }
}
