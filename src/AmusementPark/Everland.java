package AmusementPark;
import java.awt.geom.Point2D;


// Subclass of AmusementPark: Everland
public class Everland extends AmusementPark {
    public Everland() {
        super("Everland", new Point2D.Double(37.294115, 127.202470));
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Welcome to Everland!");
    }
}