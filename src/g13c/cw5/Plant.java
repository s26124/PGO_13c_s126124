package g13c.cw5;

public abstract class Plant extends Ingredient{
    private int toxity;

    public Plant(String name, int baseReagent, int toxity) {
        super(name, baseReagent);
        setToxity(toxity);
    }

    public int getToxity() {
        return toxity;
    }

    public void setToxity(int toxity) {
        this.toxity = toxity;
    }

    // zwraca wartość baseReagent ze składnika i mnoży ją przez toksyczność.
    public int getReagent(){
        int reagent = baseReagent*toxity;
        return reagent;
    }
}

class Flower extends Plant{

    public Flower(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    public int getReagent(){
        int reagent = super.getReagent()*2;
        return reagent;
    }

    @Override
    public int getPower() {
        return 0;
    }

}

class Root extends Plant{

    public Root(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }
    public int getReagent(){
        int reagent = super.getReagent()/2;
        return reagent;
    }

    @Override
    public int getPower() {
        return 0;
    }
}
