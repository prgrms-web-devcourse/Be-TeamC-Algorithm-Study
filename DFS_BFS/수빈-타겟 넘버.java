class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    public void dfs(int[] numbers, int idx, int total, int target) {
        if(idx == numbers.length) {
            if(total == target) {
                answer++;
            }
            return;
        }
        int minus = total-numbers[idx];
        dfs(numbers, idx+1, minus, target);
        int plus = total+numbers[idx];
        dfs(numbers, idx+1, plus, target);
    }
}
