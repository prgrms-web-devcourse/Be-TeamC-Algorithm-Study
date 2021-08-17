/*

https://programmers.co.kr/learn/courses/30/lessons/42586

Solution
앞의 프로세스가 끝날 때까지 뒤의 프로세스는 작업이 끝나도 대기하고 있는다.
first in first out -> 큐
리스트로 하나씩 보면서 작업이 완료될때까지 남은 일자를 구해 뒤에 작업에서 앞에서 한 작업일수 만큼 일했을때 100이 넘으면 +1
아니라면 정답에 저장하고 count와 작업일수 초기화

*/


import java.util.*;

class Solution1 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        int speed = 0;
        int remain = 0;
        int progress = 0;
        for(int i = 0; i < progresses.length; i++){
            speed = speeds[i];
            progress = progresses[i];

            // 처음 값을 위해서 작업일 수 초기화
            if (count == 0){
                remain = (100 - progress) / speed;
                if((100 - progress) % speed != 0)
                    remain ++;
            }

            //  count만 증가
            if(remain * speed + progress >= 100){
                count++;
                continue;
            }
            else {
                //저장하고 초기화
                answer.add(count);
                count = 1;
            }
            // 다음 작업일수로 초기화
            remain = (100 - progress) / speed;
            if((100 - progress) % speed != 0)
                remain ++;
        }

        answer.add(count);

        return answer.stream().mapToInt(i->i).toArray();
    }
}