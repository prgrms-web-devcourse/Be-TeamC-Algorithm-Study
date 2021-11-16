class Solution {
    public int solution(int n, int[][] computers) {
        int networkCnt = 0;
        boolean[] isVisited = new boolean[computers.length];

        for(int i=0;i<computers.length;i++){
            if(!isVisited[i]){
                networkCnt++;
                visit(i, computers, isVisited);
            }
        }

        return networkCnt;
    }

    public void visit(int i, int[][] computers, boolean[] isVisited){
        isVisited[i] = true;

        for(int j=0; j<computers.length; j++){
            if(computers[i][j] == 1 && !isVisited[j]){
                visit(j, computers, isVisited);
            }
        }
    }
}
