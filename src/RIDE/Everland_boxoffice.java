package RIDE;

import AmusementPark.AmusementPark;
import java.awt.geom.Point2D;

public class Everland_boxoffice extends EverlandRide {

    Point2D.Double location = new Point2D.Double(37.295302, 127.204583);

    public Everland_boxoffice(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        super(amusementPark, rideName, rideType, wait_time, location);

        this.location = location;

    }
    
}
