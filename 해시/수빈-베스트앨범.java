import java.util.*;

class Solution {
    
    static class Music{
        String genre;
        int play;
        int idx;
        
        public Music(String genre, int play, int idx){
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> hm = new HashMap<>();
        
        // genre, 총 재생 횟수
        for(int i=0; i<genres.length; i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        // 재생 횟수 내림차순 정렬
        List<String> keySetList = new ArrayList<>(hm.keySet());
        Collections.sort(keySetList, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));
        
        // 정렬된 장르 순서대로 배열의 장르와 비교
        // 같다면 music 생성 후 list에 저장, 내림차순 정렬
        // 최대 2개까지 playlist에 추가
        ArrayList<Music> playlist = new ArrayList<>();
        for(String genre : keySetList){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(genre)){
                    list.add(new Music(genre, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            
            playlist.add(list.get(0));
            if(list.size()>1) {
                playlist.add(list.get(1));
            }
        }
        
        // music에서 idx값 answer에 추가
        int[] answer = new int[playlist.size()];
        for(int i=0; i<playlist.size(); i++){
            answer[i] = playlist.get(i).idx;
        }
        return answer;
    }
}
