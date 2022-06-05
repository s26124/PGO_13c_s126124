package g13c.cw5;
import java.util.ArrayList;


public class Eliksir {
    private String name;                            // OK nazwa eliksiru (tylko ta zmienna jest potrzebna do konstruktora)
    private boolean isCreated=false;                // określa, czy eliksir został utworzony, czy nie. Nie można zmienić nigdzie, tylko jeden raz w metodzie Create. Wartość domyślna to false.
    private ArrayList<Ingredient> ingredients;      // lista składników w eliksirze
    private int power;                              // reprezentuje moc eliksiru (dostępne tylko wtedy, gdy isCreated ma wartość false)
    private Liquid catalyst;                        // reprezentuje katalizator eliksiru (nie można go zmienić, jeśli eliksir został już utworzony)


    public Eliksir(String name) {
        setName(name);
        //power = -1;
        ingredients = new ArrayList<>();
    }

    // dodaje składnik do listy (nie można dodać, jeśli eliksir został już utworzony)
    public void addIngredient(Ingredient ingredient){
        if(!isCreated){
            ingredients.add(ingredient);
        }
    }

    // usuwa składnik z listy (nie można go usunąć, jeśli eliksir został już utworzony)
    public void removeIngredient(Ingredient ingredient){
        if(!isCreated){
            ingredients.remove(ingredient);
        }
    }

    public Liquid getCatalyst() {
        return catalyst;
    }
    public void setCatalyst(Liquid ingredient) {
        if(!isCreated)
            this.catalyst = ingredient;
    }

    // tworzy eliksir. isCreated staje true. Moc wszystkich składników jest obliczana i przechowywana w polu power i dzieli się przez wartość reagentu
    // katalizatora (catalyst).
    public void create(){
        int i = 0;
        power = 0;
        while (i < ingredients.size()){
            if (ingredients.get(i).getClass() == Mineral.class){
                //power+=(ingredients.get(i).getPower(ingredients.get(i));
            }
            power+= ingredients.get(i).getReagent();
            i++;
        }
        power = power / catalyst.getReagent();
        isCreated = true;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printEliksir() {
        int i = 0;
        power=0;
        while (i < ingredients.size()) {
            System.out.println((i+1) + ". "+	(ingredients.get(i)).getName() + "|" +	(ingredients.get(i)).getReagent());
            i++;
        }
        System.out.println(	"Catalyst: "+ catalyst.getName() + "|" + catalyst.getReagent() );
    }


    public int getPower() {
        return power;
    }


}
