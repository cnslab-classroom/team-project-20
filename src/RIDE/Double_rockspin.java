package RIDE;

import java.awt.geom.Point2D;
import AmusementPark.AmusementPark;

public class Double_rockspin extends EverlandRide {

    Point2D.Double location = new Point2D.Double();

    public Double_rockspin(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        super(amusementPark, rideName, rideType, wait_time, location);

        this.location = location;

    }
    
}
