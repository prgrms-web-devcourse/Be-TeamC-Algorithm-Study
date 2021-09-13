import java.util.Arrays;

/*
* https://programmers.co.kr/learn/courses/30/lessons/42748
* subArray = Arrays.copyOfRange(arr, start, end);
* */
public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int[] command = commands[i];
            int start = command[0] -1;
            int end = command[1];
            int k = command[2] - 1;

            int[] subArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArray);
            answer[i] = subArray[k];
        }

        return answer;
    }
}
