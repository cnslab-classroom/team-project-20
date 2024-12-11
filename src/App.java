import AmusementPark.Everland;
import AmusementPark.LotteWorld;

import java.awt.geom.Point2D;


public class App {
    public static void main(String[] args) throws Exception {
     
        Everland everland = new Everland();
        everland.displayInfo();

        /*
        Everland.Rides everlandRide = new Everland.Rides("T-Express", "Roller Coaster");
        everlandRide.displayRideInfo();
        */
        
        LotteWorld lotteWorld = new LotteWorld();
        lotteWorld.displayInfo();
        
        /*
        LotteWorld.Rides lotteWorldRide = new LotteWorld.Rides("Gyro Drop", "Drop Tower");
        lotteWorldRide.displayRideInfo();
        */
        }
}
