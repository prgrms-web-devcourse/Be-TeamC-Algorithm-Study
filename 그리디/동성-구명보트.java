import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i:people) {
            arrayList.add(i);
        }
        // 정렬
        Collections.sort(arrayList);

        int start=0;
        int last=arrayList.size()-1;

        int answer = 0;
        while (start<=last) {
            int maxVal=arrayList.get(last);
            int minVal=arrayList.get(start);
            int hap=minVal+maxVal;
                
            if (hap<=limit) {
                // 둘다 통과 
                start+=1;
                last -=1;
            }
            else {
                // 마지막 것만 통과 
                last-=1;
            }
            answer+=1;
        }
        return answer;
    }
}