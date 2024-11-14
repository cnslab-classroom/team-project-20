package AmusementPark;

import java.util.ArrayList;
import java.util.List;
import RIDE.*;
import java.awt.geom.Point2D;



// Base class: AmusementPark
public abstract class AmusementPark {
    private String name;
    private Point2D.Double location;

    // 놀이기구 LIST
    private List<Ride> rideList;


    public AmusementPark(String name, Point2D.Double location) {
        this.name = name;
        this.location = location;
        rideList = new ArrayList<Ride>();
    }

    // 놀이기구 추가
    public void addRide(Ride ride){
        rideList.add(ride);
    }

    public String getName() {
        return name;
    }

    public Point2D.Double getLocation() {
        return location;
    }

    public void displayInfo() {
        System.out.println("Amusement Park: " + name + " | Location: " + location);
    }
}
