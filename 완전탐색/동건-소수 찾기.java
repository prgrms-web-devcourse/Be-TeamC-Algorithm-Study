import java.util.*;
import java.util.stream.Collectors;


class Solution {
  public int solution(String numbers) {


        String[] fragment = numbers.split("");


        Set<Integer> data = new HashSet<>();
        for (int i = 1; i <= fragment.length; i++) {
            Permutation perm = new Permutation(fragment.length, i);
            perm.permutation(fragment, 0);
            ArrayList<ArrayList<String>> result = perm.getResult();

            for (int j = 0; j < result.size(); j++) {
                String temp = "";

                for (int k = 0; k < result.get(j).size(); k++) {
                    temp += result.get(j).get(k);
                }
                data.add(Integer.parseInt(temp));
            }
        }
        int answer = 0;

        for (int num : data) {
            if (num == 1 || num == 0) {
                continue;
            }
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                answer++;
            }
        }

        return answer;
    }
}


class Permutation {
    private int n;
    private int r;
    private String[] now;
    private ArrayList<ArrayList<String>> result;

    public ArrayList<ArrayList<String>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new String[r];
        this.result = new ArrayList<>();
    }

    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(String[] arr, int depth) {
        if (depth == r) {
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
}

