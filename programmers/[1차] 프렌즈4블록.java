// https://programmers.co.kr/learn/courses/30/lessons/17679
// Test Case 10
// 6 6 ["AABBEE", "AAAEEE", "VAAEEV", "AABBEE", "AACCEE", "VVCCEE"] // 32

import java.util.*;

class Solution {
    int[] nextI = {0,1,1};
    int[] nextJ = {1,0,1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;    
        boolean[][] visited = new boolean[m][n];
        char[][] boardChar = new char[m][n];
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                boardChar[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            catchBlocks(visited, boardChar);
            int tempAns = eraseBlocks(visited, boardChar);
            answer += tempAns;
            if (tempAns == 0) break; 
            
        }
        return answer;
    }
    
    public void catchBlocks(boolean[][] visited, char[][] boardChar) {
        for (int i=0 ; i<visited.length ; i++) {
            for (int j=0 ; j<visited[i].length ; j++) {
                if (isAbleToGetChar(i,j,visited.length,visited[i].length)) {
                    boolean flag = true;
                    char currentChar = boardChar[i][j];
                    if (Character.compare(currentChar, '0') == 0 || Character.isLowerCase(currentChar)) continue;
                    for (int index = 0 ; index<3 ; index++) {
                        char current = boardChar[i+nextI[index]][j+nextJ[index]];
                        if (Character.compare(currentChar, current) != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        visited[i][j] = true;
                        for (int index = 0 ; index<3 ; index++) {
                            visited[i+nextI[index]][j+nextJ[index]] = true;
                        }
                    }
                }
            }
        }
    }
    
    public boolean isAbleToGetChar(int i, int j, int m, int n) {
        for (int index = 0 ; index<3 ; index++) {
            if (i+nextI[index] >= 0 && i+nextI[index] < m && j+nextJ[index] >= 0 && j+nextJ[index] < n) continue;
            else return false;
        }
        return true;
    }
    
    public int eraseBlocks(boolean[][] visited, char[][] boardChar) {
        int erasingBlocks = 0;
        for (int i=0 ; i<visited.length ; i++) {
            for (int j=0 ; j<visited[i].length ; j++) {
                if (visited[i][j]) {
                    erasingBlocks++;
                    visited[i][j] = false;
                    for (int k = i-1; k >= 0; k--) {
                        boardChar[k+1][j] = boardChar[k][j];
                        boardChar[k][j] = '0';
                    }
                }
            }
        }
        
        return erasingBlocks;
    }
}
