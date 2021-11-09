class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // dp 생성
        int[][] dp = new int[n + 1][m + 1];
        
        // dp[0]은 버리는 카드
        
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        // dp초기화
        dp[1][1] = 1;
        
        // 웅덩이 초기화
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 웅덩이면 연산 취소
                if (dp[i][j] == -1) {
                    continue;
                }
                // 위에서 올때
                if (dp[i - 1][j] >= 0) {
                    dp[i][j] += dp[i - 1][j] % 1000000007;
                }
                
                // 왼쪽에서 올때
                if (dp[i][j - 1] >= 0) {
                    dp[i][j] += dp[i][j - 1] % 1000000007;
                }
            }
        }
        
        /*
        0  0  0  0  0
        0  1  1  1  1
        0  1 -1  1  2
        0  1  1  2  4
        */
        
        // 연산할 때랑, 마지막 값은 모두 mod처리 필요!!!
        return dp[n][m] % 1000000007;
    }
}
