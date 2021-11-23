import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int len = times.length;
        long left = n/len * times[0];
        long right = (long)Math.ceil(n/len) * times[times.length-1];
        
        long answer = 0;
        while (left <= right) {
            long mid = (left+right)/2;
            long cnt = 0;
            for (int i=0; i<len; i++) {
                cnt += mid/times[i];
            }
        
            if(cnt<n) {
                left = mid+1;
            } else {
                right = mid-1;
                answer = mid;
            }
        }
        return answer;
    }
}
