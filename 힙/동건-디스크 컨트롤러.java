import java.util.*;
import java.util.stream.Collectors;



class Solution {
    public int solution(int[][] jobs) {
int answer = 0;
        int count = 0;
        int endTime = 0;

        List<Job> data = Arrays.stream(jobs).map(job -> new Job(job[0], job[1])).collect(Collectors.toList());
        data.sort((Comparator.comparingInt(o -> o.startTime)));
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.workTime));

        int index = 0;
        while (count < data.size()) {
            while (index < data.size() && data.get(index).startTime <= endTime) {
                priorityQueue.add(data.get(index++));
            }

            if (priorityQueue.isEmpty()) {
                endTime = data.get(index).startTime;
            } else {
                Job job = priorityQueue.poll();
                answer += job.workTime + endTime - job.startTime;
                endTime += job.workTime;
                count++;
            }
        }

        return answer / count;
    }
}

class Job {
    int startTime;
    int workTime;

    public Job(int startTime, int workTime) {
        this.startTime = startTime;
        this.workTime = workTime;
    }
}
