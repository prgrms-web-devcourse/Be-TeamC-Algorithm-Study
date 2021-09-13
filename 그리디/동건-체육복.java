import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
	Arrays.fill(student, 1);
        Arrays.sort(lost);

		for (int i = 0; i < reserve.length; i++) {
			student[(reserve[i] - 1)]++;
		}

		for (int i = 0; i < lost.length; i++) {
			student[lost[i] - 1]--;
		}

		for (int i = 0; i < lost.length; i++) {
			if (lost[i] - 1 == 0 && student[0] == 0) {
				if (student[1] == 2) {
					student[0] = 1;
					student[1] = 1;
				}
			} else if (lost[i] == n && student[n - 1] == 0) {
				if (student[n - 1] == 2) {
					student[n - 1] = 1;
					student[n - 2] = 1;
				}
			} else if (student[lost[i] - 1] == 0) {
				if (student[lost[i] - 2] == 2) {
					student[lost[i] - 2] = 1;
					student[lost[i] - 1] = 1;
				} else if (student[lost[i]] == 2) {
					student[lost[i] - 1] = 1;
					student[lost[i]] = 1;
				}
			}
		}

		int result = 0;
		for (int i : student) {
			if (i >= 1) {
				result = result + 1;
			}
		}
        
        return result;
    }
}
