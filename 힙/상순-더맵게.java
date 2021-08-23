/*
https://programmers.co.kr/learn/courses/30/lessons/42626

Solution
우선 순위 큐를 사용하여 작은 순서대로 정보를 가져올 수 있게하여
맨앞의 작은 수가 K보다 작을 때까지 동작 수행을 하도록 함
런타임 오류가 발생할 수 있기 때문에 try문으로 에러 처리
*/

import java.util.*;

class Solution1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i : scoville){
            que.add(i);
        }

        try {
            while (que.peek() < K) {
                answer++;
                int x = que.poll();
                int y = que.poll();
                que.add(x + y * 2);
            }
        }catch (Exception e){
            answer = -1;
        }
        return answer;
    }
}
}