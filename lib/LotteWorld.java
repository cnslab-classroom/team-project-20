package lib;

// Subclass of AmusementPark: LotteWorld
public class LotteWorld extends AmusementPark {
    public LotteWorld(String location) {
        super("Lotte World", location);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Welcome to Lotte World!");
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
