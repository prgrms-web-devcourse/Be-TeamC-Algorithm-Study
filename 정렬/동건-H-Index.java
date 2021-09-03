import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
		int answer = 0;
		for (int i = 0; i < citations.length; i++) {
			int tmp = citations.length - i;

			if (citations[i] >= tmp) {
				answer = tmp;
				break;
			}
		}
        return answer;
    }
}
