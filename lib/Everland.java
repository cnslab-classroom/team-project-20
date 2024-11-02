package lib;

// Subclass of AmusementPark: Everland
public class Everland extends AmusementPark {
    public Everland(String location) {
        super("Everland", location);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Welcome to Everland!");
    }

    public static class Rides {
        private String rideName;
        private String rideType;

        public Rides(String rideName, String rideType) {
            this.rideName = rideName;
            this.rideType = rideType;
        }

        public void displayRideInfo() {
            System.out.println("Ride Name: " + rideName + " | Ride Type: " + rideType);
        }
    }
}
