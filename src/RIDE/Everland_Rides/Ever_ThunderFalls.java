package RIDE.Everland_Rides;

import java.awt.geom.Point2D;
import AmusementPark.AmusementPark;
import AmusementPark.Everland;
import RIDE.Ride.Ridetype;

public class Ever_Thunderfalls extends EverlandRide {


    public Ever_Thunderfalls() {
        super(new Everland(), "Thunderfalls", Ridetype.adventure, 0, new Point2D.Double(37.293877, 127.198578));
    }
    
}