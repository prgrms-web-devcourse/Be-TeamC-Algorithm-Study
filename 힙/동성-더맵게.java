package com.algo.programmers.heap;

import java.util.*;
// 우선순위 큐 사용
// 1. 큐에 전부 넣는다.

// 2. 큐가 빌때까지 반복
//  2-1. 가장 작은값을 뽑고 뽑은게 K이상이면 종료 (peek)
//  2-2. 2개를 뽑고 조합 -> 이떄 큐에 없을수 있으므로 조건문을 사용하고 Poll을 사용
//                        큐가 만약 비면 -1을 리턴
//  2-3. 조합한 수를 넣고 answer+1 증가시킨다.

// 3. 출력
//

public class Level2_more {
    public static void main(String[] args) {
        Solution1 s1=new Solution1();
        int []sc={1, 2, 3, 9, 10, 12};
        int ans=s1.solution(sc,7);
        System.out.println(ans);

    }
}


class Solution1 {
    public int solution(int[] scoville, int K) {


        PriorityQueue<Integer> priorityLow=new PriorityQueue<>();
        for (int i:scoville) {
            priorityLow.add(i);
        }


        int answer = 0;

        while (!priorityLow.isEmpty()) {

            // 뽑은게 최소값이면 종료
            int minValue=priorityLow.peek();
            if (minValue>=K) {
                break;
            }

            // 2개를 뽑는다.
            // todo -> try Catch
            int arr[]=new int[2];
            for (int i=0;i<2;i++) {

                // 방법 1. -> try Catch를 사용
                try {
                    arr[i]=priorityLow.poll();
                }
                catch(Exception e) {
                    return -1;
                }
                // 방법 2. -> 큐가 빌떄까지 반복
//                if (!priorityLow.isEmpty()) {
//                    arr[i]=priorityLow.poll();
//                }
//                else {
//                    return -1;
//                }
            }

            int temp=arr[0]+arr[1]*2;

            // 다시 넣는다.
            priorityLow.add(temp);
            answer+=1;
        }

        return answer;
    }
}