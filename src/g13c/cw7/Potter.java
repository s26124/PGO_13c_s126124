package g13c.cw7;

public class Potter extends Child {

    public Potter(String name, Location location) {
        super(name, location);
        setLevel(1);
        if (name.equals("Harry")){ setLevel(3); }
    }
    public void goLOL() {
        System.out.println(this.getName() + " goes LOL...");
    }
}
