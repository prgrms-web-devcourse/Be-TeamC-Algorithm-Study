/*

https://programmers.co.kr/learn/courses/30/lessons/42584

Solution
하나씩 값을 보며 자신의 다음부터 자신보다 작은 값이 나오기 전까지 시간을 1초씩 추가

*/


import java.util.*;

class Solution1 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int index = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}