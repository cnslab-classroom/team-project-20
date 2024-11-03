package lib;

public class Ride {
    
    private String rideName;
    private String rideType;
    private int wait_time;
    private int location; 

    public Ride(String rideName, String rideType, int wait_time, int location) {
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

    public int getRideType(){
        return rideType;
    };

    public int getWaitTime(){
        return wait_time;
    };
    
    public int getLocation(){
        return location;
    }; 

}


public class Texpress extends Everland {
    public Ride ride; 
    private int distance[10];

    public Texpress(String rideName, String rideType, int wait_time, int location) {
        this.ride = new Ride(String rideName, String rideType, int wait_time, int location);
    }
}
