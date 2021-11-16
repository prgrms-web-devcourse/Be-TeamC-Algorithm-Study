class Solution {
    public int solution(int n, int[][] computers) {
        int networkCnt = 0;
        boolean[] isVisited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                networkCnt++;
                visit(i, computers, isVisited);
            }
        }

        return networkCnt;
    }

    private void visit(int i, int[][] computers, boolean[] isVisited){
        isVisited[i] = true;

        for(int j=0; j<computers.length; j++){
            if(computers[i][j] == 1 && !isVisited[j]){
                visit(j, computers, isVisited);
            }
        }
    }
}
