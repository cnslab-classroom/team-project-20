package RIDE.Lotte_Rides;

import AmusementPark.AmusementPark;
import AmusementPark.LotteWorld;
import RIDE.Ride;
import RIDE.Ride.Ridetype;

import java.awt.geom.Point2D;

public abstract class LotteRide extends Ride {
    
    public static double[][] distance;

    // 생성자
    public LotteRide(String rideName,
                        Ridetype adventure, int wait_time, Point2D.Double location){
        super(new LotteWorld() , rideName, adventure, wait_time, location);
    }

    public static void allDistances(Ride[] rides) {

        distance = Ride.calculateGeographicalDistances(rides);

    }
}
