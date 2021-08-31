import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
         PriorityQueue<Integer> ascendingQueue = new PriorityQueue<>();
        PriorityQueue<Integer> descendingQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            List<String> temp = Arrays.asList(operation.split(" "));
                      if ("I".equals(temp.get(0))) {
                ascendingQueue.offer(Integer.parseInt(temp.get(1)));
                descendingQueue.offer(Integer.parseInt(temp.get(1)));
                continue;
            }

            if ("1".equals(temp.get(1)) && !ascendingQueue.isEmpty()) {
                int max = descendingQueue.poll();
                ascendingQueue.remove(max);
                continue;
            }

            if ("-1".equals(temp.get(1)) && !ascendingQueue.isEmpty()) {
                int min = ascendingQueue.poll();
                descendingQueue.remove(min);
            }
        }

        int[] result = new int[2];
        if (!ascendingQueue.isEmpty()) {
            result[0] = descendingQueue.peek();
            result[1] = ascendingQueue.peek();
        }
        return result;
    }
}
