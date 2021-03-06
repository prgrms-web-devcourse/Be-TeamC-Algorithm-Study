// import java.util.Arrays;

// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         int ans = 0;
        
//         Arrays.sort(participant);
//         Arrays.sort(completion);
        
//         for(int i=0; i<completion.length; i++) {
//             if(!participant[i].equals(completion[i])) {
//                 ans = i;
//                 break;
//             }
//             if(i==completion.length-1) ans = i+1;
//         }
//         return participant[ans];
//     }
// }

// HashMap 사용 버전
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
      
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
