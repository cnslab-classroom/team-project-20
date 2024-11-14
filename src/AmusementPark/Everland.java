package AmusementPark;
import java.awt.geom.Point2D;


// Subclass of AmusementPark: Everland
public class Everland extends AmusementPark {
    public Everland(Point2D.Double location) {
        super("Everland", location);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Welcome to Everland!");
    }
}