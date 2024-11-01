

public class App {
    public static void main(String[] args) throws Exception {
        Everland everland = new Everland("Yongin, South Korea");
        everland.displayInfo();

        Everland.Rides everlandRide = new Everland.Rides("T-Express", "Roller Coaster");
        everlandRide.displayRideInfo();

        LotteWorld lotteWorld = new LotteWorld("Seoul, South Korea");
        lotteWorld.displayInfo();

        LotteWorld.Rides lotteWorldRide = new LotteWorld.Rides("Gyro Drop", "Drop Tower");
        lotteWorldRide.displayRideInfo();    
        }
}
