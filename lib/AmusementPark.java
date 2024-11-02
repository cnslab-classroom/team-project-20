package lib;

// Base class: AmusementPark
public class AmusementPark {
    private String name;
    private String location; 
    private int wait_time;

    public AmusementPark(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void displayInfo() {
        System.out.println("Amusement Park: " + name + " | Location: " + location);
    }
}
