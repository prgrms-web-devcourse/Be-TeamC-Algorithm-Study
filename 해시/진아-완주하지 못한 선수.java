import java.util.*;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        List<String> participantsNotCompleted = new ArrayList<>();
        HashMap<String, Integer> participantMap = new HashMap<>();

        for(String person : participant){
            participantMap.put(person, participantMap.getOrDefault(person, 0) + 1);
        }

        for(String person : completion){
            if(participantMap.get(person) > 1) {
                participantMap.put(person, participantMap.get(person) - 1);
            }
            else {
                participantMap.remove(person);
            }
        }

        participantsNotCompleted = new ArrayList<>(participantMap.keySet());

        return participantsNotCompleted.get(0);
    }
}
