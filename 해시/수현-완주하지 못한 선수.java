
/*
* https://programmers.co.kr/learn/courses/30/lessons/42576
* 
* 완주하지 못한 선수는 무조건 한 명이므로 이름 순으로 정렬해서 completion에 포함되어 있지 않으면 답을 리턴
*
* participants = [ a, b, b, c, d]
* completion =   [ a, b, c, d]
*
* participants = [ a, b, c, d]
* completion =   [ a, b, c ]
*
* solution1: 정렬을 한번 하고 배열을 순회하므로 시간 복잡도는 O(NlogN)
* solution2: 해시를 사용한다면, 해시맵에 Map<String, Count> 형태로 담은 후 participant를 담을 때는 카운트를 올리고,
* 다시 completion을 돌면서 카운트를 줄인 뒤, 카운트가 여전히 남아있는 이름을 반환하면 O(N)에 풀이 가능할듯
*
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Solution {

    public String solution1(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }

    public String solution2(String[] participant, String[] completion) {
        Map<String, Integer> counter = new HashMap<>();

        for (var person : participant) {
            counter.put(person, counter.getOrDefault(person, 0) + 1);
        }

        for (var person : completion) {
            counter.put(person, counter.get(person) - 1);
        }

        for (var person : counter.keySet()) {
            if (counter.get(person) > 0) {
                return person;
            }
        }
        return null;
    }
    
}
