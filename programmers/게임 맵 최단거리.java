// https://programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Point {
    int x; int y; int result;
    
    Point(int x, int y, int result) {
        this.x = x;
        this.y = y;
        this.result = result;
    }
    
    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", result=" + result;
    }
}


class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        int[] nextXArray = {0,0,1,-1};
        int[] nextYArray = {1,-1,0,0};
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 제일 먼저 나오는게 최단거리!
            if (current.x == n-1 && current.y == m-1) return current.result;
            
            for (int i=0 ; i<4 ; i++) {
                int nextX = current.x + nextXArray[i];
                int nextY = current.y + nextYArray[i];
                
                if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0 || visited[nextX][nextY]) continue;
                
                visited[nextX][nextY] = true;
                
                if (maps[nextX][nextY] == 1) {    
                    queue.offer(new Point(nextX, nextY, current.result+1));
                }
            }
        }
        return -1;
    }
}
