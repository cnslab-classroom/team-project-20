package RIDE.Everland_Rides;

import java.awt.geom.Point2D;
import AmusementPark.AmusementPark;
import AmusementPark.Everland;
import RIDE.Ride;
import RIDE.Ride.Ridetype;

public abstract class EverlandRide extends Ride {

    public static double[][] distance;

    // 생성자
    public EverlandRide(String rideName,
                Ridetype ridetype, int wait_time, Point2D.Double location){
        super(new Everland(), rideName, ridetype, wait_time, location);
        
    }

    public static void allDistances(Ride[] rides) {

        distance = Ride.calculateGeographicalDistances(rides);

    }

}
