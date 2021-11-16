class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        
        for(int i=0; i<computers.length; i++){
            if(visited[i]) {
                continue;
            }
            dfs(computers, i);
            answer++;
        }
        return answer;
    }
    public void dfs(int[][] computers, int idx) {
        for(int i=0; i<computers.length; i++) {
            if(i==idx) {
                continue;
            }
            if(computers[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(computers, i);
            }
        }
    }
}
