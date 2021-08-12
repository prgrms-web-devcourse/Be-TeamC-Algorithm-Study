import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String, Integer> hm = new HashMap<>();

        for(String phone: phone_book) {
            hm.put(phone, 0);
        }
        
        for(String phone: phone_book) {
            for(int i=1; i<phone.length(); i++) {
                String num = phone.substring(0, i);
                if(hm.containsKey(num)) {
                    return false;
                }
            }
        }

        return true;
    }
}
