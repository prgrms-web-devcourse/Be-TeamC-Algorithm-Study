package com.algo.programmers.bruteforce;
import java.util.*;
public class Level3_carpet {
    public static void main(String[] args) {
        Solution3 s3=new Solution3();
        s3.solution(14,6);
    }

}


class Solution3 {
    public int[] solution(int brown, int yellow) {

        ArrayList<Integer>arr=new ArrayList<>();
        int val=0;
        int val2=0;

        for (int i=brown;i>0;i--) {
            for (int j=0;j<=brown;j++) {
                if (i>=j && (i+2)*2+(j*2)==brown) {
                    System.out.println("i"+i+"j"+j);

                    int yellow_row=i;
                    int yellow_col=j;

                    if (yellow_row*yellow_col==yellow) {
                        val=yellow_row+2;
                        val2=yellow_col+2;
                        int[] answer = {val,val2};
                        return answer;
                    }
                }
            }

        }

        int[] answer = {val,val2};
        return answer;

    }
}