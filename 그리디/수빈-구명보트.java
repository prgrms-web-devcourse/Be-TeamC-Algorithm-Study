import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        
        if(people.length == 1) return 1;
        
        int cnt = 0, idx = 0;
        Arrays.sort(people);
        
        for(int i=1; i<people.length; i++) {
            if(people[0] + people[i] > limit) {
                idx = i-1;
            }
        }
        
        for(int i=0; i<people.length; i++) {
            for(int j=idx; j>i; j--) {
                if(people[i] + people[j] <= limit) {
                    cnt++;
                    idx = j-1;
                    break;
                }
                idx--;
            }
            if(idx <= i) break;
        }
        
        return people.length - cnt;
    }
}
