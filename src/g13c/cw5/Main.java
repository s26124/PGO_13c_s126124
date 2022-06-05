package g13c.cw5;

public class Main {

    public static void main(String[] args) {


        Eliksir e1 = new Eliksir("Kozi Róg");
        System.out.println("Rozpoczęto tworzenie eliksira " + e1.getName());

        System.out.println("Tworzone składniki Liquid: ");
        Liquid whisky = new Alcohol("Jack Daniels", 150, 90, 10);
        System.out.println(whisky.getName() + " >> reagent: "+ whisky.getReagent());
        Liquid water = new Water("Woda", 7, 5, true);
        System.out.println(water.getName() + " >> reagent: "+ water.getReagent());

        System.out.println("Tworzone składniki Plants: ");
        Plant lilia = new Flower("Lilia", 10, 10);
        System.out.println(lilia.getName() + " >> reagent: "+ lilia.getReagent());
        Plant burak = new Root("Burak",20,6);
        System.out.println(burak.getName() + " >> reagent: "+ burak.getReagent());

        System.out.println("Tworzone składniki Minerals");
        Mineral diament = new Crystal("Diament", 10, 100);
        System.out.println(diament.getName() + " >> reagent: "+ diament.getReagent());
        Mineral platyna = new Ore("Platyna", 20, true);
        System.out.println(platyna.getName() + " >> reagent: "+ platyna.getReagent());

        System.out.println("Dodajemy składniki do eliksiru ");
        e1.addIngredient(whisky);
        e1.addIngredient(diament);
        e1.addIngredient(burak);
        e1.addIngredient(lilia);

        e1.setCatalyst(water);
        e1.printEliksir();
        e1.create();
        e1.setCatalyst(whisky);
        System.out.println("Moc eliksiru: "+ e1.getPower());






    }
}
