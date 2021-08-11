package com.algo.programmers.hash;

import java.util.*;
public class Level2_phone {
    public static void main(String[] args) {
        Solution2 s2=new Solution2();
        String[]phone={"119", "97674223", "1195524421"}	;
        System.out.println(s2.solution(phone));

    }

}


class Solution2 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        // System.out.println(phone_book.toString());
        boolean answer = true;
        //["119", , "1195524421", "9767422355555"]

        for (int i=0;i<phone_book.length-1;i++) {
            if (phone_book[i+1].startsWith(phone_book[i]) ) {
                return false;
            }
        }
        return answer;
    }




    public boolean solution2_hash(String[] phone_book) {

        boolean answer=true;
        HashSet<String>set=new HashSet<>();

        for (String s:phone_book) {
            set.add(s);
        }

        //["119", "97674223", "1195524421"]
        for (int i=0;i<phone_book.length;i++) {
            for(int j=0;j<phone_book[i].length();j++) {
//                자기자신은 나오지 않게 인덱스 주의하기
                System.out.println(phone_book[i].substring(0,j));
//                Set의 검색이 빠르다는 장점을 이용
//                역으로 생각 ==> 큰 것 속에 작은게 포함되면 false
                if (set.conains(phone_book[i].substring(0,j))) {
                    return false;
                }
            }
        }



        return answer;

    }
}


