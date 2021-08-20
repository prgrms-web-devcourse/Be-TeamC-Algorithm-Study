package com.algo.programmers.stack_queue;
import java.util.*;
public class Level2_StockPrice {
    public static void main(String[] args) {
        int price[]={1, 2, 3, 2, 3};
        Solution4 s4=new Solution4();
        s4.solution(price);

    }

}


class Solution4 {
    public int[] solution(int[] prices) {

        ArrayList<Integer>arr=new ArrayList<>();

        for (int i=0;i< prices.length;i++) {
            int temp=0;

            for (int j=i+1;j< prices.length;j++) {
                if (prices[i]<=prices[j]) {
                    temp+=1;
                }
                else {
                    temp+=1;
                    break;
                }
            }
            arr.add(temp);
        }


        int[] answer = new int[arr.size()];

        for (int i=0;i<arr.size();i++) {
            answer[i]=arr.get(i);
        }

        return answer;
    }
}