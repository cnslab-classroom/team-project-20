package RIDE;

import AmusementPark.AmusementPark;
import java.awt.geom.Point2D;

public abstract class LotteRide extends Ride {
    
    public static double[][] distance;

    // 생성자
    public LotteRide(AmusementPark amusementPark, String rideName,
                        Ridetype adventure, int wait_time, Point2D.Double location){
        super(amusementPark, rideName, adventure, wait_time, location);
    }

    public static void allDistances(Ride[] rides) {

        distance = Ride.calcDistances(rides);

    }
}
