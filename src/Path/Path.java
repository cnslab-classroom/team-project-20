package Path;

import RIDE.Ride;
import java.util.ArrayList;

public class Path implements Comparable<Path> {
    // 경로 가중치
    private double weight;
    // 놀이기구 경로
    private ArrayList<Ride> pathList;

    public Path(double w){
        weight = w;
    }

    public Path(Ride startRide){
        weight = 0;
        pathList = new ArrayList<>();
        pathList.add(startRide);
    }

    public Path(Path path){
        this.weight = path.weight;
        this.pathList = new ArrayList<>(path.pathList);
    }

    // 놀이기구 경로 추가
    public void addRide(Ride ride){
        // 마지막 방문 놀이기구
        Ride lastRide = pathList.get(pathList.size() - 1);
        // 경로 추가
        pathList.add(ride);
        
        // 놀이기구 간 거리 계산
        double distance = lastRide.calculateDistanceBetweenRides(ride);
     
        // 거리 -> 시간 변환 (100m당 1.2분)
        weight += (distance / 100.0) * 1.5;
    }


    public double getWeight(){
        return weight;
    }

    public ArrayList<Ride> getPathList(){
        return pathList;
    }

    public boolean visitedRide(Ride ride){
        return pathList.contains(ride);
    }

    public int pathSize(){
        return pathList.size();
    }

    @Override
    public int compareTo(Path path){
        if(this.weight == path.getWeight()){
            return 0;
        }
        else if(this.weight > path.weight){
            return 1;
        }else{
            return -1;
        }
    }
}
