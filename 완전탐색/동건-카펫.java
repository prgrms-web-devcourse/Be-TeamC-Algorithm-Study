class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for (int row = sum; row >= 3; row--) {
            if (sum % row == 0) {
                int col = sum / row;
                int doYellow = (col - 2) * (row - 2);

                if (yellow == doYellow) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{0,0};
    }
}
