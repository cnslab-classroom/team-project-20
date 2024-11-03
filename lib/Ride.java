package lib;

public class Ride {
    
    private String rideName;
    private String rideType;

    public Ride(String rideName, String rideType) {
        this.rideName = rideName;
        this.rideType = rideType;
    }
    public void displayRideInfo() {
        System.out.println("Ride Name: " + rideName + " | Ride Type: " + rideType);
    }
}
