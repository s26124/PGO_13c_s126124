package g13c.cw7;

import java.util.ArrayList;
import java.util.List;

public class Orphanage extends Location{
    private String name;
    private Location location;
    private List<Child> children =null;

    public Orphanage(String name, Location location) {
        super(name);
        this.setLocation(location);
        children = new ArrayList<>();
    }

    public void addChild(Child child) {
        children.add(child);
        child.setLocation(this.location);
    }

    public void rmChild(Child child) {
        children.remove(child);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location london) {
        this.location = london;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
