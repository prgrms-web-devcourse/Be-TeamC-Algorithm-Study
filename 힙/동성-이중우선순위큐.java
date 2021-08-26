package com.algo.programmers.heap;
import java.util.*;
public class Level3_doublePriorityQueue {
    public static void main(String[] args) {
        Solution3 s3=new Solution3();
        String []oper={"I 16","D 1"};
        String []oper2={"I 7","I 5","I -5","D -1"};
        s3.solution(oper);
        s3.solution(oper2);
    }

}


class Solution3 {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer>maxPriority=new PriorityQueue<>();
        PriorityQueue<Integer>minPriority=new PriorityQueue<>(Collections.reverseOrder());

        for (String s:operations) {
            if (s.contains("I")) {
                int val=0;
                String []ss=s.split(" ");
                val=Integer.parseInt(ss[1]);
                maxPriority.add(val);
                minPriority.add(val);

            }
            else {
                int val=0;
                String []ss=s.split(" ");
                val=Integer.parseInt(ss[1]);
                // 최솟값 삭제
                if (val<0) {
                    if (!minPriority.isEmpty()) {
                        int temp=maxPriority.poll();
                        minPriority.remove(temp);
                    }

                } // 최댓값 삭제
                else {
                    if (!maxPriority.isEmpty()) {
                        int temp= minPriority.poll();
                        maxPriority.remove(temp);
                    }
                }
            }
        }

        // 최대값, 최솟값

        int[] answer = new int[2];

        int maxValue=0;
        if (!minPriority.isEmpty()) {
            maxValue=minPriority.poll();
        }

        answer[0]=maxValue;

        int minValue=0;
        if (!maxPriority.isEmpty()) {
            minValue=maxPriority.poll();

        }
        answer[1]=minValue;

        return answer;
    }
}