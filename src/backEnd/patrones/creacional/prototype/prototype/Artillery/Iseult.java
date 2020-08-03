package backEnd.patrones.creacional.prototype.prototype.Artillery;


import backEnd.patrones.creacional.prototype.iPrototype.Artillery;

public class Iseult extends Artillery {

   public Iseult(){
       super();
       this.setName("Iseult");
       this.setMovement(2);
   }


    @Override
    public Artillery clone() {
        return new Iseult();
    }


    @Override
    public int getCode() {
        return this.getUnitCode();
    }
}
