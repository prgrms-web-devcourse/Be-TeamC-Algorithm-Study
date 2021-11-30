import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int answer = 0;
        long left = 1;
        long right = distance;
         
        while(left<=right) {
            long mid = (left+right)/2;
            long prev=0, cnt=0;
            
            for(int rock:rocks) {
                if(rock-prev < mid) {
                    cnt++;
                    continue;
                }
                prev = rock;
            }
            
            if(distance-prev < mid) cnt++;
            
            if(cnt<=n){
                left = mid+1;
                answer = (int)mid;
            } else {
                right = mid-1;
            }
        }
        return answer;
    }
}
