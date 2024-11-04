package RIDE;

import AmusementPark.AmusementPark;

public abstract class LotteRide extends Ride {
    // 다른 놀이기구와의 거리 배열

    // 생성자
    public LotteRide(AmusementPark amusementPark, String rideName,
                        String rideType, int wait_time, int location){
        super(amusementPark, rideName, rideType, wait_time, location);
    }
}
