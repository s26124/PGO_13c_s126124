package g13c.cw7;

public class Location {
    private String name;
    public static final Location London = new Location("London");
    public static final Location GodricsHollow = new Location("GodricsHollow");
    public static final Location Hogwarts  = new Location("Hogwarts");
    public static final Location England  = new Location("England");

    public Location(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}