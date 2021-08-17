package com.algo.programmers.stack_queue;

// Queue는 2개가 필요
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

// 문제 풀이 방법
// 1. 100에서 pro의 각 부분을 뺀다
//  - [7,70,45]
// 2. spe로 나눈 값을 구한다. 이떄 나머지가 있으면 +1 or Ceil방법을 이용하여 반올림
//  - [7,3,9]

// 3. 큐 자료구조를 이용한다 (핵심은 2개의 큐를 이용한다)
//  - int res=0 변수를 하나 만든다.
//  - 1개씩 빼주면서 (poll) 나머지 큐를 다시 돈다.
//                      - 다음수를 뽑는다. (peek) 이떈 큐에서 삭제하지 않는다.
//                      - 다음수가 자기보다 큰게 있으면 break
//                      - 자기보다 작으면 val+1로 증가하고 사용된 수는 삭제한다. (poll)

public class Level2_functionDev {
    public static void main(String[] args) {
        int []pro={93, 30, 55};
        int []spe={1, 30, 5};
        Solution1 s1=new Solution1();

        int []pro2={95, 90, 99, 99, 80, 99};
        int []spe2={1, 1, 1, 1, 1, 1};

        s1.solution(pro,spe);
        s1.solution(pro2,spe2);

    }

}

class Solution1 {

    public int[] solution(int[] progresses, int[] speeds) {
        // 1.
        for (int i=0;i<progresses.length;i++) {
            progresses[i]=100-progresses[i];
        }

        // 2.
        // 2-2 큐에 담기
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<progresses.length;i++) {
            int k=progresses[i]/speeds[i];
            int mod=progresses[i]%speeds[i];

            // 모듈러로 구하기
            if (mod>0) {
                progresses[i]=k+1;
            }
            else {
                progresses[i]=k;
            }

            // 반올림하는 방법
            // progresses[i] = (int)Math.ceil(k);

            queue.offer(progresses[i]);
        }


        ArrayList<Integer>ans=new ArrayList<>();

        // 3. 큐
        while (!queue.isEmpty()) {
            // 7,3,9

            int data=queue.poll();
            int val=1;

            while(!queue.isEmpty()) {
                int data2=queue.peek();

                if (data>=data2) {
                    val+=1;
                    queue.poll();
                }
                else {
                    break;
                }
            }
            ans.add(val);
        }
        System.out.println(ans.toString());

        // arrayList -> array로 변환
        int[] answer = new int[ans.size()];

        int size=0;
        for (int an:ans) {
            answer[size++]=an;
        }

        // list -> array
//        int[] arr = ans.stream().mapToInt(i -> i).toArray();


        return answer;
    }

}