class Solution {
    private int minCnt;
    private String[] words;
    private String target;

    public int solution(String begin, String target, String[] words) {
        boolean[][] graph = new boolean[words.length][words.length];
        int startWordIdx = -1;
        boolean isTargetContained = false;

        this.minCnt = Integer.MAX_VALUE;
        this.words = words;
        this.target = target;

        for(int i = 0; i < words.length ; i++){
            if(canMove(begin, words[i])){
                startWordIdx = i;
            }

            if(words[i].equals(target)){
                isTargetContained = true;
            }

            for(int j = 0; j<words.length; j++){
                if(i != j && canMove(words[i], words[j])){
                    graph[i][j] = true;
                }
            }
        }

        if(startWordIdx == -1 || isTargetContained == false){
            return 0;
        }

        boolean[] isVisited = new boolean[words.length];
        isVisited[startWordIdx] = true;

        dfs(graph, isVisited, startWordIdx, 1);

        return minCnt;
    }

    private boolean canMove(String prevWord, String nextWord){
        int diff = 0;

        for(int i=0;i<prevWord.length();i++){
            if(prevWord.charAt(i) != nextWord.charAt(i)){
                diff++;
            }
        }

        return diff == 1;
    }

    private void dfs(boolean[][] graph, boolean[] isVisited, int currentIdx, int cnt){
        if(words[currentIdx].equals(target)){
            minCnt = Math.min(cnt, minCnt);
            return;
        }

        for(int i=0;i<graph[currentIdx].length;i++){
            if(graph[currentIdx][i] && !isVisited[i]){
                isVisited[i] = true;
                dfs(graph, isVisited, i, cnt + 1);
                isVisited[i] = false;
            }
        }
    }
}
