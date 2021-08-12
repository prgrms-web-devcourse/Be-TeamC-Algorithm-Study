import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        return map.values()
            .stream()
            .mapToInt(i -> i + 1)
            .reduce(1, (a, b) -> a * b) - 1;
    }
}
