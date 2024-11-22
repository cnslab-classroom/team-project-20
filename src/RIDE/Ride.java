package RIDE;

import AmusementPark.AmusementPark;

import java.awt.geom.Point2D;


public abstract class Ride {

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
                + " | wait time: " + wait_time + " | location: " + location );
    }


    // getter
    public String getRideName(){
        return rideName;
    };

    public String getRideType(){
        return rideType;
    };

    public int getWaitTime(){
        return wait_time;
    };

    public Point2D.Double getLocation(){
        return location;
    };

    
    
    // setter
    public void setWaitTime(int wait_time) {

        this.wait_time = wait_time;

    }

    // 두 놀이기구 사이의 거리 계산(하버사인 공식 이용)
    public double[][] calculateGeographicalDistances(Ride[] rides) {

        
        int n = rides.length;
        double[][] distances = new double[n][n];

        int EARTH_RADIUS = 6371; // 지구 반지름 (단위: km)

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (i == j) {

                    distances[i][j] = 0; // 같은 놀이기구끼리는 거리 0

                } 
                
                else {

                    // 각 놀이기구의 위치 정보
                    Point2D.Double location1 = rides[i].location;
                    Point2D.Double location2 = rides[j].location;

                    // 각 놀이기구의 위도, 경도 값을 라디안 단위로 변환(Math 인터페이스 이용)
                    double latitude1 = Math.toRadians(location1.getX());
                    double longitude1 = Math.toRadians(location1.getY());
                    double latitude2 = Math.toRadians(location2.getX());
                    double longitude2 = Math.toRadians(location2.getY());


                    double dlat = latitude2 - latitude1;    // 두 지점의 위도 차이
                    double dlon = longitude2 - longitude1;  // 두 지점의 경도 차이

                    // 하버사인 공식의 중간 계산용 값
                    double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) // 위도 차이 계산
                                 + Math.cos(latitude1) * Math.cos(latitude2) // 위도에 따른 보정
                                 * Math.sin(dlon / 2) * Math.sin(dlon / 2); // 경도 차이 계산

                    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); // 두 점 사이의 대원 거리(단위 : 라디안)

                    distances[i][j] = EARTH_RADIUS * c * 1000; // 거리 (단위: m)
                }
            }
        }

        return distances;
    }


}

