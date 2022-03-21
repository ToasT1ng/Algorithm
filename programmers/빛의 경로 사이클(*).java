// https://programmers.co.kr/learn/courses/30/lessons/86052
import java.util.*;

class Solution {
    int x = 0;
    int y = 0;
    public int[] solution(String[] grid) {
        ArrayList<Integer> list = new ArrayList<>();
        x = grid.length;
        y = grid[0].length();
        boolean visited[][][] = new boolean[x][y][4];
        for (int i=0 ; i<grid.length ; i++) {
            for (int j=0 ; j<grid[0].length(); j++) {
                for (int k=0 ; k<4 ; k++) {
                    if (!visited[i][j][k]) {
                        list.add(cycle(grid, visited, i, j, k));
                    }
                }
            }
        }
        Collections.sort(list);
        return list.stream().mapToInt(i->i).toArray();
    }
    
    int[] nx = {1,0,-1,0};
    int[] ny = {0,1,0,-1};
    
    public int cycle(String[] grid, boolean visited[][][], int i, int j, int k) {
        int count = 0;
        
        while (!visited[i][j][k]) {
            count++;
            visited[i][j][k] = true;
            if (grid[i].charAt(j) == 'L') {
                k = (k+3) % 4;
            } else if (grid[i].charAt(j) == 'R') {
                k = (k+1) % 4;
            } 
            i = (i+nx[k] + x) % x;
            j = (j+ny[k] + y) % y;
        }
        return count;
    }
}
