import java.util.*;
/*
* queue.size가 bridge_length와 같으면 poll, 무게--
* 대기 트럭을 다리 위에 올렸을 때 weight을 넘으면 0을 add, 시간++
* 
* 위의 두 경우가 아닌 경우 트럭을 올림, 무게++ 시간++ 대기트럭 접근하는 idx++
* 마지막 대기 트럭이 올라가면 다리 길이만큼 더해준 값 return
*/
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int total_weight = 0;
        int answer = 0;
        int idx = 0;
        
        while(idx!=truck_weights.length) {
            
            if(queue.size() == bridge_length) {
                total_weight -= queue.poll();                
            }
            
            if(total_weight+truck_weights[idx] > weight) {
                queue.add(0);
                answer++;
                continue;
            } 
            // 트럭을 다리에 올림
            queue.add(truck_weights[idx]);
            total_weight += truck_weights[idx];
            answer++;
            idx++;
        }
    
        return answer + bridge_length;
    }
}
