// https://programmers.co.kr/learn/courses/30/lessons/17679

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
        // for (int i=0 ; i<m ; i++) {
        //     for (int j=0 ; j<n ; j++) {
        //         System.out.print(boardChar[i][j]);
        //     }
        //     System.out.println();
        // }
        return answer;
    }
    
    public void catchBlocks(boolean[][] visited, char[][] boardChar) {
        for (int i=0 ; i<visited.length ; i++) {
            for (int j=0 ; j<visited[i].length ; j++) {
                if (isAbleToGetChar(i,j,visited.length,visited[i].length)) {
                    char currentChar = boardChar[i][j];
                    if (Character.compare(currentChar, ' ') == 0) continue;
                    char right = boardChar[i+nextI[0]][j+nextJ[0]];
                    char down = boardChar[i+nextI[1]][j+nextJ[1]];
                    char cross = boardChar[i+nextI[2]][j+nextJ[2]];
                    if (Character.compare(currentChar, right) == 0 && Character.compare(currentChar, down) == 0 
                        && Character.compare(currentChar, cross) == 0) {
                        visited[i][j] = true;
                        visited[i+nextI[0]][j+nextJ[0]] = true;
                        visited[i+nextI[1]][j+nextJ[1]] = true;
                        visited[i+nextI[2]][j+nextJ[2]] = true;
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
        for (int i=0 ; i<visited.length ; i++) {
            for (int j=0 ; j<visited[i].length ; j++) {
                if (visited[i][j]) boardChar[i][j] = ' ';
            }
        }
        
        int erasingBlocks = 0;
        for (int i = visited.length-1 ; i>=0 ; i--) {
            for (int j = visited[i].length-1 ; j>=0 ; j--) {
                if (visited[i][j]) {
                    int firstEmpty = i;
                    int firstFriends = i;
                    for ( ; firstFriends >= 0 && visited[firstFriends][j] ; firstFriends--) { 
                        visited[firstFriends][j] = false;
                        erasingBlocks++;
                    }
                    for ( ; firstFriends >= 0 && firstEmpty > firstFriends; firstFriends--, firstEmpty--) {
                        char friends = boardChar[firstFriends][j];
                        if (Character.compare(friends, ' ') == 0) firstFriends++;
                        boardChar[firstFriends][j] = boardChar[firstEmpty][j];
                        boardChar[firstEmpty][j] = friends;
                    }
                }
            }
        }
        return erasingBlocks;
    }
    
    // AA
    // A
    // CC
    // A
    // A
    // DC
    
    
}
