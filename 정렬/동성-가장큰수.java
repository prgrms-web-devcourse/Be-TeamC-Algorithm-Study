package com.algo.programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Level2_most {

    public static void main(String[] args) {

        int [] array={1, 5, 2, 6, 3, 7, 4};
        int [][]cmd={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution1 s1=new Solution1();
        s1.solution(array,cmd);

    }
}


class Solution1 {
    public int[] solution(int[] array, int[][] commands) {

        int []answer=new int[commands.length];

        for (int i=0;i<commands.length;i++) {
            int start=commands[i][0];
            int end=commands[i][1];
            int find=commands[i][2];


            // Copy Of Range
            int [] temp=Arrays.copyOfRange(array,start-1,end);
            // Sort
            Arrays.sort(temp);
            answer[i]=temp[find-1];

        }

        return answer;
    }
}