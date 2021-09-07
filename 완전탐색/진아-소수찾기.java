import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<Integer> primaNumbers;

    public int solution(String numbers) {
        primeNumbers = new HashSet<>();
        
        for(int r=1;r<=numbers.length();r++){
            permutation(numbers.toCharArray(), 0, r);
        }

        return primeNumbers.size();
    }

    private void permutation(char[] chars, int depth, int r) {
        if (depth == r) {
            int number = parseInt(chars, r);
            if(!primeNumbers.contains(number) && isPrimeNumber(number)){
                primeNumbers.add(number);
            }

            return;
        }

        for (int i = depth; i < chars.length; i++) {
            swap(chars, depth, i);
            permutation(chars, depth + 1, r);
            swap(chars, depth, i);
        }
    }

    private int parseInt(char[] arr, int size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
        }

        return Integer.parseInt(sb.toString());
    }
    
    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public boolean isPrimeNumber(int inputNumber) {
        if (inputNumber <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(inputNumber); i++) {
            if ((inputNumber % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
