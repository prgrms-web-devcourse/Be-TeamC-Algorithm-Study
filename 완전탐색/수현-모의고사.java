/*
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * 무난무난
 */

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        int[] person1 = new int[]{1, 2, 3, 4, 5};
        int[] person2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) {
                count1++;
            }

            if (answers[i] == person1[i % person2.length]) {
                count2++;
            }

            if (answers[i] == person1[i % person3.length]) {
                count3++;
            }
        }

        answer[0] = count1;
        answer[1] = count2;
        answer[2] = count3;

        int max = answer[0];

        ArrayList<Integer> result1 = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            if (max <= answer[i]) {
                max = answer[i];
                result1.add(i+1);
            }
        }

        int[] result2 = new int[result1.size()];

        for (int i = 0; i < result2.length; i++) {
            result2[i] = result1.get(i);
        }

        return result2;
        }
}
