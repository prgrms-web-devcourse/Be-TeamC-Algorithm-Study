import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 이분탐색에서 정렬이 필수적!
        Arrays.sort(times);
        return binarySearch(times, n);
    }

    // 이분 탐색 템플릿
    // start는 최선의 경우
    // end는 최악의 경우
    // mid는 찾는 값
    private long binarySearch(int[] arr, int target) {
        // 최선의 경우
        long start = 1;

        // 최악의 경우
        long end = (long) arr[arr.length - 1] * target;

        // 찾는 값
        long mid = 0;

        // 걸린 시간
        long answer = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            // 예상 시간 값 --> 이 시간안에 심사가 가능한 인원수를 의미
            long temp = 0;
            for (int time : arr) {
                temp += mid / time;
            }

            // 심사대가 사람보다 많음
            if (temp >= target) {
                end = mid - 1;
                answer = mid;
            } else { // 심사대가 사람보다 적음
                start = mid + 1;
            }
        }
        return answer;
    }
}
