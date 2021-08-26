import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int ans = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        
        for(int i : scoville) queue.add(i);
        
        while(queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            ans++;
            int s1 = queue.poll();
            int s2 = queue.poll();
            queue.add(s1 + s2*2);
        }
        return ans;
    }
}
