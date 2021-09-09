import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int row = 0, col = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) list.add(i);
        }
        
        for (int i = 0; i < list.size(); i++) {
            row = list.get(i);
            col = yellow / row;

            if (2 * (row + col) + 4 == brown) break;
        }

        return new int[]{col+2, row+2};
    }
}
