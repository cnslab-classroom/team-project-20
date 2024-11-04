package AmusementPark;

import java.util.ArrayList;
import java.util.List;
import RIDE.*;

// Base class: AmusementPark
public abstract class AmusementPark {
    private String name;
    private String location;

    // 놀이기구 LIST
    private List<Ride> rideList;


    public AmusementPark(String name, String location) {
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

    public String getLocation() {
        return location;
    }

    public void displayInfo() {
        System.out.println("Amusement Park: " + name + " | Location: " + location);
    }
}
