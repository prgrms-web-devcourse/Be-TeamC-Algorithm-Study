/*
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * solution1
 * 같은 종류의 옷은 같이 입지 못 하는 것에 주목
 * hash로 같은 종류의 옷 갯수를 체크, 가지고 있는 종류를 알기 위해서 List에 추가하여 저장
 * 각각의 옷은 입거나 안 입을 수 있기 때문에 1가지 경우수를 더 추가해서 곱으로 경우의 수 계산
 * 다 안입는 경우는 없기 때문에 -1
 *
 * */

import java.util.*;


class Solution {

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<String> type = new ArrayList<String>();
        for(int i = 0; i < clothes.length; i++){
            if(hm.containsKey(clothes[i][1]))
                hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
            else {
                hm.put(clothes[i][1], 1);
                type.add(clothes[i][1]);
            }
        }

        for(int i = 0; i < type.size(); i++){
            answer *= (hm.get(type.get(i)) + 1);
        }

        return answer - 1;
    }
}
