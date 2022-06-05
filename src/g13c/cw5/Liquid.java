package g13c.cw5;

public abstract class Liquid extends Ingredient
{
    protected int dissolubility; // [od 0 do 100] - ilość jak dobrze katalizator rozpuszcza składniki
    public int getReagent(){return dissolubility;}

    @Override
    public int getPower() {
        return 0;
    }

    public Liquid(String name, int baseReagent, int dissolubility) {
        super(name, baseReagent);
        setDissolubility(dissolubility);
    }

    public void setDissolubility(int dissolubility) {
        if (dissolubility>0 && dissolubility<101)
        this.dissolubility = dissolubility;
        else throw new RuntimeException("Liczba musi byc z zakresu [0,100]");
    }
}

    class Water extends Liquid
    {
        public Water(String name, int baseReagent, int dissolubility, boolean distilated) {
            super(name, baseReagent, dissolubility);
            this.distilated = distilated;
        }

        public void setDistilated(boolean distilated) {
            this.distilated = distilated;
        }

        private boolean distilated;             // oznacza, czy woda jest destylowana
        public int getReagent(){
            int reagent = super.dissolubility;
            if (!distilated) {
                reagent=reagent/2;
            }
            return reagent;
        }     // zwraca wartość reagentu w zależności od procentu rozpuszczalności
    }

    class Alcohol extends Liquid
    {
        public Alcohol(String name, int baseReagent, int dissolubility, int percentage) {
            super(name, baseReagent, dissolubility);
            setPercentage(percentage);
        }

        public void setPercentage(int percentage) {
            if (percentage>0 && percentage<101)
                this.percentage = percentage;
            else throw new RuntimeException("Liczba musi byc z zakresu [0,100]");
        }

        private int percentage;                 // [od 0 do 100] reprezentuje procent alkoholu w płynie
        public int getReagent()
        {   int reagent = super.dissolubility-percentage;
            return reagent;
        }
    }

