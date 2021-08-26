import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i : scoville) {
			priorityQueue.offer(i);
		}

		while (priorityQueue.peek() <= K) {
			if (priorityQueue.size() == 1) {
				return -1;
			}
			priorityQueue.offer(priorityQueue.poll() + priorityQueue.poll() * 2);
			answer++;
		}
        
        return answer;
    }
}
