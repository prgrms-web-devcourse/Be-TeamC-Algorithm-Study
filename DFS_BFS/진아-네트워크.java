class Solution {
    private boolean[] isVisited;

    public int solution(int n, int[][] computers) {
        int networkCnt = 0;
        this.isVisited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                networkCnt++;
                visit(i, computers);
            }
        }

        return networkCnt;
    }

    public void visit(int i, int[][] computers){
        isVisited[i] = true;

        for(int j=0; j<computers.length; j++){
            if(computers[i][j] == 1 && !isVisited[j]){
                visit(j, computers);
            }
        }
    }
}
