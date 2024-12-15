package RIDE;

import AmusementPark.AmusementPark;

import java.awt.geom.Point2D;



import java.util.ArrayList;
import java.util.List;




// Ride Class
public abstract class Ride {

    // 특정 타입에 해당하는 놀이기구 반환
    public static List<Ride> getRidesByType(List<Ride> allRides, List<String> types) {
        List<Ride> filteredRides = new ArrayList<>();
    
        for (Ride ride : allRides) {
            if (types.contains(ride.getRideType())) {
                filteredRides.add(ride);
            }
        }
    
        return filteredRides;
    }
    

    // 놀이기구 타입
    public enum Ridetype {
        thrill, adventure, water, family, horror, fantasy, kids, interactive
    }

    private String rideName;
    private String rideType;
    private int wait_time = 0;
    private Point2D.Double location;

    // 놀이기구가 위치한 놀이공원
    private AmusementPark amusementPark;

    public Ride(AmusementPark amusementPark, String rideName,
                Ridetype ridetype, int wait_time, Point2D.Double location) {
        // 놀이공원에 놀이기구 등록
        this.amusementPark = amusementPark;
        amusementPark.addRide(this);

        this.rideName = rideName;
        this.rideType = ridetype.name();
        this.wait_time = wait_time;
        this.location = location;
    }

    public void displayRideInfo() {
        System.out.println("Ride Name: " + rideName + " | Ride Type: " + rideType
                + " | wait time: " + wait_time + " | location: " + location);
    }

    // getter
    public String getRideName() {
        return rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public int getWaitTime() {
        return wait_time;
    }

    public Point2D.Double getLocation() {
        return location;
    }

    // setter
    public void setWaitTime(int wait_time) {
        this.wait_time = wait_time;
    }

    // 두 놀이기구 간 거리 계산
    public double calculateDistanceBetweenRides(Ride ride2) {
        int EARTH_RADIUS = 6371; // 지구 반지름 (단위: km)

        // 각 놀이기구의 위치 정보
        Point2D.Double location1 = this.location;
        Point2D.Double location2 = ride2.getLocation();

        // 각 놀이기구의 위도, 경도 값을 라디안 단위로 변환
        double latitude1 = Math.toRadians(location1.getX());
        double longitude1 = Math.toRadians(location1.getY());
        double latitude2 = Math.toRadians(location2.getX());
        double longitude2 = Math.toRadians(location2.getY());

        double dlat = latitude2 - latitude1;    // 두 지점의 위도 차이
        double dlon = longitude2 - longitude1;  // 두 지점의 경도 차이

        // 하버사인 공식의 중간 계산용 값
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2)
                + Math.cos(latitude1) * Math.cos(latitude2)
                * Math.sin(dlon / 2) * Math.sin(dlon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c * 1000; // 거리 (단위: m)
    }

    // 놀이기구 배열의 거리 행렬 계산
    public static double[][] calculateGeographicalDistances(Ride[] rides) {
        int n = rides.length;
        double[][] distances = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    distances[i][j] = 0; // 같은 놀이기구끼리는 거리 0
                } else {
                    distances[i][j] = rides[i].calculateDistanceBetweenRides(rides[j]);
                }
            }
        }

        return distances;
    }
}


