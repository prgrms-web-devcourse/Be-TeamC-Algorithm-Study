import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        
        for(int i=0; i<prices.length-1; i++) {
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] > prices[j] || j == prices.length-1) {
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
    }
}
