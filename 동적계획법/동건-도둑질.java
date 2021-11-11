class Solution {
    public int solution(int[] money) {
        int n = money.length;

        // 처음 집을 훔침
        int[] dp1 = new int[n];
        // 첫집을 훔치자!
        dp1[0] = money[0];
        // 두번째 집은 보내주자~
        dp1[1] = money[0] + 0;

        // 처음 집이 아니라, 다음 집을 훔침
        int[] dp2 = new int[n];
        // 첫집은 보내주자~
        dp2[0] = 0;
        // 두번째 집을 털자!
        dp2[1] = 0 + money[1];
        
        // 점화식
        // dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);

        for (int i = 2; i < n; i++) {
            // 첫번째 집을 털 경우 둥글게 있는 집 구조상, 마지막 집을 털면 아니됨!
            if (i != n - 1) {
                dp1[i] = Math.max((dp1[i - 2] + money[i]), dp1[i - 1]);
            }
            // 두번째집을 터는 경우는 상관 없음
            dp2[i] = Math.max((dp2[i - 2] + money[i]), dp2[i - 1]);
        }

        // 첫번째 집을 턴 경우 마지막 번호가 아닌 그 전 집이 마지막이됨, 두번째 턴 집은 마지막 집 final임!
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
