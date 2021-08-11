/*
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 *
 * 처음 생각 (solution1)
 * 어떤 문자열이 그것보다 길이가 짧은 문자열의 접두어가 될 수 없으므로, 문자열의 길이로 오름차순 정렬을 한 후,
 * 하나씩 비교 -> 시간 복잡도 O(N^2)으로 시간초과
 *
 * solution2
 * 아스키로 정렬할 경우
 * 예를 들어, {a, ab, abab, cd}처럼 정렬되면 접두어가 되는 문자열은 항상 자기 자신 앞에 존재
 * 자기 앞과 비교해서 접두어가 존재할 경우 false 반환
 * */

import java.util.Arrays;


class Solution {

    public boolean solution1(String[] phone_book) {

        Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
