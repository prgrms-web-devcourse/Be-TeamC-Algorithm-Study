import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
		Queue<Print> queue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			queue.offer(new Print(priorities[i], i));
		}

		int answer = 0;
		while (!queue.isEmpty()) {
			boolean check = false;
			int currentPrint = queue.peek().getPriority();

			for (Print print : queue) {
				if (currentPrint < print.getPriority()) {
					check = true;
                    break;
				}
			}

			if (check) {
				queue.offer(queue.poll());
			} else {
				if (queue.poll().getLocation() == location) {
					answer = priorities.length - queue.size();
				}
			}

		}

		return answer;
	}

	class Print {
		private int priority;
		private int location;

		public Print(int priority, int location) {
			this.priority = priority;
			this.location = location;
		}

		public int getPriority() {
			return priority;
		}

		public int getLocation() {
			return location;
		}

	}
}
