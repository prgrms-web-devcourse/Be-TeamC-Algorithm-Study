import java.util.ArrayList;
import java.util.Collections;

class Solution {
 
    static ArrayList<String> answer = new ArrayList<>();
    static String[][] TICKETS;
    static int len;

    public static String[] solution(String[][] tickets) {
        TICKETS = tickets;
        len = TICKETS.length;
        boolean[] visited = new boolean[len];
        
        dfs("ICN", "", 0, visited);
        
        Collections.sort(answer);
        return answer.get(0).split(",");
    }

    public static void dfs(String where, String route, int visitCount, boolean[] visited) {
        route += where + ",";

        if(visitCount==len) {
            answer.add(route);
            return;
        }

        for(int i=0; i<len; i++) {
            String src = TICKETS[i][0];
            String dest = TICKETS[i][1];
            if(src.equals(where) && !visited[i]) {
                visited[i] = true;
                dfs(dest, route, visitCount + 1, visited);
                visited[i] = false;
            }
        }
    }
}
