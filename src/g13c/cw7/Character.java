package g13c.cw7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Character {
    private Location location;
    private String name;
    private int health;
    private String action;
    protected int level;

    /* lista na potrzeby funkcji statycznych Character.status(); */
    private static List<Character> instances = new ArrayList<Character>();

    public Character(String name, Location location) {
        this.setName(name);
        this.setLocation(location);
        this.health=100;
        this.setAction("none");
        instances.add(this);
        this.setLevel(0);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void status() {

        System.out.println("====Status====");

        instances.sort(Comparator.comparing(Character::getLevel));
        for (Character character : instances) {
            System.out.println(character.getName()+" : "+character.getHealth());
        }
        //for(int i=0; i<instances.size(); i++) {

        //    System.out.println(instances.get(i).name + " : " + instances.get(i).health );
        //}
        System.out.println("==============");
    }


    public void say(String txt, Character chr) {
        System.out.println(this.name + " to " + chr.getName());
        System.out.println("    " + txt);
    }

    public void doSth(String txt) {
        this.setAction(txt);
        System.out.println("I am "+this.getName()+", I am " + this.getAction());
    }


    /* wykorzystanie grupy argumentow */
    public static void doSth(String txt, Character...args) {
        for(int i=0; i<args.length; i++) {
            args[i].doSth(txt);
        }
    }

    public void moveTo(Location newLocation) {
        this.setLocation(newLocation);

    }

    public void introduce() {
        System.out.println("Hello, I am " + this.name);
    }
    /* mozna bylo zrobic grupa argumentow, ale pokazuje umiejetnosc @Override methody */
    public static void MoveAllTo(Location newLocation, Character chr1, Character chr2) {
        chr1.setLocation(newLocation);
        chr2.setLocation(newLocation);
    }

    public static void MoveAllTo(Location newLocation, Character chr1, Character chr2,  Character chr3) {
        chr1.setLocation(newLocation);
        chr2.setLocation(newLocation);
        chr3.setLocation(newLocation);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void die() {
        this.setHealth(0);
        System.out.println(this.getName() + " died.");
    }

    public void remove() {
        Character.instances.remove(this);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}


/*  wykorzystanie grupy argumentow
public static void status(int arg0, int...args) {

 	System.out.println("1 argument stały: " + arg0);

 	for(int i=0; i<args.length; i++) {

 		System.out.println(i+1 + " argument zmienny: " + args[i]);
 	}
 }

*/