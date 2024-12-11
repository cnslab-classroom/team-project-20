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

    // 놀이공원 생성자
    public AmusementPark(String name, Point2D.Double location) {
        this.name = name;
        this.location = location;
        rideList = new ArrayList<Ride>();
    }

    // 놀이기구 추가
    public void addRide(Ride ride){
        rideList.add(ride);
    }

    // 놀이공원 이름 반환
    public String getName() {
        return name;
    }

    // 놀이공원 위치 반환
    public Point2D.Double getLocation() {
        return location;
    }
    
    // 놀이공원 정보 출력
    public void displayInfo() {
        System.out.println("Welcome to " + name + "!\nLocation: " + location);
    }
}
