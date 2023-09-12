// https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;

class Route implements Comparable<Route>{
    int start; int end;
    Route(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "{start=" + start + ", end=" + end + "}";
    }
    
    @Override
    public int compareTo(Route target) {
        if (this.end > target.end) return 1;
        else if (this.end < target.end) return -1;
        else return 0;
    }
}


class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        boolean[] visited = new boolean[routes.length];
        List<Route> list = new ArrayList<>();
        for (int[] route : routes) {
            list.add(new Route(route[0],route[1]));
        }
        Collections.sort(list);
        
        for (int i=0 ; i<list.size() ; i++) {
            if (visited[i]) continue;
            answer++;
            visited[i] = true;
            int cameraPos = list.get(i).end;
            for (int j=i+1 ; j<routes.length ; j++) {
                if (visited[j]) continue;
                if (list.get(j).start <= cameraPos && cameraPos <= list.get(j).end) visited[j] = true;
            }
        }
        return answer;
    }
}
