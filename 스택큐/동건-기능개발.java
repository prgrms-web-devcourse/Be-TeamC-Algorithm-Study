import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
            int status = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
			queue.add(status);
		}

		List<Integer> data = new ArrayList<>();

		while (queue.size() != 0) {
			int tmp = queue.remove();

			int check = 1;
			while (queue.size() != 0) {
				if (tmp >= queue.peek()) {
					check++;
					queue.remove();
				} else {
					break;
				}
			}

			data.add(check);
		}

        return data.stream().mapToInt(Integer::intValue).toArray();
    }
}
