package com.algo.programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Level1_sunsu {
    public static void main(String[] args) {
        Solution1 s=new Solution1();
        String parti[]={"leo", "kiki", "eden"};
        String comple[]={"eden", "kiki"};
        String answer="";
        answer=s.solution1_hash(parti,comple);
        System.out.println(answer);
        answer=s.solution1_sort(parti,comple);
        System.out.println(answer);

    }
}

// HashMap으로 풀기
class Solution1 {
    public String solution1_hash(String[] participant, String[] completion) {

        // 참여한 선수를 HashMap에 넣는다.
        // 예를들어 - ["leo",2], ["kiki",1]
        // 시간복잡도 n

        String answer="";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                int val = map.get(participant[i]);
                map.put(participant[i], val + 1);
            } else {
                map.put(participant[i], 1);
            }
        }

        //
        // 예를들어 - ["leo",1], ["kiki",1]

        // 위에 map에서 완주한 선수를 빼준다.
        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
//                빼준다.
                int temp = map.get(completion[i]) - 1;
                map.put(completion[i], temp);
            } else {
                answer=completion[i];
                break;
            }
        }

        // for문을 다 돌았는데도 완주하지못한 선수가 있다면 출력
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer=key;
            }
        }


        return answer;
    }

    public String solution1_sort(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;

        String answer = "";
        for (i=0;i<participant.length-1;i++) {

            if (!participant[i].equals(completion[i])) {
                answer=participant[i];
                return answer;
            }
        }

        answer=participant[i];
        return answer;

    }



}



