/*

https://programmers.co.kr/learn/courses/30/lessons/42583

Solution
지나간 트럭, 다리위의 트럭, 다리위의 무게, 총시간을 변수로 가지도록하고
ArrayList를 사용하여서 다리위에 올라간 트럭의 각각의 시간을 저장한다.

*/


import java.util.*;

class Solution1 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int passTruck = 0;
        int truck = truck_weights.length;
        int totalWeight = 0;
        int onBridge = 0;
        ArrayList<Integer> truckTimes = new ArrayList<>();
        while(true){

            // 총 시간 증가
            answer++;

            // 지나간 트럭이 총 트럭의 수와 같다면 탈출
            if (passTruck == truck)
                break;

            // 트럭이 다리위에 더 올라갈 수 있는 지 확인
            if(passTruck + onBridge < truck) 
                if(totalWeight + truck_weights[passTruck + onBridge] <= weight){
                    totalWeight += truck_weights[passTruck + onBridge];
                    truckTimes.add(0);
                    onBridge++;
                }

            // 다리 위에 올라간 트럭의 시간 증가(위치 증가)
            for (int i = 0; i < truckTimes.size(); i++){
                truckTimes.set(i, truckTimes.get(i) + 1);
            }
            
            // 맨 앞에 있는 트럭이 다리의 길이만큼 이동하였는지 체크하고 동작
            if (truckTimes.get(0) == bridge_length){
                totalWeight -= truck_weights[passTruck];
                truckTimes.remove(0);
                passTruck++;
                onBridge--;
            }
        }
        // 다리위가 완전히 비어 있는 것을 체크하는 것도 시간으로 측정되어서
        return answer;
    }
}