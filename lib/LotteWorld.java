package lib;

// Subclass of AmusementPark: LotteWorld
public class LotteWorld extends AmusementPark {
    public LotteWorld(String location) {
        super("Lotte World", location);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Welcome to Lotte World!");
    }
}