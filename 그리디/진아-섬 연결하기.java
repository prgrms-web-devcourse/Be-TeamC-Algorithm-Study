import java.util.*;

public class Solution {

    class Node{
        List<List<Integer>> adj = new ArrayList<>();

        void addAdj(int edgeTo, int cost){
            List<Integer> edge = new ArrayList<>();
            edge.add(edgeTo);
            edge.add(cost);

            adj.add(edge);
        }

        List<List<Integer>> getAdj(){
            return adj;
        }

        void sortAdj(){
            Collections.sort(adj, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(1) - o2.get(1);
                }
            });
        }
    }

    public int solution(int n, int[][] costs){
        Node[] graph = getGraph(n, costs);
        boolean[] visited = new boolean[n];
        List<Integer> visitedIsland = new ArrayList<>();
        int sum = 0;

        visited[0] = true;
        visitedIsland.add(0);

        while(visitedIsland.size() < n){
            int minCost = Integer.MAX_VALUE;
            int minEdgeTo = 0;

            for(int v : visitedIsland){
                for(List<Integer> edge : graph[v].getAdj()){
                    int w = edge.get(0);
                    int c = edge.get(1);

                    if(visited[w] == true)
                        continue;

                    if(c < minCost){
                        minCost = c;
                        minEdgeTo = w;
                    }
                }
            }

            sum += minCost;
            visited[minEdgeTo] = true;
            visitedIsland.add(minEdgeTo);
        }

        return sum;

    }
    
    private Node[] getGraph(int n, int[][] costs){
        Node[] graph = new Node[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new Node();
        }

        for(int[] cost : costs){
            int v = cost[0];
            int w = cost[1];
            int c = cost[2];

            graph[v].addAdj(w, c);
            graph[w].addAdj(v, c);
        }

        for(int i=0;i<n;i++){
            graph[i].sortAdj();
        }
        
        return graph;
    }
}
