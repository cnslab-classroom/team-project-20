package RIDE;

import java.awt.geom.Point2D;
import AmusementPark.AmusementPark;

public abstract class EverlandRide extends Ride {

    public static double[][] distance;

    // 생성자
    public EverlandRide(AmusementPark amusementPark, String rideName,
                Ridetype ridetype, int wait_time, Point2D.Double location){
        super(amusementPark, rideName, ridetype, wait_time, location);
        
    }

    public static void allDistances(Ride[] rides) {

        distance = Ride.calcDistances(rides);

    }

}
