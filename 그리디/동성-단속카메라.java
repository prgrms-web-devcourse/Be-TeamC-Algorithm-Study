package com.algo.programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Level3_Camera {
    public static void main(String[] args) {

        Solution6 l6=new Solution6();
        int [][]a={{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        l6.solution(a);

    }
}


//      1. 제일 빨리 끝나는 거 이전에 찍으면 됨
//
//      2. 나가는거 기준으로 오름차순
//        (-18,-13) (-14,-5) (-5,-3) (-20,15)
//
//      3. 카메라를 맨 뒤에 두고 입구에 들어오는게 카메라보다 클때 나가는 차량 위치에 카메라 설치

class Solution6 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        // 카메라가 설치될수 있는 제일 처음 값
        int cam=-30007;

        for (int [] route:routes) {
            // 이때부터 카메라 설치를 해야함
            if (cam<route[0]) {
                answer+=1;
                // 카메라 위치를 나가는 위치에 변경
                cam=route[1];
                System.out.println("cam"+cam);
            }
        }

        System.out.println("answer"+answer);

        return answer;
    }
}
