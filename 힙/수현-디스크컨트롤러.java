/*
 * 빨리 끝나는 작업 먼저 처리
 *
 * 현재 시작 가능한 작업 중 처리 시간이 가장 짧은 작업을 먼저 처리
 *
 * 요청시간의 오름차순으로 대기큐 관리
 *
 * 작업큐(우선순위큐 - 작업시간이 적은 것) <- 현재 실행 가능한 작업
 *
 * 문제를 잘 읽자;;
 * [1, 10] [2, 1], [5, 10]
 * curTime = 11 + 1 = 12 + 10 = 22
 * TA = 10 + 10 + 17 = 37
 *
 * 3  13  23
 * 1 + 12 + 18
 *
 * [[0, 5], [2, 10], [100000000000, 2]]
 * */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution6 {

    static class Job implements Comparable<Job> {

        int arrivalTime;
        int burstTime;

        public Job(int arrivalTime, int burstTime) {
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }

        @Override
        public int compareTo(Job o) {
            return burstTime - o.burstTime;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        int currTime = 0;
        int totalTurnAroundTime = 0;

        Queue<Job> waitingQueue = new LinkedList<>();
        Queue<Job> execQueue = new PriorityQueue<>();

        Arrays.sort(jobs, (j1, j2) -> {
            if (j1[0] == j2[0]) {
                return j1[1] - j2[1];
            } else {
                return j1[0] - j2[0];
            }
        });

        for (int[] job : jobs) {
            waitingQueue.add(new Job(job[0], job[1]));
        }

        // 첫번째 작업
        Job firstJob = waitingQueue.poll();
        currTime += firstJob.arrivalTime + firstJob.burstTime;
        totalTurnAroundTime += currTime - firstJob.arrivalTime;

        while (!waitingQueue.isEmpty() || !execQueue.isEmpty()) {
            while (!waitingQueue.isEmpty() && waitingQueue.peek().arrivalTime < currTime) {
                execQueue.add(waitingQueue.poll());
            }
            //만약 waitingQueue가 비어있지 않은데, peek할 원소의 도착시간이 현재 시간보다 늦으면?
            if (!waitingQueue.isEmpty() && execQueue.isEmpty()) {
                execQueue.add(waitingQueue.poll());
            }
            Job job = execQueue.poll();
            currTime += job.burstTime;
            totalTurnAroundTime += currTime - job.arrivalTime;
        }

        return totalTurnAroundTime / jobs.length;
    }

}
