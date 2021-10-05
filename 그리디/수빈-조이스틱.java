class Solution {
     public int solution(String name) {
        int answer = 0;
        int max = 0, cnt = 0;
        int idx = name.length(), lastIdx = name.length();

        for (int i = 0; i < name.length(); i++) {
            
            int temp = Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            answer += temp;

            if (temp == 0) {
                cnt++;
                continue;
            }
            if (max < cnt) {
                max = cnt;
                lastIdx = i;
                idx = i - cnt;
            }
            cnt = 0;
        }
        
        answer += Math.min(name.length()-1, 2*(idx-1) + name.length()-lastIdx);

        return answer;
    }
}
