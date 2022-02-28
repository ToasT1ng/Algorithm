import java.util.*;

class Solution {
    List<Integer> answerList = new ArrayList<>();
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] array = new int[rows][columns];
        for (int i=0 ; i<rows ; i++) {
            for (int j=0 ; j<columns ; j++) {
                array[i][j] = (j+1) + i * columns;
            }
        }
        
        for (int[] query : queries) {
            array = doRotate(array, query);
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
    
    
    // 1. 첫번째 행과 같은 행일 경우, 오른쪽으로 이동하다가 마지막 열과 같은 열일 때 아래로 이동
    // 2. 마지막 열과 같은 열일 경우, 아래로 이동하다가 마지막 행과 같은 행일때 왼쪽으로 이동
    // 3. 마지막 행과 같은 행일 경우, 왼쪽으로 이동하다가 첫번째 열과 같은 열일 때 위로 이동
    // 4. 첫번째 열과 같은 열일 경우, 위로 이동하다가 첫번째 행과 같은 행일때 끝
    public int[][] doRotate(int[][] array, int[] query) {
        int firstRow = query[0] - 1; int firstColumn = query[1] - 1;
        int lastRow = query[2] - 1; int lastColumn = query[3] - 1;
        int currentRow = firstRow;
        int currentColumn = firstColumn + 1;
        int lowValue = array[currentRow][currentColumn];
        int lastValue = array[currentRow][currentColumn-1];
        int currentValue = 0;
        
        while(true) {
            currentValue = array[currentRow][currentColumn];
            array[currentRow][currentColumn] = lastValue;
            lastValue = currentValue;
            
            if (currentValue < lowValue) lowValue = currentValue;
            
            if (currentRow == firstRow && currentColumn == firstColumn) {
                break;
            }
            if (currentRow == firstRow) {
                if (currentColumn < lastColumn) currentColumn++;
                else currentRow++;
                continue;
            }
            if (currentColumn == lastColumn) {
                if (currentRow < lastRow) currentRow++;
                else currentColumn--; 
                continue;
            }
            if (currentRow == lastRow){
                if (currentColumn > firstColumn) currentColumn--;
                else currentRow--;
                continue;
            }
            if (currentColumn == firstColumn){
                if (currentRow > firstRow) currentRow--;
                else break;
                continue;
                
            }
        }
        answerList.add(lowValue);
        return array;
    }
}
