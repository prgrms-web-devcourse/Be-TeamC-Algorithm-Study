import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(reserve);
        
        Set<Integer> reserves = new HashSet<>();
        Set<Integer> losts = new HashSet<>();

        for (int l : lost) losts.add(l);
        for (int r : reserve) reserves.add(r);

        for(int r : reserve){
            if(losts.contains(r)){
                reserves.remove(r);
                losts.remove(r);
                continue;
            }

            if (r - 1 >= 0 && losts.contains(r - 1)) {
                reserves.remove(r);
                losts.remove(r - 1);
                continue;
            }

            if (r + 1 < n && losts.contains(r + 1)) {
                reserves.remove(r);
                losts.remove(r + 1);
            }
        }

        return n - losts.size();
    }
