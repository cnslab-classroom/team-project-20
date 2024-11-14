package RIDE;

import java.awt.geom.Point2D;

import AmusementPark.AmusementPark;

public abstract class EverlandRide extends Ride {
    // 다른 놀이기구와의 거리 배열

    // 생성자
    public EverlandRide(AmusementPark amusementPark, String rideName,
                String rideType, int wait_time, Point2D.Double location){
        super(amusementPark, rideName, rideType, wait_time, location);
    }
}
