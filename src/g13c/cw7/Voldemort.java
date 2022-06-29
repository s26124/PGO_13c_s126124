package g13c.cw7;


import java.util.ArrayList;
import java.util.List;

public class Voldemort extends Child {


    private int horcruxNo;
    private List<Character> targetList;

    public Voldemort(String name, Location location) {
        super(name, location);
        setLevel(2);
    }

    public Voldemort(Riddle tom) {

        super("Lord Voldemort",tom.getLocation());
        this.setHealth(tom.getHealth());
        this.targetList=new ArrayList<Character>();
        setLevel(2);
        tom.remove();
    }



    public void createHorcruxes(int i) {
        this.setHorcruxNo(i+this.getHorcruxNo());

    }

    public void printHorcruxes() {
        System.out.println("Created horcruxes:");
        for(int i=1; i<=horcruxNo; i++) {
            System.out.println("    horcrux " + i );
        }
    }




    public int getHorcruxNo() {
        return horcruxNo;
    }



    public void setHorcruxNo(int horcruxNo) {
        this.horcruxNo = horcruxNo;
    }

    public void target(Character character) {
        this.targetList.add(character);
    }

    public void removeTarget() {
        this.targetList.clear();
    }



    public void castSpell(String action) {
        for(int i=0; i<targetList.size(); i++) {
            switch(action) {
                case "kill":
                    if(targetList.get(i).getName()=="Harry") {
                        ((Potter) targetList.get(i)).goLOL();
                        this.die();
                    }
                    else {
                        targetList.get(i).die();
                    }
                    break;
                default:

            }
        }







    }

}