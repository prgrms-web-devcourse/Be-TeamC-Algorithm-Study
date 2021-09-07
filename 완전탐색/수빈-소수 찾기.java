import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set;
    boolean[] visited;
    int N;

    public int solution(String numbers) {
        N = numbers.length();
        set = new HashSet<>();
        visited = new boolean[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(numbers.charAt(i));
            visited[i] = true;
            dfs(1, numbers, sb);
            visited[i] = false;
            sb.setLength(sb.length() - 1);
        }

        int answer = 0;
        for(int num : set){
            if(isPrime(num)) answer++;
        }

        return answer;
    }

    public void dfs(int depth, String numbers, StringBuilder sb) {
        set.add(Integer.valueOf(sb.toString()));
        if (depth == N) {
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                sb.append(numbers.charAt(i));
                visited[i] = true;
                dfs(depth+1, numbers, sb);
                visited[i] = false;
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
