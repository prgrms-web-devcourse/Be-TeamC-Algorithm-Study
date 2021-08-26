
/*
* 오름차순 우선순위 큐
* 내림차순 우선순위 큐
*
* 오름차순에 값을 담는다
*
* D 1 일 경우? 오름차순 큐에서 값을 다 빼서 내림차순 큐에 넣는다
* D -1 일 경우? 오름차순 큐에서 값을 뺀다
*
* 시간 복잡도는?? N^2 * logN
*
* */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> ascQueue = new PriorityQueue<>();
        Queue<Integer> descQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String[] tmp = operation.split(" ");
            String op = tmp[0];
            int data = Integer.parseInt(tmp[1]);

            if (op.equals("I")) {
                ascQueue.add(data);
            } else {  // op == D

                if (ascQueue.isEmpty()) {
                    continue;
                }

                if (data == -1) {
                    ascQueue.poll();
                } else {
                    descQueue.clear();
                    descQueue.addAll(ascQueue);

                    descQueue.poll();

                    ascQueue.clear();
                    ascQueue.addAll(descQueue);
                }
            }
        }

        if (ascQueue.isEmpty()) {
            return new int[]{0, 0};
        }

        descQueue.clear();
        descQueue.addAll(ascQueue);

        int min = ascQueue.poll();
        int max = descQueue.poll();

        return new int[]{max, min};
    }
}
