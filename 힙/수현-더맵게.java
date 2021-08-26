
/*
* 우선순위 큐(스코빌 지수가 낮은게 앞)에서 두 개를 뽑아서 계산 후 담는다.
* 계산할 때마다 카운트를 늘린다.
* 계산값이 K를 넘으면 반환
* */

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }

        if (pq.peek() >= K) {
            return 0;
        }

        int mixedScovile = 0;
        while (pq.peek() < K) {
            if (pq.size() <= 1) {
                answer = -1;
                break;
            }
            mixedScovile = mix(pq);
            pq.add(mixedScovile);
            answer++;
        }
        return answer;
    }

    private int mix(PriorityQueue<Integer> pq) {
        int result = 0;
        if (pq.size() >= 2) {
            int t1 = pq.poll();
            int t2 = pq.poll();
            result = t1 + (t2 * 2);
        }
        return result;
    }
}
