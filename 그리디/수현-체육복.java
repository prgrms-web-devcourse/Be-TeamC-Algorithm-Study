import java.util.Arrays;


/*
* https://programmers.co.kr/learn/courses/30/lessons/42862
* */
public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여분이 있는 애들이 도둑맞을 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }

        for (int i : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == i - 1 || reserve[j] == i + 1) {
                    reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }

        return n - lost.length + count;
    }

}
