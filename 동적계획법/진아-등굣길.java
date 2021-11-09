public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        for(int[] puddle : puddles){
            int col = puddle[0] - 1;
            int row = puddle[1] - 1;

            map[row][col] = -1;
        }

        map[0][0] = 1;
        
        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[0].length; col++){
                if(map[row][col] == -1){
                    continue;
                }

                if(col + 1 < map[0].length && map[row][col+1] != -1){
                    map[row][col+1] += map[row][col]  % 1000000007;
                }

                if(row + 1 < map.length && map[row+1][col] != -1){
                    map[row+1][col] += map[row][col]  % 1000000007;
                }
            }
        }

        return map[n-1][m-1] % 1000000007;
    }
}
