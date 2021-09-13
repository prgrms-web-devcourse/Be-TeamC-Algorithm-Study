/*
 * 그냥 완전탐색으로 풀었는데 테케 통과함. 스택/큐로 어떻게 푸는지 다시 고민할 필요 있음
 */

class Solution {
        public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                answer[i] += 1;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}
