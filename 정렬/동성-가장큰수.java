class Solution {
    public String solution(int[] numbers) {

        String numStr[]=new String[numbers.length];

//      Int ==> String으로 변환
        for (int i=0;i<numbers.length;i++) {

            numStr[i]=String.valueOf(numbers[i]);
            // System.out.println(numStr[i]);
        }

//       Compartor
        Arrays.sort(numStr,new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                return ((b+a).compareTo(a+b));
            }
        });



        String answer = "";

        if (numStr[0].equals("0")) {
            return "0";
        }


        for (String a:numStr) {
            answer+=a;
        }

        return answer;
    }
}