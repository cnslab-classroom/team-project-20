package lib;

// Subclass of AmusementPark: Everland
public class Everland extends AmusementPark {
    public Everland(String location) {
        super("Everland", location);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Welcome to Everland!");
    }
}