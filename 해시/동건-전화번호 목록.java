import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String key : set) {
            for (int index = 0; index < key.length(); index++){
                if (set.contains(key.substring(0, index))){ 
                    return false;
                }
            }
        }
        return true;
    }
}
