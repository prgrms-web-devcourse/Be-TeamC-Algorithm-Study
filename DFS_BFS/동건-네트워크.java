class Solution {
    private final static boolean[] check = new boolean[200];

    public int solution(int n, int[][] computers) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, int index) {
        check[index] = true;

        for (int j = 0; j < computers.length; j++) {
            if (!check[j] && computers[index][j] == 1) {
                dfs(computers, j);
            }
        }
    }
}
