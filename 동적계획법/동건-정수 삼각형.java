/*
        (0,0)
      (1,0)(1,1)
    (2,0)(2,1)(2,2)
  (3,0)(3,1)(3,2)(3,3)
(4,0)(4,1)(4,2)(4,3)(4,4)


왼쪽 빗변은 j==0일때만 가능
오른족 빗변은 i == j가 같을 때만
나머지는 둘중 하나 선택해서 큰값이 들어가게 됨

*/






class Solution {
    public int solution(int[][] triangle) {
        int max = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }

                if (max <= triangle[i][j]) {
                    max = triangle[i][j];
                }
            }
        }
        return max;
    }
}
