package backEnd.patrones.creacional.prototype.iPrototype;

import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;

public abstract class Tank implements Unit{
    private int unitCode;
    private String unitType;
    private int unitAttack;
    private int unitDefense;
    private int unitHP;
    private String name;
    private int movement;

    public Tank() {
        this.unitCode = 300000 + generateUnitCode();
        this.unitAttack = 10;
        this.unitDefense = 15;
        this.unitHP = 2;
        this.unitType = "Tanque";
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getUnitCode() {
        return unitCode;
    }

    public void setUnitCode() {
        this.unitCode = 100000 + generateUnitCode();
    }

    public int generateUnitCode() {
        return (int) (Math.random() * 9999);
    }

    public String getUnitType() {
        return unitType;
    }

    public int getUnitAttack() {
        return unitAttack;
    }

    public void setUnitCode(int unitCode) {
        this.unitCode = unitCode;
    }

    public void setUnitAttack(int unitAttack) {
        this.unitAttack = unitAttack;
    }

    public void setUnitDefense(int unitDefense) {
        this.unitDefense = unitDefense;
    }

    public void setUnitHP(int unitHP) {
        this.unitHP = unitHP;
    }

    public int getUnitDefense() {
        return unitDefense;
    }

    public int getUnitHP() {
        return unitHP;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUnitInformation() {
        return "La únidad de tipo: " + getUnitType() + ", se le asigno el código: " + getUnitCode()+ " y el nombre: "+ getName() +
                ", tiene un limite de pasos de: "+getMovement()+
                ". Tiene un valor de ataque de: " + getUnitAttack()+ ", un valor de defensa de: " + getUnitDefense()+
                ", y un movimiento total de: " + getUnitHP();
    }

    //Solamente para UI
    public String getUnitInformationUI() {
        return getUnitType();
    }

    /**New abstract clases for prototype**/

    public abstract Tank clone();

    @Override
    public void Accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }

}
