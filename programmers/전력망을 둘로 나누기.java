// https://school.programmers.co.kr/learn/courses/30/lessons/86971

import java.util.*;

class Point {
    int x; int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        int[][] connected = new int[n+1][n+1];
        
        for (int i=0 ; i<wires.length ; i++) {
            connected[wires[i][0]][wires[i][1]] = 1;
            connected[wires[i][1]][wires[i][0]] = 1;
        }
        
        for (int i=0 ; i<wires.length ; i++) {
            connected[wires[i][0]][wires[i][1]] = 0;
            connected[wires[i][1]][wires[i][0]] = 0;
            
            int nextIndex = i+1 == wires.length ? 0 : i+1;
            int count = bfs(wires[nextIndex], connected);
            answer = Math.min(answer, Math.abs(n-count-count));
            
            connected[wires[i][0]][wires[i][1]] = 1;
            connected[wires[i][1]][wires[i][0]] = 1;
        }
        
        return answer;
    }
    
    
    public int bfs(int[] firstPoint, int[][] connected) {
        int point = 2;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(firstPoint[0], firstPoint[1]));
        boolean[] visited = new boolean[connected.length];
        
        visited[firstPoint[0]] = true;
        visited[firstPoint[1]] = true;
        
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
    
            for (int i=1 ; i<connected.length ; i++) {
                if (visited[i]) continue;
                
                if (connected[i][currentPoint.x] == 1 || connected[currentPoint.x][i] == 1) {
                    visited[i] = true;
                    queue.offer(new Point(i, currentPoint.x));
                    point++;
                } else if (connected[i][currentPoint.y] == 1 || connected[currentPoint.y][i] == 1) {
                    visited[i] = true;
                    queue.offer(new Point(i, currentPoint.y));
                    point++;
                }
            }
                    
        }
        
        return point;
    }
}
