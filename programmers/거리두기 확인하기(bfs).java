import java.util.*;

class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "{x=" + x + ",y=" + y + "}";
    }

}


class Solution {
    public int[] solution(String[][] places) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (String[] each : places) {
            answer.add(check(each));
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    int[] nx = {1,0,-1,0};
    int[] ny = {0,1,0,-1};

    public int check(String[] eachPlace) {
        int xLength = eachPlace[0].length();
        int yLength = eachPlace.length;
        for (int i=0 ; i<xLength ; i++) {
            for (int j=0 ; j<yLength ; j++) {
                if (isPerson(eachPlace, new Coordinate(i, j))) {
                    if (!bfs(new boolean[xLength][yLength], eachPlace, i, j)) return 0;
                }
            }
        }
        return 1;
    }

    public boolean bfs(boolean[][] visited, String[] eachPlace, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate firstCoord = new Coordinate(x,y);
        queue.offer(firstCoord);
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int i=0 ; i<4 ; i++) {
                int nextX = current.x + nx[i];
                int nextY = current.y + ny[i];
                Coordinate nextCoordinate = new Coordinate(nextX, nextY);
                int distance = getDistance(firstCoord, nextCoordinate);
                if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5 || visited[nextX][nextY] || distance > 2) {
                    continue;
                }
                
                visited[nextX][nextY] = true;
                
                if (isPerson(eachPlace, nextCoordinate)) {
                    return false; 
                } else if (isTable(eachPlace, nextCoordinate)) {
                    queue.offer(nextCoordinate);
                }
            }
        }
        return true;
    }
    
    public boolean isPerson(String[] eachPlace, Coordinate next) {
        return eachPlace[next.x].charAt(next.y) == 'P'? true : false;
    }
    
    public boolean isTable(String[] eachPlace, Coordinate next) {
        return eachPlace[next.x].charAt(next.y) == 'O'? true : false;
    }
    
    public int getDistance(Coordinate c1, Coordinate c2) {
        return Math.abs(c1.x-c2.x) + Math.abs(c1.y-c2.y);
    }

}
