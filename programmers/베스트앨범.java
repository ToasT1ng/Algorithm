// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;

class PlayTime implements Comparable<PlayTime>{
    int songNumber;
    int count;
    
    PlayTime (int songNumber, int count) {
        this.songNumber = songNumber;
        this.count = count;
    }
    
    @Override
    public int compareTo(PlayTime a) {
        return a.count - this.count;
    }
    
    @Override
    public String toString() {
        return "number=" + songNumber + ",count=" + count;
    }
}

class GenrePlayTime implements Comparable<GenrePlayTime>{
    String genreName;
    int count;
    
    GenrePlayTime (String genreName, int count) {
        this.genreName = genreName;
        this.count = count;
    }
    
    @Override
    public int compareTo(GenrePlayTime a) {
        return a.count - this.count;
    }
    
    @Override
    public String toString() {
        return "name=" + genreName + ",count=" + count;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();
        Map<String, List<PlayTime>> genreSongMap = new HashMap<>();
        Map<String, Integer> genreCountMap = new HashMap<>();
        for (int i=0 ; i<genres.length ; i++) {
            genreCountMap.put(genres[i], genreCountMap.getOrDefault(genres[i], 0) + plays[i]);
            List<PlayTime> list = genreSongMap.getOrDefault(genres[i], new ArrayList<>());
            list.add(new PlayTime(i, plays[i]));
            genreSongMap.put(genres[i], list);
        }
        
        List<GenrePlayTime> genreList = new ArrayList<>();
        for (String key : genreCountMap.keySet()) {
            genreList.add(new GenrePlayTime(key, genreCountMap.get(key)));
        }
        Collections.sort(genreList);
        
        for (GenrePlayTime genrePlayTime : genreList) {
            List<PlayTime> playTimeList = genreSongMap.get(genrePlayTime.genreName);
            Collections.sort(playTimeList);
            for (int i=0 ; i<2 && i<playTimeList.size() ; i++) {
                result.add(playTimeList.get(i).songNumber);
            }
        }
        
        
        int[] answer = new int[result.size()];
        for (int i=0 ; i<result.size() ; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
