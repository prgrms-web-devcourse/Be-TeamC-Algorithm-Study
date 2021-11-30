import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 바위 위치 값으로 정렬 진행
        Arrays.sort(rocks);
        return binarySearch(distance, rocks, n);
    }

    // 이분 탐색 템플릿
    // start는 최선의 경우
    // end는 최악의 경우
    // mid는 찾는 값
    private int binarySearch(int distance, int[] rocks, int n) {
        // 최선의 경우
        int start = 1;

        // 최악의 경우
        int end = distance;

        // 찾는 값
        int mid = 0;

        // 최소값
        int answer = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            // 거리 == mid --> 돌 갯수
            int num = 0;

            // 특정 범주에서 mid와 비교를 위한
            int temp = 0;

            for (int rock : rocks) {
                // 바위 삭제
                if (rock - temp < mid) {
                    num++;
                } else {
                    // 바위 교체
                    temp = rock;
                }
            }

            // 특정 범주내의 바위의 distance에 따라 진행
            if (distance - temp < mid) {
                num++;
            }

            // n의 값보다 num이 더 커지는 경우 위치 교환
            if (num > n) {
                end = mid - 1;
            } else { // n이 num보다 더 커지는 경우
                start = mid + 1;

                // mid값으로 갱신 진행
                if (answer < mid) {
                    answer = mid;
                }
            }
        }
        return answer;
    }
}
