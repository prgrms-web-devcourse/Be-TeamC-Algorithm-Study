class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        int idx = 0, max = 0;
        
        for(int i=0; i<number.length()-k; i++) {
            max = 0;
            for(int j=idx; j<=k+i; j++) {
                int num = number.charAt(j)-'0';
                if(max < num) {
                    max = num;
                    idx = j+1;
                    if(max == 9) break;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}
