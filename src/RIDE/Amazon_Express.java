package RIDE;

import java.awt.geom.Point2D;
import AmusementPark.AmusementPark;

public class Amazon_Express extends EverlandRide {

    Point2D.Double location = new Point2D.Double(37.291420, 127.205789);

    public Amazon_Express(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        super(amusementPark, rideName, rideType, wait_time, location);

        this.location = location;

    }
    
}
