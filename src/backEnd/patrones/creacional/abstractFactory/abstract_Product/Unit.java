package backEnd.patrones.creacional.abstractFactory.abstract_Product;

public interface Unit {
    public String unitCode();
    public int generateUnitCode();


    public String unitAttack();
    public int generateUnitAttack();


    public String unitDefense();
    public int generateUnitDefense();


    public String unitHP();
    public int generateUnitHP();


    public String getUnitInformation();


    public int getCode();
    public int getAttack();
}
