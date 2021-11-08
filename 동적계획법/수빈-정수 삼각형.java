class Solution {
    public int solution(int[][] triangle) {
        int max = 0;
        for(int num: solve(triangle)) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    public int[] solve(int[][] arr) {
        int len = arr.length;
        int[][] newArr = new int[len][arr[len-1].length];
        newArr[0][0] = arr[0][0];
        
        for(int i=0; i<len-1; i++) {
            for(int j=0; j<arr[i].length; j++) {
                newArr[i+1][j] = Math.max(newArr[i][j]+arr[i+1][j], newArr[i+1][j]);
                newArr[i+1][j+1] = Math.max(newArr[i][j]+arr[i+1][j+1], newArr[i+1][j+1]);
            }
        }
        return newArr[len-1];
    }
}
