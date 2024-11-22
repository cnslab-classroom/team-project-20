package RIDE;

import AmusementPark.AmusementPark;
import java.awt.geom.Point2D;

public class Lotte_boxoffice extends LotteRide {


    public Lotte_boxoffice(AmusementPark amusementPark, String rideName, String rideType, int wait_time, Point2D.Double location) {
        
        super(amusementPark, "Box Office", "Box Office", 0, new Point2D.Double(37.511493, 127.098853));

        // 다른 놀이 기구와 거리 설정 (37.511406, 127.098388)
    }
    
}