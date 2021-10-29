import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        // N이 1개인 집합부터 8개인 집합까지 생성
        List<Set<Integer>> data = new ArrayList<>();

        // 초기화 진행
        for (int i = 0; i < 8; i++) {
            data.add(new HashSet<>());
        }

        // 점화식
        // N이 1개 -> N
        // N이 2개 -> N을 2번 사용 && N이 1개인 경우를 사칙연산
        // N이 3개 -> N을 3번 사용 && N이 1개인 경우와 N이 2개인 경우를 사칙 연산 && N이 2개인 경우와 N이 1개인 경우를 사칙 연산
        // N이 4개 -> N을 4번 사용 && N이 1개인 경우와 N이 3개인 경우를 사칙 연산 && N이 2개인 경우와 N이 2개인 경우를 사칙연산 && N이 3개인 경우와 N이 1개인 경우를 사칙연산

        String str = "";
        for (int i = 0; i < 8; i++) {
            // N을 i번 사용 (i는 실제로 1개부터!)
            str = str + N;
            data.get(i).add(Integer.parseInt(str));
            for (int j = 0; j < i; j++) {
                for (int k : data.get(j)) {
                    for (int l : data.get(i - j - 1)) {
                        data.get(i).add(k + l);
                        data.get(i).add(k - l);
                        data.get(i).add(k * l);
                        if (l != 0) {
                            data.get(i).add(k / l);
                        }
                    }
                }
            }
            if (data.get(i).contains(number)) {
                System.out.println(i+);
                break;
            }
        }
        System.out.println(-1);

    }
}
