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
import RIDE.Lotte_Rides.Lotte_atlantisAdventure;
import RIDE.Lotte_Rides.Lotte_boxoffice;
import RIDE.Lotte_Rides.Lotte_conquistador;
import RIDE.Lotte_Rides.Lotte_flumeride;
import RIDE.Lotte_Rides.Lotte_frenchRevolution;
import RIDE.Lotte_Rides.Lotte_pharaohFury;

// Subclass of AmusementPark: LotteWorld
public class LotteWorld extends AmusementPark {

    // 모든 에버랜드 놀이기구 목록
    private ArrayList<Ride> lotteWorldRides;

    // 에버랜드 놀이기구
    private static final Ride atlantisAdventure = new Lotte_atlantisAdventure();
    private static final Ride boxOffice = new Lotte_boxoffice();
    private static final Ride conquistador = new Lotte_conquistador();
    private static final Ride flumeRide = new Lotte_flumeride();
    private static final Ride frenchRevolution = new Lotte_frenchRevolution();
    private static final Ride pharoahFury = new Lotte_pharaohFury();

    public LotteWorld() {
        super("Lotte World",new Point2D.Double(37.511205, 127.098371));

        lotteWorldRides = new ArrayList<>();
        initializeRides();
    }

    private void initializeRides() {
            // 에버랜드 놀이기구 리스트 생성
            lotteWorldRides.add(atlantisAdventure);
            lotteWorldRides.add(boxOffice);
            lotteWorldRides.add(conquistador);
            lotteWorldRides.add(flumeRide);
            lotteWorldRides.add(frenchRevolution);
            lotteWorldRides.add(pharoahFury);
    }

    public ArrayList<Ride> getLotteWorldRides() {
        return lotteWorldRides;
    }    
}