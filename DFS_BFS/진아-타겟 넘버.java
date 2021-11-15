public class Solution {
    int[] numbers;
    int target;
    int cnt;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.cnt = 0;

        visit(0, 0);

        return cnt;
    }

    private void visit(int i, int sum){
        if(i == numbers.length){
            if(sum == target){
                this.cnt++;
            }
            return;
        }

        visit(i+1, sum + numbers[i]);
        visit(i+1, sum - numbers[i]);
    }
}
