// https://programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Node {
    int x;
    int y;
    int result;
    
    public Node(int x, int y, int result) {
        this.x = x;
        this.y = y;
        this.result = result;
    }
}

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    
    public int solution(int[][] maps) {
        // 제일 먼저 상대팀 진영에 도착할 수 있는지 확인
        // 도착할 수 없으면 바로 -1을 return
        // 도착할 수 있다면 bfs 를 사용해서 counting
        
        if (isBlocked(maps)) return -1;
        
        return bfs(new Node(0, 0, 1), maps, new boolean[maps.length][maps[0].length]);
    }
    
    public boolean isBlocked(int[][] maps) {
        int x = maps.length - 1;
        int y = maps[x].length - 1;
        if (x >= 1 && y >= 1 && maps[x][y-1] == 0 && maps[x-1][y] == 0) {
            return true;
        }
        
        return false;
    }
    
    public int bfs(Node firstNode, int[][] maps, boolean[][] visited) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.add(firstNode);
        visited[firstNode.x][firstNode.y] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                return node.result;
            }
            for (int i=0 ; i<4 ; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                if (nextX < n && nextX >= 0 && nextY < m && nextY >= 0) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new Node(nextX, nextY, node.result+1));
                    }
                }
            }
        }
        return -1;
    }
    
    
}
