import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    class Node{
        private int index;
        private List<Node> adj;

        public Node(int index) {
            this.index = index;
            this.adj = new ArrayList<>();
        }

        public void addAdj(Node node){
            adj.add(node);
        }

        public int getIndex() {
            return index;
        }

        public List<Node> getAdj() {
            return adj;
        }
    }

    public int solution(int n, int[][] edge) {
        Node[] graph = new Node[n+1];
        int[] depth = new int[n+1];

        for(int nodeIdx = 0; nodeIdx < n + 1; nodeIdx++){
            graph[nodeIdx] = new Node(nodeIdx);
            depth[nodeIdx] = -1;
        }

        for(int[] e : edge){
            graph[e[0]].addAdj(graph[e[1]]);
            graph[e[1]].addAdj(graph[e[0]]);
        }

        depth[1] = 0;
        dfs(1, graph, depth);

        return getCountOfMaxLength(depth);
    }

    private void dfs(int currentNodeIdx, Node[] graph, int[] depth){
        for(Node node : graph[currentNodeIdx].getAdj()){
            if(depth[node.getIndex()] == -1 || depth[node.getIndex()] > depth[currentNodeIdx] + 1){
                depth[node.getIndex()] = depth[currentNodeIdx] + 1;
                dfs(node.getIndex(), graph, depth);
            }
        }
    }
    
    private int getCountOfMaxLength(int[] depth){
        Arrays.sort(depth);
        int maxLength = depth[depth.length-1];

        int count = 0;
        for(int i = depth.length-1; i >=0; i--){
            if(depth[i] == maxLength) count++;
            else break;
        }

        return count;
    }
}
