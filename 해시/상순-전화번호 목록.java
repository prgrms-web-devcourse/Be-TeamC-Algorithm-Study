/*
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 *
 * 처음 생각 (solution1)
 * 각각의 문자들이 하나씩 안에 있는지 확인하는 방식으로 생각
 * IndexOf 함수로 위치를 시작 위치가 0인지 확인하여 체크
 * sort을 하게 되면 문자열 길이로 정렬될 것으로 생각하였음
 * 시간 복잡도 N * N으로 시간 초과
 *
 * solution2
 * 문자열을 정렬할 경우 아스키코드로 정렬
 * 예를 들어, {123, 12345, 23, 23456, 3}처럼 정렬되게 됨
 * 앞에 문자열이 뒤의 문자열 접두어가 되도록 정렬됨
 * IndexOf의 0위치를 startsWith라는 함수로 대체할 수 있음
 *
 *
 * */

import java.util.*;


class Solution {

    public boolean solution1(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length; i++){
            String x = phone_book[i];
            for(int j = 0; j < phone_book.length; j++){
                if(i == j)
                    continue;
                if(phone_book[j].indexOf(x) == 0)
                    return false;
            }
        }
        return answer;
    }

    public boolean solution2(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            String x = phone_book[i];
            if(phone_book[i+1].startsWith(x)){
                return false;
            }
        }
        return answer;
    }
}
