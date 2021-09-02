import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// stream, 람다 식을 이용한 *수정* 버전
// Ide최고...

class Solution {
    public String solution(int[] numbers) {
        List<String> ans = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        ans.sort((s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (ans.get(0).equals("0")) {
            return "0";
        }

        return String.join("", ans);
    }
}
