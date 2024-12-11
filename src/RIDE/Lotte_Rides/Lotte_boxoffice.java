package RIDE.Lotte_Rides;

import AmusementPark.LotteWorld;
import RIDE.Ride.Ridetype;

import java.awt.geom.Point2D;

public class Lotte_boxoffice extends LotteRide {


    public Lotte_boxoffice() {
        
        super(new LotteWorld(), "Box Office", Ridetype.family, 0, new Point2D.Double(37.511493, 127.098853));

        // 다른 놀이 기구와 거리 설정 (37.511406, 127.098388)
    }
    
}
