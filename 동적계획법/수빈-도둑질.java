class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] one =new int[money.length-1];
        int[] two= new int[money.length];
        
        one[0]=money[0];
        one[1]=money[0];
        two[0]=0;
        two[1]=money[1];
        for(int i=2;i<one.length;i++){
            one[i]=Math.max(one[i-2]+money[i],one[i-1]);
        }
        for(int i=2;i<two.length;i++){
            two[i]=Math.max(two[i-2]+money[i],two[i-1]);
        }
        
        return Math.max(one[one.length-1],two[two.length-1]);
    }
}
