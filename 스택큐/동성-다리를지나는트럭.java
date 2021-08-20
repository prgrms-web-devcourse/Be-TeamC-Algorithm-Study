package com.algo.programmers.stack_queue;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// startBridge : queue
// doingBridge : queue -> [인덱스 번호, 무게] [0,7] [1,7] [2....] [3,7] ==> ArrayList로 변경(인덱스 때문에)
            // 인덱스 번호는 다리의 길이를 의미
            // 시간이 지나갈때마다 1씩 증가
            // 다리의 길이가 되면 endBridge로 넘기기


public class Level2_truck {
    public static void main(String[] args) {
        Solution3 s3=new Solution3();
        int[] arr={7,4,5,6};

        s3.solution(2,10,arr);

        int [] arr1={10};
        s3.solution(100,100,arr1);

        int [] arr2={10,10,10,10,10,10,10,10,10,10};
        s3.solution(100,100,arr2);


    }
}

class Solution3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;
        Queue<Integer> beginQueue=new LinkedList<>();
        for (int i=0;i<truck_weights.length;i++) {
            beginQueue.add(truck_weights[i]);
        }

        ArrayList<Info>doingStack=new ArrayList<Info>();
        Info info=new Info();

        // 초기값을 넣어줌
        // 만약 리스트가 비어있으면 (초기 값을 넣어줌)
        if (doingStack.isEmpty()) {
            int data=beginQueue.poll();
            info=new Info();
            info.setIdx(1);
            info.setValue(data);
            doingStack.add(info);
        }
        time+=1;

        int count=0;

        // 1. 시작되는 queue가 비워질때까지 반복
        while (!beginQueue.isEmpty()) {
            time+=1;

            // 기존 값 갱신
            for (int i=0;i<doingStack.size();i++) {
                int new_idx=doingStack.get(i).getIdx()+1;
                int val=doingStack.get(i).getValue();
                info=new Info();
                info.setIdx(new_idx);
                info.setValue(val);
                doingStack.set(i,info);
            }

            // 만약 첫번째 트럭이 다리 길이를 초과한다면 doingStack에서 첫번쨰꺼 제거
            if (doingStack.get(0).getIdx()>bridge_length) {
                doingStack.remove(0);
            }


            // 만약 다리에 사이즈가 다리 길이보다 적고, 전체 무게가 버티면 넣어줌
            if (doingStack.size()<=bridge_length) {
                //새로 들어올 데이터
                int data=beginQueue.peek();
                // 전체 무게
                int total=data;
                for (Info val:doingStack) {
                    total+=val.getValue();
                }

                // weight보다 적다면 빼주고, 스택에 1개를 쌓는다.
                if (total<=weight) {
                    beginQueue.poll();
                    info=new Info();
                    info.setIdx(1);
                    info.setValue(data);
                    doingStack.add(info);
                }

            }
        }

        // 만약 doingStack에 남아있으면
        while (!doingStack.isEmpty()) {
            time+=1;

            // 기존 값들을 한칸씩 이동해주고
            for (int i=0;i<doingStack.size();i++) {
                doingStack.get(i).setIdx(doingStack.get(i).getIdx()+1);
            }

            // 첫번째 값이 다리 길이를 초과한다면 빼준다.
            if (doingStack.get(0).getIdx()>bridge_length) {
                doingStack.remove(0);
            }
        }
        System.out.println(time);
        return time;
    }
}

class Info{
    private int idx;
    private int value;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}