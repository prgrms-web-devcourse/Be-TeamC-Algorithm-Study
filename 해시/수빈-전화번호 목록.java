// import java.util.HashMap;

// class Solution {
//     public boolean solution(String[] phone_book) {
        
//         HashMap<String, Integer> hm = new HashMap<>();

//         for(String phone: phone_book) {
//             hm.put(phone, 0);
//         }
        
//         for(String phone: phone_book) {
//             for(int i=1; i<phone.length(); i++) {
//                 String num = phone.substring(0, i);
//                 if(hm.containsKey(num)) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }

// HashSet 사용 버전
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set <String> hs = new HashSet<>(Arrays.asList(phone_book));
        
        for(String key: hs) {
            for(int i=1; i<key.length(); i++) {
                if(hs.contains(key.substring(0, i))) return false;
            }
        }

        return true;
    }
}
