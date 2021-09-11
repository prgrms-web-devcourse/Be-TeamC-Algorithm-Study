import static java.util.Comparator.*;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

    static class Music implements Comparable<Music> {

        private int id;
        private String genre;
        private int plays;

        public Music(int id, String genre, int plays) {
            this.id = id;
            this.genre = genre;
            this.plays = plays;
        }

        public int getId() {
            return id;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlays() {
            return plays;
        }

        @Override
        public int compareTo(Music o) {
            if (this.plays == o.plays) {
                return this.id - o.id;
            }
            //* plays 오름차순 정렬
            return -(this.plays - o.plays);
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        List<Music> musics = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            musics.add(new Music(i, genre, play));
        }

        Map<String, List<Music>> musicsByGenre = musics.stream()
            .collect(groupingBy(Music::getGenre));

        Map<String, Integer> playCountByGenre = musics.stream()
            .collect(groupingBy(Music::getGenre, summingInt(Music::getPlays)));

        List<String> genresOrderedByPlayCount = playCountByGenre.entrySet().stream()
            .sorted(comparingByValue(reverseOrder()))
            .map(Entry::getKey)
            .collect(toList());

        List<Integer> result = genresOrderedByPlayCount.stream()
            .flatMap(genre -> musicsByGenre.get(genre).stream()
                .sorted().limit(2).map(Music::getId))
            .collect(toList());

        //* convert List to Array
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
