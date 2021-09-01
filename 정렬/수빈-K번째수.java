import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> ans = new ArrayList<>();
        
        for(int[] com : commands) {
            int[] arr = Arrays.copyOfRange(array, com[0]-1, com[1]);
            Arrays.sort(arr);
            ans.add(arr[com[2]-1]);
        }
    
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
