package AmusementPark;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import RIDE.Ride;
import RIDE.Everland_Rides.Ever_AmazonExpress;
import RIDE.Everland_Rides.Ever_BoxOffice;
import RIDE.Everland_Rides.Ever_ColumbusAdventure;
import RIDE.Everland_Rides.Ever_DoubleRockspin;
import RIDE.Everland_Rides.Ever_TExpress;
import RIDE.Everland_Rides.Ever_ThunderFalls;


// Subclass of AmusementPark: Everland
public class Everland extends AmusementPark {

    // 모든 에버랜드 놀이기구 목록
    public ArrayList<Ride> everlandRides;

    // 에버랜드 놀이기구
    private static final Ride amazonExpress = new Ever_AmazonExpress();
    private static final Ride boxOffice = new Ever_BoxOffice();
    private static final Ride columbus = new Ever_ColumbusAdventure();
    private static final Ride doubleRockSpin = new Ever_DoubleRockspin();
    private static final Ride tExpress = new Ever_TExpress();
    private static final Ride thunderFalls = new Ever_ThunderFalls();

    // 에버랜드 공원 생성자
    public Everland() {
        super("Everland", new Point2D.Double(37.294115, 127.202470));
        everlandRides = new ArrayList<>();
        initializeRides();
    }


    private void initializeRides() {
        // 에버랜드 놀이기구 리스트 생성
        everlandRides.add(amazonExpress);
        everlandRides.add(boxOffice);
        everlandRides.add(columbus);
        everlandRides.add(doubleRockSpin);
        everlandRides.add(tExpress);
        everlandRides.add(thunderFalls);
    }

    public ArrayList<Ride> getEverlandRides() {
        return everlandRides;
    }    
}
