import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;

        for(int yelloWidth : getWidth(yellow)){
            int yelloHeight = yellow / yelloWidth;

            if((yelloHeight+2) * (yelloWidth+2) == area){
                return new int[]{yelloWidth + 2, yelloHeight + 2};
            }
        }

        return null;
    }

    List<Integer> getWidth(int yellow){
        List<Integer> widths = new ArrayList<>();

        for(int width=yellow;width>=1;width--){
            int height = yellow / width;
            
            if(width < height) {
                break;
            }

            if((yellow % width == 0) && (width >= height)){
                widths.add(width);
            }
        }

        return widths;
    }
}
