import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int ans = 0;

        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        List<Integer> lostList = new ArrayList<>();

        for (int stu : lost) {
            if (!reserveList.removeIf(i -> i == stu)) {
                lostList.add(stu);
            }
        }
        Collections.sort(lostList);
        
        for (int stu : lostList) {
            if (reserveList.removeIf(i -> i == stu - 1)) continue;
            if (reserveList.removeIf(i -> i == stu + 1)) continue;
            ans++;
        }
        return n - ans;
    }
}
