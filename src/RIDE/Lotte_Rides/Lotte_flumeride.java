package RIDE.Lotte_Rides;

import AmusementPark.LotteWorld;
import RIDE.Ride.Ridetype;

import java.awt.geom.Point2D;

public class Lotte_flumeride extends LotteRide {


    public Lotte_flumeride() {
        
        super(new LotteWorld(), "Flume Ride", Ridetype.adventure, 0, new Point2D.Double(37.511456, 127.098698));

    }
    
}


