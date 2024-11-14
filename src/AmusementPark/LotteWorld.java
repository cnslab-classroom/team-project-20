package AmusementPark;
import java.awt.geom.Point2D;

// Subclass of AmusementPark: LotteWorld
public class LotteWorld extends AmusementPark {
    public LotteWorld(Point2D.Double location) {
        super("Lotte World", location);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Welcome to Lotte World!");
    }
}