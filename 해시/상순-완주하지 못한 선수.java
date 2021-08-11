
/*
* https://programmers.co.kr/learn/courses/30/lessons/42576
*
* solution1
* hashmap을 사용하기로 생각하고 구성하였습니다.
* 완주자의 이름과 인원을 각각의 HashMap으로 입력하여 주자 리스트를 하나씩 대입해 완주자 map상에
* 주자가 이름이 존재 여부와 인원 수를 체크하는 방식
*
*
* */

import java.util.*;

class Solution {

    public String solution1(String[] participant, String[] completion) {
        public String solution(String[] participant, String[] completion) {
            Map<String,Integer> player = new HashMap<String,Integer>();
            int complete = completion.length;
            String answer = "";

            //완주자의 이름과 동명이인이 존재하면 수를 늘려서 hashMap에 저장
            for(int i = 0; i < complete; i++)
                if(player.containsKey(completion[i]))
                    player.put(completion[i], player.get(completion[i]) + 1);
                else
                    player.put(completion[i], 1);

            int players = participant.length;
            for(int i = 0; i < players; i++){

                //완주한 플레이어 목록에 있는지 확인 없다면 정답으로 간주
                if(!player.containsKey(participant[i])){
                    answer = participant[i];
                    break;
                }

                //동명 이인일 때 더 이상 완주자가 없다면 정답으로 간주
                if(player.get(participant[i]) == 0){
                    answer = participant[i];
                    break;
                }

                //정답이 아닐 경우 인원 수 줄여주기(플레이어 Check)
                player.put(participant[i], player.get(participant[i]) - 1);
            }
            return answer;
        }
    }

    
}
