public class Solution {
    public int solution(int[][] triangle) {
        for(int row = 1; row < triangle.length; row++){
            for(int col = 0; col < triangle[row].length; col++){
                int leftCol = col - 1;
                int rightCol = col;
                int prevRow = row - 1;

                int max = 0;
                if(leftCol >= 0) { max = Math.max(triangle[prevRow][leftCol], max); }
                if(rightCol < triangle[prevRow].length) { max = Math.max(triangle[prevRow][rightCol], max); }

                triangle[row][col] += max;
            }
        }

        int maxSum = 0;
        int lastRow = triangle.length - 1;
        for(int col = 0; col < triangle[lastRow].length; col++){
            maxSum = Math.max(triangle[lastRow][col], maxSum);
        }

        return maxSum;
    }  
}
