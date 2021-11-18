class Solution {
    private static boolean[] check;
    private static int number;

    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        number = 0;
        dfs(begin, target, words, 0);
        return number;
    }

    private void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            number = count;
            return;
        }
        for (int i = 0; i < words.length; i++) {

            if (!check[i] && isOneSame(begin, words[i])) {
                check[i] = true;
                dfs(words[i], target, words, count+1);
                check[i] = false;
            }
        }
    }

    private boolean isOneSame(String present, String next) {
        int num = 0;
        for (int i = 0; i < present.length(); i++) {
            if (present.charAt(i) != next.charAt(i)) {
                num++;
            }
            if (num > 1) {
                return false;
            }
        }

        return num == 1;
    }
}
