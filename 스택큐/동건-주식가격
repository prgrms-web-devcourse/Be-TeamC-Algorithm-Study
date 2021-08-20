class Solution {
    public int[] solution(int[] prices) {
      int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int count = 0;
			for (int j = i; j < prices.length; j++) {
				if (prices[i] <= prices[j]) {
					answer[i]++;
				} else if (count == 0) {
					answer[i]++;
					break;
				}
			}
			answer[i] -= 1;
		}

		return answer;
    }
}
