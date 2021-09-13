class Solution {
    public String solution(String number, int k) {

        StringBuilder sb=new StringBuilder();
        String answer = "";
        int last=number.length()-k;
        int ans=number.length()-k;


        while (true) {
            if (sb.length()==ans) break;
            int find_idx=number.length()-last+1;
            String temp=number.substring(0,(find_idx));

            int max_num=find_su(temp);
            String num_String=Integer.toString(max_num);
            sb.append(num_String);

            int next_idx=number.indexOf(num_String);
            number=number.substring(next_idx+1);
            last-=1;

        }
        answer=sb.toString();

        return answer;
    }

    private int find_su(String temp) {
        int max_val=0;
        for (int i=0;i<temp.length();i++) {
            // String Index 접근 : *.charAt(i)
            char val=temp.charAt(i);
            // char -> Int : Character.getNumericValue
            int val_to_int=Character.getNumericValue(val);
            if (val_to_int==9) {
                max_val=val_to_int;
                break;
            }
            else if (max_val<=val_to_int) {
                max_val=val_to_int;
            }
        }
        return max_val;
    }
}