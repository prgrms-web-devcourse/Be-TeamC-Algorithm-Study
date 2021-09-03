import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        
        int cnt = 0;
        for(int n : arr) {
            if(n <= cnt) return cnt;
            cnt++;
        }
        
        return cnt;
    }
}
