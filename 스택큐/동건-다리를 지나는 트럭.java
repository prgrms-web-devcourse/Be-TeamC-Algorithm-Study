import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int times = 0;
    private static final int EMPTY_BRIDGE = 0;
    private static int index = 0;
    private static int currentBridgeWeight = 0;
    private static Queue<Integer> bridge = new LinkedList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        while (index != truck_weights.length) {
            if (bridge.size() == bridge_length) {
                pollCurrentBridgeWeight();
                continue;
            }

            if (currentBridgeWeight + truck_weights[index] <= weight) {
                fillBridge(truck_weights[index]);
                offerCurrentBridgeWeight(truck_weights);
                index++;
            } else {
                fillBridge(EMPTY_BRIDGE);
            }

            times++;
        }

        return result(bridge_length);
    }

    public void offerCurrentBridgeWeight(int[] input) {
        currentBridgeWeight += input[index];
    }

    public void pollCurrentBridgeWeight() {
        currentBridgeWeight -= bridge.poll();
    }

    public void fillBridge(int input) {
        bridge.add(input);
    }

    public int result(int input) {
        return times + input;
    }
}
