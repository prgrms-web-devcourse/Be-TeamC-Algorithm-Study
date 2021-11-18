import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    
    class Word {
        String str;
        int cnt;
        Word(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        if(!Arrays.asList(words).contains(target)) {
	        return 0;
	    }
        
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();   
        
        queue.add(new Word(begin, 0));
        
        while(!queue.isEmpty()){
            Word word = queue.poll();
            if(word.str.equals(target)) {
                return word.cnt;
            }
            
            for(int i=0; i<words.length; i++){
                if(canSwitch(word.str, words[i]) && !visited[i]){
                    visited[i] = true;
                    queue.add(new Word(words[i], word.cnt+1));
                }
            }
        }
        return 0;
    }
    
    public boolean canSwitch(String s1, String s2){
        int diff = 0;

        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;

            if (diff >= 2)
                return false;
        }
        return true;
    }
}
