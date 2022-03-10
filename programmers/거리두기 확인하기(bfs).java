import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i=0 ; i<places.length ; i++) {
            int isOkay = 1;
            for (int x=0 ; x<places[i].length ; x++) {
                String[] currentRoom = places[i];
                for (int y=0 ; y<currentRoom[x].length() ; y++) {
                    if (isPerson(currentRoom, x, y) ) {
                        if (!check(currentRoom, x, y)) {
                            isOkay = 0;
                            break;
                        }
                        
                    }
                }
                if (isOkay == 0) {
                    break;
                }
            }
            answer[i] = isOkay;
        }
        return answer;
    }
    
    int[] xPos = {-1,1,0,0};
    int[] yPos = {0,0,-1,1};
    

    public boolean check(String[] currentRoom, int firstX, int firstY) {
        boolean[][] visited =  new boolean[5][5];
        Queue<Coordinate> coordQueue = new LinkedList<>();
        coordQueue.offer(new Coordinate(firstX, firstY));
        visited[firstX][firstY] = true;
        
        while (!coordQueue.isEmpty()) {
            Coordinate currentCoord = coordQueue.poll();
        
            for (int i=0 ; i<4 ; i++) {   
                int nextX = currentCoord.x + xPos[i];
                int nextY = currentCoord.y + yPos[i];
                int distance = Math.abs(firstX - nextX) + Math.abs(firstY - nextY);
                if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5 || visited[nextX][nextY] || distance > 2) {
                    continue;
                }
                
                visited[nextX][nextY] = true;
                
                if (isPartition(currentRoom, nextX, nextY)) {
                    continue;
                }
                if (isPerson(currentRoom, nextX, nextY)) {
                    return false;
                }
                if (isTable(currentRoom, nextX, nextY)) {
                    coordQueue.offer(new Coordinate(nextX, nextY));
                }
            }
        }
        
        
        return true;
    }
    
    private class Coordinate {
        public int x;
        public int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private boolean isPerson(String[] currentRoom, int x, int y) {
        return isThis(currentRoom[x].charAt(y), 'P');
    }

    
    private boolean isThis(char character, char compareCharacter) {
        if (character == compareCharacter) {
            return true;
        } else {
            return false;
        }
    }
    
    
    private boolean isPartition(String[] currentRoom, int x, int y) {
        return isThis(currentRoom[x].charAt(y), 'X');
    }
    
    private boolean isTable(String[] currentRoom, int x, int y) {
        return isThis(currentRoom[x].charAt(y), 'O');
    }
}
