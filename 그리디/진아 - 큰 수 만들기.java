import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        
        int initialK = k;
        int i = 0;
        
        while(i < number.length()){
            char c = number.charAt(i);

            while(!deque.isEmpty() && deque.peekLast() < c && k-- > 0){
                deque.pollLast();
            }

            deque.addLast(c);
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(i = 0; i< number.length() - initialK; i++){
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }
}
