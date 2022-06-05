package g13c.cw5;

public abstract class Mineral extends Ingredient {
    protected int power;        // moc minerału
    public Mineral(String name, int baseReagent) {
        super(name, baseReagent);
    }

    @Override
    public int getPower() {
        return 0;
    }

    public int getReagent(){return baseReagent;}
}

    class Ore extends Mineral {
    private boolean metallic;       // określa czy ruda jest metaliczna czy nie

        public Ore(String name, int baseReagent, boolean metallic) {
            super(name, baseReagent);
            setMetallic(metallic);
        }

        public void setMetallic(boolean metallic) {
            this.metallic = metallic;
        }

        public boolean isMetallic() {
            return metallic;
        }

        public int getReagent(){
        int reagent = super.baseReagent;
        if (!metallic) {
            reagent=reagent/2;      // zwraca wartość reagentu, który pobiera wartość z klasy Mineral i zmniejsza ją w 2 razy, jeśli ruda nie jest metaliczna.
        }
        return reagent;
    }

    }

    class Crystal extends Mineral {
        private int magicPower;         // reprezentuje magiczną moc zawartą w krysztale
        public Crystal(String name, int baseReagent, int magicPower) {
            super(name, baseReagent);
            setMagicPower(magicPower);

        }

        public int getMagicPower() {
            return magicPower;
        }

        public void setMagicPower(int magicPower) {
            this.magicPower = magicPower;
        }

        public int getReagent(){
            int reagent = super.getReagent()+power;     // zwraca wartość reagentu, który pobiera wartość z klasy Mineral i dodaje magicPower.
            return reagent;

        }

    }
