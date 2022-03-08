class Solution {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int oneAreaSize = 0;
    boolean[][] visited;
    
    public void dfs(int row, int column, int[][] picture) {
        if (visited[row][column]) {
            return;
        }
        
        oneAreaSize++;
        int currentColor = picture[row][column];
        visited[row][column] = true;
        
        if (row-1 >= 0) {
            if (picture[row-1][column] == currentColor && !visited[row-1][column]) {
                dfs(row-1, column, picture);  
            }
            
        }
        if (column-1 >= 0) {
            if (picture[row][column-1] == currentColor && !visited[row][column-1]) {
                dfs(row, column-1, picture);  
            }
            
        }
        if (row+1 < picture.length) {
            if (picture[row+1][column] == currentColor && !visited[row+1][column]) {
                dfs(row+1, column, picture);  
            }
            
        }
        if (column+1 < picture[0].length) {
            if (picture[row][column+1] == currentColor && !visited[row][column+1]) {
                dfs(row, column+1, picture);  
            }
            
        }
              
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    dfs(i, j, picture);
                }
                if (oneAreaSize > maxSizeOfOneArea) {
                    maxSizeOfOneArea = oneAreaSize;
                }
                oneAreaSize = 0;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
