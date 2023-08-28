// https://school.programmers.co.kr/learn/courses/30/lessons/154540

import java.util.*;

class Point {
    int i; int j;
    
    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
    @Override
    public String toString() {
        return "i=" + i + ", j=" + j;
    }
}

class Solution {
    public int[] solution(String[] maps) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int i=0 ; i<maps.length ; i++) {
            for (int j=0 ; j<maps[i].length() ; j++) {
                if (visited[i][j]) continue;
                
                visited[i][j] = true;
                
                if (maps[i].charAt(j) == 'X') continue;
                
                int tempFood = bfs(maps, i, j, visited);
                answerList.add(tempFood);
            }
        }
        
        if (answerList.isEmpty()) answerList.add(-1);
        
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        for (int i=0 ; i<answerList.size() ; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public int bfs(String[] maps, int i, int j, boolean[][] visited) {
        int[] nextIPoint = {1,-1,0,0};
        int[] nextJPoint = {0,0,1,-1};
        
        Point firstPoint = new Point(i, j);
        visited[i][j] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(firstPoint);
        
        int currentFood = 0;
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            currentFood += maps[currentPoint.i].charAt(currentPoint.j) - '0';
            
            for (int a=0 ; a<nextIPoint.length ; a++) {
                int nextI = currentPoint.i + nextIPoint[a];
                int nextJ = currentPoint.j + nextJPoint[a];
                
                if (nextI >= maps.length || nextI < 0 || nextJ >= maps[i].length() || nextJ < 0 || visited[nextI][nextJ]) {
                    continue;
                }
                
                visited[nextI][nextJ] = true;
                
                if (maps[nextI].charAt(nextJ) == 'X') continue;
                
                queue.offer(new Point(nextI, nextJ));
            }
        }
        return currentFood;
    }
}
