package RIDE;

import java.awt.geom.Point2D;

import AmusementPark.AmusementPark;

public class Ever_TExpress extends EverlandRide {

    public Ever_TExpress(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        super(amusementPark, "T Express", "Wooden Coaster", 0, new Point2D.Double(37.290130, 127.202590));        
    }
}
