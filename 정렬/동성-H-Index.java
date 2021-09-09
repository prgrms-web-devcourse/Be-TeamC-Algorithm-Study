package com.algo.programmers.sort;
import java.util.*;
public class Level2_h_index {
    public static void main(String[] args) {

        Solution3 s3=new Solution3();
        int[]arr={3, 0, 6, 1, 5};
        s3.solution(arr);
    }

}



class Solution3 {
    public int solution(int[] citations) {

        // 내림차순 정렬
        ArrayList arrayList=new ArrayList();
        for (int i:citations) {
            arrayList.add(i);
        }
//        3, 0, 6, 1, 5
//        6 5 3 1 0
        arrayList.sort(Comparator.reverseOrder());
        System.out.println(arrayList.toString());

        int answer = 0;
        for (int i=(int)arrayList.get(0);i>=0;i--) {

            int count=0;
            for (int h=0;h<arrayList.size();h++){
                if ((int)arrayList.get(h)>=i) {
                        count+=1;
                }
            }

            // 나머지 논문이 h번 이하
            int restValue=arrayList.size()-count;
            if (count>=i && restValue<=i) {
                return i;
            }
        }

        return 1;
    }
}