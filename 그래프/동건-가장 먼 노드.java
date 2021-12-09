import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        // check용
        boolean[] check = new boolean[n];
        
        // 첫번째 true로 초기화 진행
        check[0] = true;

        // graph
        boolean[][] graph = new boolean[n][n];

        // graph 연결 상태 init
        for (int[] node : edge) {
            graph[node[0] - 1][node[1] - 1] = true;
            graph[node[1] - 1][node[0] - 1] = true;
        }

        // queue 생성 - 하나씩 빼서 비교 진행
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int temp = queue.size();
            for (int i = 0; i < temp; i++) {
                int node = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (graph[j][node] && !check[j]) {
                        check[j] = true;
                        queue.add(j);
                    }
                }
            }
            answer = temp;
        }
        return answer;
    }
}
