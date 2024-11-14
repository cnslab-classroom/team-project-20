package RIDE;

import AmusementPark.AmusementPark;
import java.awt.geom.Point2D;

public class Lotte_frenchRevolution extends LotteRide {

    Point2D.Double location = new Point2D.Double(37.510377, 127.097381);

    public Lotte_frenchRevolution(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        
        super(amusementPark, rideName, rideType, wait_time, location);
        this.location = location;

        // 다른 놀이 기구와 거리 설정 (37.511406, 127.098388)
    }
    
}



