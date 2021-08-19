import java.util.LinkedList;
import java.util.Queue;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 큐(다리), 대기큐(트럭 대기줄)
 * 큐가 비어있는 경우:
 *       큐에 트럭을 넣는다
 *       시간 + 1
 * 큐가 가득 차지 않은 경우:
 *   - 차를 더 올릴 수 있는 경우:
 *       큐에 트럭을 넣는다
 *       시간 + 1
 *
 *   - 차를 더 못 올리는 경우:
 *       0을 넣어 자리를 채운다
 *       시간 + 1
 *
 * 큐가 가득 찬 경우: queue.poll, 시간은 흐르지 않음
 *
 *
 * */
public class Solution3 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (var truck : truck_weights) {

            while (true) {

                // 어떤 트럭도 다리를 건너지 않음, 트럭 한대를 올린다.
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    answer++;
                    break;
                }

                if (bridge.size() == bridge_length) { // 다리가 가득 찬 경우
                    bridge.poll();
                } else {
                    if (calcTotalWeight(bridge) + truck <= weight) { // 트럭이 더 올라 올 수 있는 경우
                        bridge.add(truck);
                        answer++;
                        break;
                    } else {
                        bridge.add(0); // 아니라면 기존 트럭이 한 칸 움직인다.
                        answer++;
                    }
                }
            }
        }

        // 마지막 트럭이 다리에 올라가면 반복문이 끝나므로 다리 길이만큼 시간 추가
        return answer + bridge_length;
    }

    public int calcTotalWeight(Queue<Integer> queue) {
        int result = 0;
        for (Integer integer : queue) {
            result += integer;
        }
        return result;
    }
}
