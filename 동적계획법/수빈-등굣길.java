class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] route = new int[n+1][m+1];
        route = setUp(route, m, n, puddles);
        
        return calc(route, m, n)%1000000007;
        
    }
    // 1행, 1열 모두 1로 초기화, puddle = -1
    public int[][] setUp(int[][] arr, int m, int n, int[][] puddles) {
        
        for(int[] puddle: puddles) {
            arr[puddle[1]][puddle[0]] = -1;
        }
        
        // puddle이 있다면 그 이후 배열 모두 0
        for(int i=2; i<m+1; i++) {
            if(arr[1][i] == -1) {
                for(int j=i; j<m+1; j++) {
                    arr[1][j] = 0;
                }
                break;
            }
            arr[1][i] = 1;
        }
        for(int i=2; i<n+1; i++) {
            if(arr[i][1] == -1) {
                for(int j=i; j<n+1; j++) {
                    arr[j][1] = 0;
                }
                break;
            }
            arr[i][1] = 1;
        }
        return arr;
    }
    
    public int calc(int[][] arr, int m, int n) {
        for(int i=2; i<n+1; i++) {
            for(int j=2; j<m+1; j++) {
                if(arr[i][j]==-1) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = (arr[i-1][j] + arr[i][j-1])%1000000007;
            }
        }
        return arr[n][m];
    }
}
