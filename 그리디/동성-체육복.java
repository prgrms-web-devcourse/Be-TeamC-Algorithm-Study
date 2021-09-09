package com.algo.programmers.greedy;
import java.util.*;
public class Level1_Cloth {
    // 받는것을 생각해야함

    public static void main(String[] args) {
        Solution1 s1=new Solution1();
//        5	[2, 4]	[1, 3, 5]
        int lost[]={2,4};
        int reverse[]={1,3,5};
        s1.solution(5,lost,reverse);

    }


}


class Solution1 {
    public int solution(int n, int[] lost, int[] reserve) {

        // 전체 1인 배열
        int total[]=new int[n];
        // 전부 1로 채우기
        for (int i=0;i<n;i++) {
            total[i]=1;
        }

        // lost 빼기
        for (int i=0;i< lost.length;i++) {
            int idx=lost[i]-1;
            total[idx]-=1;
        }

        // reverse 더하기
        for (int i=0;i< reserve.length;i++) {
            int idx=reserve[i]-1;
            total[idx]+=1;
        }

        // 첫번째 인덱스는 바로 뒤에서만 얻을 수 있음.
        if (total[0]==0 && total[1]==2) {
            total[0]=1;
            total[1]=1;
        }

        // 2번째 인덱스부터 시작
        for (int i=1;i< total.length-1;i++) {
            // 앞에가 2이면 빌림
            if (total[i-1]==2 && total[i]==0) {
                total[i-1]=1;
                total[i]=1;
            }
            // 뒤에가 2이면 빌림
            if (total[i+1]==2 && total[i]==0) {
                total[i]=1;
                total[i+1]=1;
            }
        }


        int answer = 0;
        for (int i=0;i< total.length;i++) {
            System.out.print(total[i]+" ");
            if (total[i]>=1) {
                answer+=1;
            }
        }

        return answer;
    }
}