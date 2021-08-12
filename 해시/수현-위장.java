/*
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * 각 신체부위를 Key, 의상 수를 value로 하는 맵 생성 --> 경우의 수 계산
 *
 * 신체부위
 * (옷가지 수 + 1)
 * 최소 하나의 옷은 입으므로 아무것도 안입는 케이스 제외
 *
 * */

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String bodyPart = clothes[i][1];
            map.put(bodyPart, map.getOrDefault(bodyPart, 0) + 1);
        }

        for (var bodyPart : map.keySet()) {
            answer *= (map.get(bodyPart) + 1);
        }
        answer -= 1;

        return answer;
    }
}
