package RIDE;

import AmusementPark.AmusementPark;

public abstract class Ride {
    private String rideName;
    private String rideType;
    private int wait_time;
    private int location;

    // 놀이기구가 위치한 놀이공원
    private AmusementPark amusementPark;
    // 다른 놀이기구와의 거리 배열

    public Ride(AmusementPark amusementPark, String rideName,
                String rideType, int wait_time, int location) {
        // 놀이공원에 놀이기구 등록
        this.amusementPark = amusementPark;
        amusementPark.addRide(this);

        this.rideName = rideName;
        this.rideType = rideType;
        this.wait_time = wait_time;
        this.location = location;
    }

    public void displayRideInfo() {
        System.out.println("Ride Name: " + rideName + " | Ride Type: " + rideType
                + " | wait time: " + wait_time + " | location: " + location );
    }


    public String getRideName(){
        return rideName;
    };

    public String getRideType(){
        return rideType;
    };

    public int getWaitTime(){
        return wait_time;
    };

    public int getLocation(){
        return location;
    };

}

