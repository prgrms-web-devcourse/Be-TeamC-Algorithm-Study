class Solution {
    public int solution(int[] money) {
        return Math.max(visitFirstHouse(money), notVisitFirstHouse(money));
    }
    
    private int visitFirstHouse(int[] money){
        int[] dp = new int[money.length];
        
        dp[0] = money[0];
        dp[1] = money[0];
        
        for(int i=2; i<dp.length - 1; i++){
            dp[i] = Math.max(dp[i-2]  + money[i], dp[i-1]);
        }
        
        return dp[dp.length-2];
    }
    
    private int notVisitFirstHouse(int[] money){
        int[] dp = new int[money.length];
        
        dp[0] = 0;
        dp[1] = money[1];
        
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(dp[i-2]  + money[i], dp[i-1]);
        }
        
        return dp[dp.length-1];
    }
}
