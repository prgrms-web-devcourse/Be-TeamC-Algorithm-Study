import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int p : priorities) {
            queue.add(p);
        }
        
        while(!queue.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == (int)queue.peek()) {
                    if(i == location) return answer;
                    queue.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}
