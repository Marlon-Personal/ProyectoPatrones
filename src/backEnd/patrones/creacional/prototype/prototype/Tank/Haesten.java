package backEnd.patrones.creacional.prototype.prototype.Tank;


import backEnd.patrones.creacional.prototype.iPrototype.Tank;

public class Haesten extends Tank {

   public Haesten(){
       super();
       this.setName("Haesten");
       this.setMovement(2);
   }


    @Override
    public Tank clone() {
        return new Haesten();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }
}
