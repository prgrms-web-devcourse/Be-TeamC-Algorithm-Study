import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] firstAnswer = {1, 2, 3, 4, 5};
        int[] secondAnswer = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdAnswer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        for(int i=0;i<answers.length;i++){
            if(firstAnswer[i%firstAnswer.length] == answers[i]) score[0]++;
            if(secondAnswer[i%secondAnswer.length] == answers[i]) score[1]++;
            if(thirdAnswer[i%thirdAnswer.length] == answers[i]) score[2]++;
        }
        
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<score.length;i++){
            if(score[i] == maxScore) { result.add(i+1); }
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
