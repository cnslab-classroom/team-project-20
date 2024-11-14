package RIDE;

import java.awt.geom.Point2D;
import AmusementPark.AmusementPark;


public class Columbus_adventure extends EverlandRide {

    Point2D.Double location = new Point2D.Double(37.294563, 127.199364);

    public Columbus_adventure(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        super(amusementPark, rideName, rideType, wait_time, location);

        this.location = location;

    }
    
}
