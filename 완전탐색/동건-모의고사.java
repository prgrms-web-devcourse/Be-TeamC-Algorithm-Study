class Solution {
    public int[] solution(int[] answers) {
        int[][] answer = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        int[] check = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answer[0][i % answer[0].length] == answers[i]) {
                check[0]++;
            }

            if (answer[1][i % answer[1].length] == answers[i]) {
                check[1]++;
            }

            if (answer[2][i % answer[2].length] == answers[i]) {
                check[2]++;
            }
        }

        if (check[0] == check[1] && check[1] == check[2]) {
            return new int[]{1, 2, 3};
        } else if (check[0] == check[1] && check[1] != check[2] && check[0] > check[2]) {
            return new int[]{1, 2};
        } else if (check[0] != check[1] && check[1] == check[2] && check[1] > check[0]) {
            return new int[]{2, 3};
        } else if (check[0] == check[2] && check[0] != check[1] && check[0] > check[1]) {
            return new int[]{1, 3};
        } else if (check[0] > check[1] && check[0] > check[2]) {
            return new int[]{1};
        } else if (check[1] > check[0] && check[1] > check[2]) {
            return new int[]{2};
        } else {
            return new int[]{3};
        }
    }
}
