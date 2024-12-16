import AmusementPark.Everland;
import AmusementPark.LotteWorld;
import Path.Service;
import RIDE.Everland_Rides.*;
import RIDE.Ride;
import Path.Path;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        LotteWorld lotteworld = new LotteWorld();
        Everland everland = new Everland();

        List<Ride> everlandRides = everland.getEverlandRides();
        List<Ride> lotteWorldRides = lotteworld.getLotteWorldRides();




        // 특정 타입에 해당하는 놀이기구 리스트 가져오기
        List<String> types = List.of("family");

        List<Ride> filteredRides = Ride.getRidesByType(everlandRides, types);

        for (Ride ride : filteredRides) {
            System.out.println(ride.getRideName() + " (" + ride.getRideType() + ")");
        }
        System.out.println();

        Ride tExpress = new Ever_TExpress();



        // 서비스 객체 생성
        Service service = new Service(tExpress, everland.everlandRides);
        service.optimalPath();  // 최단 경로 구하는 과정 출력
        Path path = service.getMinPath();

        // 최단 경로 출력
        System.out.print("\n\n최단 경로 : ");
        for(int i = 0; i < path.getPathList().size(); i++){
            System.out.print(path.getPathList().get(i).getRideName());
            if (i < path.getPathList().size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println("\n최소 가중치 : " + path.getWeight());





        /*
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
         */
    }
}
