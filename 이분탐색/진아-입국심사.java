import java.util.*;

public class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = times[0];
        long right = (long)n * times[times.length-1];
        long minTime = 0;

        while(left <= right){
            long mid = (right + left) / 2;

            long visited = 0;
            for(int time : times){
                visited += mid/time;
            }

            if(visited < n){
                left = mid + 1;
            }
            else {
                minTime = mid;
                right = mid - 1;
            }
        }

        return minTime;
    }
}
