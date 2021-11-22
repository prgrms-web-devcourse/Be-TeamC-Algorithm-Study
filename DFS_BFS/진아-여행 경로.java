import java.util.*;

class Solution {
    private Map<String, List<String>> ticketMap;
    private Map<String, boolean[]> isVisited;
    private List<String> resultRoute;
    private int ticketNumber;

    public String[] solution(String[][] tickets) {
        ticketMap = new HashMap<>();
        isVisited = new HashMap<>();
        ticketNumber = tickets.length;
        resultRoute = new ArrayList<>();

        for(String[] ticket : tickets){
            List<String> destinations = ticketMap.getOrDefault(ticket[0], new ArrayList<>());
            destinations.add(ticket[1]);
            ticketMap.put(ticket[0], destinations);
        }

        for(String departure : ticketMap.keySet()){
            Collections.sort(ticketMap.get(departure));
            isVisited.put(departure, new boolean[ticketMap.get(departure).size()]);
        }

        List<String> route = new ArrayList<>();
        route.add("ICN");

        dfs("ICN", ticketMap, route);

        return resultRoute.toArray(String[]::new);
    }

    private void dfs(String destination, Map<String, List<String>> tickets, List<String> route){
        if(!tickets.containsKey(destination) || route.size() == ticketNumber + 1){
            if(resultRoute.isEmpty() && isAllVisited()){
                resultRoute = new ArrayList<>(route);
            }
            return;
        }

        for(int i=0; i<tickets.get(destination).size(); i++){
            if(isVisited.get(destination)[i])
                continue;

            String next = tickets.get(destination).get(i);

            route.add(next);
            isVisited.get(destination)[i] = true;

            dfs(next, tickets, route);

            route.remove(route.size()-1);
            isVisited.get(destination)[i] = false;
        }
    }

    private boolean isAllVisited(){
        for(String departure : isVisited.keySet()){
            for(int i=0;i<isVisited.get(departure).length;i++){
                if(!isVisited.get(departure)[i]){
                    return false;
                }
            }
        }

        return true;
    }

}
