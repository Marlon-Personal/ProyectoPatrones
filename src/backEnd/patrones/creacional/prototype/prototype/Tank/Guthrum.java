package backEnd.patrones.creacional.prototype.prototype.Tank;


import backEnd.patrones.creacional.prototype.iPrototype.Tank;

public class Guthrum extends Tank {

   public Guthrum(){
       super();
       this.setName("Guthrum");
       this.setMovement(1);
   }


    @Override
    public Tank clone() {
        return new Guthrum();
    }

    @Override
    public int getCode() {
        return this.getUnitCode();
    }
}
