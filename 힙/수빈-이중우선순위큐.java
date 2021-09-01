import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> asc = new PriorityQueue<>();
        Queue<Integer> des = new PriorityQueue<>(Collections.reverseOrder());
        int size = 0;

        for(String op : operations) {
            if(size==0) {
                asc.clear(); 
                des.clear();
            }

            String[] arr = op.split(" ");
            int num = Integer.parseInt(arr[1]);

            if(arr[0].equals("I")) {
                asc.add(num);
                des.add(num);
                size++;
            }

            if(arr[0].equals("D")) {
                if(size==0) continue;
                
                size--;

                if(num==-1) {
                    asc.poll(); continue;
                }

                if(num==1) {
                    des.poll();
                }
            }
        }
        if(size==0) return new int[]{0, 0};
        
        return new int[]{des.poll(), asc.poll()};
    }
}
