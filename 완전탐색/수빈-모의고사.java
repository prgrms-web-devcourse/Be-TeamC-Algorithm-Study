import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] A = {1,2,3,4,5};
        int[] B = {2,1,2,3,2,4,2,5};
        int[] C = {3,3,1,1,2,2,4,4,5,5};
        int cntA=0, cntB=0, cntC=0;

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == A[i%A.length]) cntA++;
            if(answers[i] == B[i%B.length]) cntB++;
            if(answers[i] == C[i%C.length]) cntC++;
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(Math.max(cntA, cntB), cntC);
        if(max == cntA) list.add(1);
        if(max == cntB) list.add(2);
        if(max == cntC) list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
