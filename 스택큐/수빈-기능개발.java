import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            queue.add((int)(Math.ceil((100 - progresses[i]) / (double)speeds[i])));
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && num>=queue.peek()) {
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }
    
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
