package com.algo.programmers.stack_queue;
import java.lang.reflect.Array;
import java.util.*;
public class Level2_printer {

// 이 문제의 핵심은 자바는 파이썬과 다르게 queue를 for문으로 접근할때 인덱스 접근이 안된다.
    // 따라서 for each를 이용해서 접근해야 함

// 또한 파이썬은 for else라는 구문이 있어 for문에 안 돌 경우 each문으로 나오지만 자바는 이 기능이 없다
    // 따라서 flag를 걸어 문제를 해결 해야 함.
    public static void main(String[] args) {
        Solution2 s2=new Solution2();
        int []pri={2, 1, 3, 2};
        int loc=2;
        int []pri2={1, 1, 9, 1, 1, 1};
        int loc2=0;

//        s2.solution(pri,loc);

        s2.solution(pri2,loc2);


    }

}

class Solution2 {
    public int solution(int[] priorities, int location) {


        Queue<ArrayList> queue=new LinkedList<>();

        for (int i=0;i< priorities.length;i++) {
            ArrayList<Integer>temp=new ArrayList<>();
            temp.add(i);
            temp.add(priorities[i]);
            queue.offer(temp);

        }


        int ans=0;

        while (!queue.isEmpty()) {
            ArrayList al=new ArrayList();
            al=queue.poll();
            ans+=1;
            int idx=(int)al.get(0);
            int val=(int)al.get(1);

            boolean flag=true;

            for (ArrayList<Integer> a:queue) {
                int val2=a.get(1);
                if (val<val2) {

                    queue.add(al);
                    ans-=1;

                    flag=false;
                    break;
                }
            }

            //True일때만 출력
            if (flag==true) {
                if (idx==location) {
                    System.out.println(ans);
                    break;
                }
            }

        }

        return ans;
    }
}
