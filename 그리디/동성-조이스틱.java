package com.algo.programmers.greedy;
// 문제 해결방법
// 좌 -> 우
// 위, 아래로 갈지 정한다
    // 처음 시작은 다 A
    // 연속된 A가 나올경우 값을 구한다
    // 값을 갱신한다.


public class Level2_JoyStick {

    public static void main(String[] args) {
        Solution2 s2=new Solution2();
        s2.solution("JEROEN");
        s2.solution("JAN");
    }
}


class Solution2 {
    public int solution(String name) {

        int answer = 0;

        // 좌 -> 우 : 평범하게 오른쪽으로 이동할때
        int min=name.length()-1;

        for (int i=0;i<name.length();i++) {
            // 상 하 이동
            char c=name.charAt(i);
            // C 68, A 65 = 3
            // Z 120 C 68 = 120 - 68 +1 (Z로한칸 이동한것)
            int upDownMove=Math.min(c-'A','Z'-c+1);
//            System.out.println(upDownMove);
            answer+=upDownMove;


            // 다음 수가 A가 나오는 경우를 계산
            int next=i+1;
            // 연속된 A가 나오는 경우 계산
            while (next<name.length() && name.charAt(next)=='A') {
                next+=1;
            }
            // min 값 갱신
            min=Math.min(min,i+i+name.length()-next);
        }

        answer+=min;
        System.out.println(answer);

        return answer;
    }
}