/*
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
        static class Pair {
        int height;
        int width;

        public Pair(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }

    public int[] solution(int brown, int yellow) {

        List<Pair> pairs = getPairs(yellow);
        Pair yellowPair = matchPair(pairs, brown);

        return new int[]{yellowPair.width + 2, yellowPair.height + 2};
    }

    private Pair matchPair(List<Pair> pairs, int brown) {

        for (Pair pair : pairs) {
            if (brown == (pair.height * 2 + pair.width * 2 + 4)) {
                return pair;
            }
        }
        throw new IllegalArgumentException();
    }

    private List<Pair> getPairs(int yellow) {
        List<Pair> result = new ArrayList<>();

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                if (i > (yellow / i)) {
                    break;
                }
                result.add(new Pair(i, yellow / i));
            }
        }
        return result;
    }
}
