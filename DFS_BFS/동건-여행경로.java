 private final static boolean[] checked = new boolean[10000];
    private final static List<String> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(answer);
        return answer.get(0).split(",");
    }

    private void dfs(String begin, String target, String[][] tickets, int count) {
        if (count == tickets.length) {
            answer.add(target);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!checked[i] && begin.equals(tickets[i][0])) {
                checked[i] = true;
                dfs(tickets[i][1], target + "," + tickets[i][1], tickets, count + 1);
                checked[i] = false;
            }
        }
    }
