package Path;

import RIDE.Ride;
import java.util.*;

public class Service {
    // 방문할 놀이기구 List
    private ArrayList<Ride> rideList;
    private Path minPath;
    private PriorityQueue<Path> pq;

    public Service(Ride startRide, ArrayList<Ride> rideList){
        this.rideList = rideList;
        // 초기 최댓값
        minPath = new Path(100000);

        // 시작 경로
        pq = new PriorityQueue<>();
        Path path = new Path(startRide);
        pq.add(path);
    }

    // 다음 경로 탐색
    void nextRide(Path path){
        for(int i = 0; i < rideList.size(); i++){
            // 다음 방문할 놀이기구
            Ride nextRide = rideList.get(i);
            if(!path.visitedRide(nextRide)){
                // 경로 복사
                Path nextPath = new Path(path);
                // 경로 추가
                nextPath.addRide(nextRide);

                if(minPath(nextPath)){
                    pq.add(nextPath);
                }
            }
        }
    }

    // 최단 경로 확인
    boolean minPath(Path path){
        if(path.getWeight() < minPath.getWeight()){
            if(path.pathSize() == rideList.size()){
                minPath = new Path(path);
            }
           return true;
        }
        else
            return false;
    }

    public void optimalPath(){
        while(!pq.isEmpty()){
            Path path = pq.poll();
            // 경로 출력
            System.out.print("경로 : ");
            for(int i = 0; i < path.getPathList().size(); i++){
                System.out.print(path.getPathList().get(i).getRideName());
                if (i < path.getPathList().size() - 1) {
                    System.out.print(" -> ");
                }  
            }

            // 해당 경로의 가중치 출력
            System.out.println("\n가중치 : " + path.getWeight() + "\n");
            nextRide(path);
        }
    }

    public Path getMinPath(){
        return minPath;
    }
}
