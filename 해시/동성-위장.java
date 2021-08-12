package com.algo.programmers.hash;
import java.util.*;

public class Level2_disguise {
    public static void main(String[] args) {

        Solution3 ld=new Solution3();
        String value[][]={{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        ld.solution(value);

    }

}



class Solution3 {
    public int solution(String[][] clothes) {


        // HahMap을 이용해서 쪼개기
        // headgear : yello,green
        // eyewear : blue
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();


        for (int i=0;i<clothes.length;i++) {
            String val=clothes[i][0];
            String key=clothes[i][1];

//            System.out.println("val:"+val);
//            System.out.println("key:"+key);

            if (!map.containsKey(key)) {
                ArrayList<String>temp=new ArrayList<>();
                temp.add(val);
                map.put(key,temp);
            }

            else {
                // key를 통해 value 뽑기
                ArrayList<String>temp1=new ArrayList<>();
//                System.out.println("mapKEY"+map.get(key));
                temp1=map.get(key);
                temp1.add(val);

                // temp1에 더하기
                map.put(key,temp1);

            }
        }

        System.out.println("mapToString"+map.toString());
        //

        int answer = 1;
        for (String key:map.keySet()) {
            int temp=map.get(key).size();
            answer*=(temp+1);
        }
//        System.out.println(answer);


        return answer-1;
    }


}