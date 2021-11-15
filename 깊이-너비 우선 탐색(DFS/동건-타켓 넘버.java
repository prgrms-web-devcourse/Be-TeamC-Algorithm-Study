class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    public int dfs(int[] numbers, int index, int total, int target) {
        // 위치가 numbers.length와 같다면, 끝까지 index를 끝까지 진행한 것!
        if (index == numbers.length) {
            // target == total이라면 마지막이 성공한 것
            if (target == total) {
                return 1;
            }
            // 만들 수 있는 방법이 존재하지 않음
            return 0;
        }
        // index를 하나 올리고, total에 -,+연산자 dfs를 수행
        return dfs(numbers, index + 1, total + numbers[index], target) +
                dfs(numbers, index + 1, total - numbers[index], target);

    }
}
