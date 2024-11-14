package RIDE;

import java.awt.geom.Point2D;

import AmusementPark.AmusementPark;

public class T_express extends EverlandRide {

    Point2D.Double locatoin = new Point2D.Double(37.290130, 127.202590);

    public T_express(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        super(amusementPark, rideName, rideType, wait_time, location);

        this.location = location;

        
    }
}
