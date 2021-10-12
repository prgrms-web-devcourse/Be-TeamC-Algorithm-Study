import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 최초 정렬 진행 (제각기 몸무게가 다르니까)
        Arrays.sort(people);
        Deque<Integer> queue = new ArrayDeque<>();

        // 무거운 인원이 Deque의 앞에 가도록!
        // Deque의 앞에다가 데이터를 추가
        for (int i = 0; i < people.length; i++) {
            queue.addFirst(people[i]);
        }

        // 구명보트 개수
        int count = 0;
        
        // deque가 빌때 까지, 모든 인원이 탈출할때까지
        while (!queue.isEmpty()) {
            // 몸무게가 가장 무거운 사람
            int temp = queue.poll();

            // 큐가 빌때까지 돌림
            while (!queue.isEmpty()) {
                // 가장 무거운 사람 + 가장 가벼운 사람 > 구명보트 무게보다 무거우면 strop
                if (temp + queue.peekLast() > limit) {
                    break;
                }
                // 그외에 사람인 경우 poll을 하고 temp에 더해줍니다!!
                temp += queue.pollLast();
            }
            // 구명보트 카운트를 늘립니다!
            count++;
        }
        return count;
    }
}
