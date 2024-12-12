import AmusementPark.Everland;
import AmusementPark.LotteWorld;
import RIDE.Everland_Rides.EverlandRide;
import RIDE.Everland_Rides.Ever_AmazonExpress;
import RIDE.Everland_Rides.Ever_BoxOffice;
import RIDE.Everland_Rides.Ever_ColumbusAdventure;
import RIDE.Everland_Rides.EverlandRide;
import RIDE.Ride;

import java.awt.geom.Point2D;


public class App {
    public static void main(String[] args) throws Exception {

        // Ride 객체 배열 생성
        Ride[] everlandRides = {
            new Ever_AmazonExpress(),
            new Ever_BoxOffice(),
            new Ever_ColumbusAdventure()
        };


        // 모든 놀이기구 간 거리 계산
        EverlandRide.allDistances(everlandRides);
        System.out.println("에버랜드 놀이기구 거리 2차원 배열:");

        // 놀이기구 2차원 배열로 거리 출력
        for (int i = 0; i < EverlandRide.distance.length; i++) {
            for (int j = 0; j < EverlandRide.distance[i].length; j++) {
                System.out.printf("%.2f ", EverlandRide.distance[i][j]);
            }
            System.out.println();
        }


        // 두 놀이기구 사이 거리 반환
        // 예제 코드1  (배열 요소 사이 거리 게산)
        System.out.println("\n\n두 놀이기구 사이 거리 반환");
        System.out.println("예제 코드 1 : 배열 요소 사이 거리 게산");
        double result = everlandRides[0].calculateDistanceBetweenRides(everlandRides[1]);
        System.out.println(result);
        System.out.println();

        // 예제 코드2 (놀이기구 인스턴스 사이 거리 계산)
        System.out.println("예제 코드 2 : 놀이기구 인스턴스 사이 거리 계산");
        result = new Ever_AmazonExpress().calculateDistanceBetweenRides(new Ever_ColumbusAdventure());
        System.out.println(result);
    }
}
