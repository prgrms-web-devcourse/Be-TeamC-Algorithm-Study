import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Music>> insertMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();

        int length = genres.length;

        for (int i = 0; i < length; i++) {
            if (!insertMap.containsKey(genres[i])) {
                List<Music> temp = new ArrayList<>();
                temp.add(new Music(i, plays[i]));
                insertMap.put(genres[i], temp);
            } else {
                insertMap.get(genres[i]).add(new Music(i, plays[i]));
            }
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        Map<Integer, String> highScore = new TreeMap<>(Collections.reverseOrder());

        for (String genre : totalMap.keySet()) {
            highScore.put(totalMap.get(genre), genre);
        }

        List<Integer> result = new ArrayList<>();
        for (String genre : highScore.values()) {
            List<Music> musicList = insertMap.get(genre);
            Collections.sort(musicList);
            int check = 0;

            for (Music music : musicList) {
                if (check == 2) {
                    break;
                }
                result.add(music.id);
                check++;
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

class Music implements Comparable<Music> {

    int id;
    int play;

    public Music(int id, int play) {
        this.id = id;
        this.play = play;
    }

    @Override
    public int compareTo(Music o) {
        if (this.play < o.play) {
            return 1;
        }
        if (this.play == o.play) {
            if (this.id > o.id) {
                return 1;
            }
        }
        return -1;
    }
}
