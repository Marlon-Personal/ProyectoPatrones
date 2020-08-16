package backEnd.patrones.creacional.prototype.iPrototype;

import backEnd.patrones.comportamiento.visitor.interfaces.IVisitor;

public interface Unit {
    public int generateUnitCode();
    public String getUnitInformation();
    public String  getUnitInformationUI();
    public int getCode();
    public String getName();
    public void Accept(IVisitor iVisitor);
    public void setUnitAttack(int attack);
    public int getUnitAttack();
    public void setUnitDefense(int attack);
    public int getUnitDefense();
    public int getUnitHP();
    public void setUnitHP(int hp);
}
