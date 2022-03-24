import java.util.*;

class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordinate toLeft() {
        return new Coordinate(this.x, this.y-1);
    }
    
    public Coordinate toRight() {
        return new Coordinate(this.x, this.y+1);
    }
    
    public Coordinate toDown() {
        return new Coordinate(this.x+1, this.y);
    }
    
    public Coordinate toUp() {
        return new Coordinate(this.x-1, this.y);
    }
    
    public String toString() {
        return "{x=" + this.x + ",y=" + this.y + "}";
    }
}

class Solution {
    List<Integer> list = new ArrayList<>();
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        for (int i=0 ; i<rows ; i++) {
            for (int j=0 ; j<columns ; j++) {
                matrix[i][j] = i*columns + j + 1;
            }
        }
        
        for (int[] eachQuery : queries) {
            rotate(matrix, eachQuery);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public void rotate(int[][] matrix, int[] eachQuery) {
        Coordinate startCoord = new Coordinate(eachQuery[0]-1, eachQuery[1]-1);
        Coordinate edgeCoord = new Coordinate(eachQuery[2]-1, eachQuery[3]-1);
        
        Coordinate currentCoord = new Coordinate(startCoord.x, startCoord.y);
        Coordinate beforeCoord = currentCoord.toDown();
            
        int currentNum = 0;
        int beforeNum = matrix[beforeCoord.x][beforeCoord.y];
        int lowValue = beforeNum;
        
        while (true) {
            currentNum = matrix[currentCoord.x][currentCoord.y];
            lowValue = Math.min(currentNum, lowValue);
            matrix[currentCoord.x][currentCoord.y] = beforeNum;
            beforeNum = currentNum;        
                
            if (currentCoord.x == startCoord.x && currentCoord.y < edgeCoord.y) {
                currentCoord = currentCoord.toRight();
                    
            } else if (currentCoord.x < edgeCoord.x && currentCoord.y == edgeCoord.y) {
                currentCoord = currentCoord.toDown();
                    
            } else if (currentCoord.x == edgeCoord.x && currentCoord.y > startCoord.y) {
                currentCoord = currentCoord.toLeft();
                    
            } else {
                currentCoord = currentCoord.toUp();
            }
                
            if (currentCoord.x == startCoord.x && currentCoord.y == startCoord.y) break;
        }
        list.add(lowValue);
    }
}
