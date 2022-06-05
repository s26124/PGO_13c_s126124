package g13c.cw5;

public abstract class Ingredient {
    protected String name;
    protected int baseReagent;
    public int getReagent(){
        return baseReagent;
    }

    public Ingredient(String name, int baseReagent) {
        setName(name);
        this.baseReagent = baseReagent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBaseReagent() {
        return baseReagent;
    }

    public abstract int getPower();
}
