package com.algo.programmers.heap;
import java.util.*;
public class Level3_disk_controller {

    public static void main(String[] args) {
        Solution2 s2=new Solution2();
        int [][]jobs={{0, 3}, {1, 9}, {2, 6}};
        s2.solution(jobs);

    }

}


class Solution2 {
    public int solution(int[][] jobs) {

        Info info;

        // 큐에 넣기
//        Queue<Info>queue=new LinkedList<>();
        LinkedList<Info> queue = new LinkedList<>();
        for (int i = 0; i < jobs.length; i++) {
            System.out.println();
            int req = jobs[i][0];
            int end = jobs[i][1];
            System.out.println(req + "," + end);

            info = new Info(req, end);
            queue.offer(info);
        }

        // 넣은 큐를 정렬하기
        Collections.sort(queue, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.req - o2.req;
            }
        });


        // 우선 순위 큐 만들기 - 우선순위큐에 넣을때는 Compare을 이용해 뒤에 인자를 바탕으로 정렬이 되어야 된다.
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.time - o2.time;
            }
        });


        int answer=0;
        int cnt=0;
        int time=queue.peek().req;


        while(cnt< jobs.length) {

            while(!queue.isEmpty() && queue.peek().req<=time) {
                pq.offer(queue.poll());
            }
            if (!pq.isEmpty()) {
                Info temp=pq.poll();
                time+=temp.time;
                answer+=time-temp.req;
                cnt++;
            }
            else {
                time++;
            }
        }

            answer=answer/cnt;
        System.out.println(answer);
            return answer/cnt;
            }
        }



class Info {
    int req;
    int time;

    public Info() {

    }

    public Info(int req, int time) {
        this.req = req;
        this.time = time;
    }
}

