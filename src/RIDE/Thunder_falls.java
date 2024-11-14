package RIDE;

import java.awt.geom.Point2D;
import AmusementPark.AmusementPark;

public class Thunder_falls extends EverlandRide {

    Point2D.Double location = new Point2D.Double(37.293877, 127.198578);

    public Thunder_falls(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        super(amusementPark, rideName, rideType, wait_time, location);

        this.location = location;

    }
    
}
