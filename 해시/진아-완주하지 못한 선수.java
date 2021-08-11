import java.util.*;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> completionMap = new HashMap<>();

        for(String person : completion){
            if(completionMap.containsKey(person)) {
                completionMap.put(person, completionMap.get(person) + 1);
            }
            else {
                completionMap.put(person, 1);
            }
        }

        for(String person : participant){
            if(!completionMap.containsKey(person)){
                return person;
            }

            if(completionMap.get(person) == 1) {
                completionMap.remove(person);
            }
            else {
                completionMap.put(person, completionMap.get(person) - 1);
            }
        }

        List<String> participantsNotCompleted = new ArrayList<>(completionMap.keySet());
        return participantsNotCompleted.get(0);
    }
}
