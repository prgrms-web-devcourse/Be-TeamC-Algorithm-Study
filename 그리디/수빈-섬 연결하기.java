import java.util.HashSet;

class Solution {
    HashSet<Integer> island;
    boolean[] check;
    
    public int solution(int n, int[][] costs) {
        check = new boolean[costs.length];
        island = new HashSet<>();
        int answer = 0;
        int idx = 0;
        int min_cost = Integer.MAX_VALUE;
        for (int i=0; i<costs.length; i++) {
            if (costs[i][2] < min_cost){
                min_cost = costs[i][2];
                idx = i;
            }
        }
        answer += connect(costs[idx], idx);

        while(island.size() < n) {
            min_cost = Integer.MAX_VALUE;
            for (int i=0; i<costs.length; i++) {
                if (!check[i]) {
                    if ((!island.contains(costs[i][0]) && island.contains(costs[i][1])) || island.contains(costs[i][0]) && !island.contains(costs[i][1])) {
                        if (costs[i][2] < min_cost) {
                            min_cost = costs[i][2];
                            idx = i;
                        }
                    }
                }
            }
            answer += connect(costs[idx], idx);
        }
        return answer;
    }

    public int connect(int[] cost, int idx) {
        check[idx] = true;
        island.add(cost[0]);
        island.add(cost[1]);
        return cost[2];
    }
}
