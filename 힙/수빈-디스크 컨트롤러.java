import java.util.*;

class Solution {
    
    class Job {
        int req;
        int time;
        
        public Job(int req, int time) {
            this.req = req;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        
        int answer = 0;
        Queue<Job> queue = new PriorityQueue<>(new Comparator<Job>() {
            // 작업이 요청되는 시점 순으로 정렬
            @Override
            public int compare(Job j1, Job j2) {
                return j1.req - j2.req;
            }
        });
        
        Queue<Job> temp = new PriorityQueue<>(new Comparator<Job>() {
            // 작업 시간의 오름차순으로 정렬
            @Override
            public int compare(Job j1, Job j2) {
                return j1.time - j2.time;
            }
        });
        
        for(int[] job : jobs) {
            queue.add(new Job(job[0], job[1]));
        }

        int now = 0;  // 현재 시점
        while(!queue.isEmpty()) {
            // 현재 시점보다 같거나 작은 시점의 job 들을 꺼내온 후 소요시간 순으로 정렬
            while(!queue.isEmpty() && queue.peek().req <= now) {
                temp.add(queue.poll());
            }
            
            if(temp.isEmpty()) {
                now++;
                continue;
            }
            
            // answer = (now - 해당 job의 요청시점) + 소요시간
            // now += 소요시간
            Job job = temp.poll();
            answer += now - job.req + job.time;
            now += job.time;
            
            // 나머지는 다시 큐에 집어 넣음
            while(!temp.isEmpty()) {
                queue.add(temp.poll());
            }
        }
        
        return answer/jobs.length;
    }
}
