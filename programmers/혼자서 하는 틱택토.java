// https://school.programmers.co.kr/learn/courses/30/lessons/160585#

class Solution {
    public int solution(String[] board) {
        int answer = 1;
       
        boolean firstWin = false;
        boolean secondWin = false;
        int numberOfFirst = 0;
        int numberOfSecond = 0;
        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<3 ; j++) {
                if (board[i].charAt(j) == '.') continue;
                if (board[i].charAt(j) == 'O') {
                    numberOfFirst++;
                    if (firstWin == false && isAlreadyEnd(i, j, board)) firstWin = true;   
                }
                
                if (board[i].charAt(j) == 'X') {
                    numberOfSecond++;
                    if (secondWin == false && isAlreadyEnd(i, j, board)) secondWin = true;
                }
            }
        }
        
        int differ = numberOfFirst-numberOfSecond;
        
        if (numberOfFirst == 0 && numberOfSecond == 0) return 1;
        if (differ > 1 || differ < 0) return 0;
        if (firstWin && secondWin) return 0;
        if (differ == 0 && firstWin) return 0;
        if (differ == 1 && secondWin) return 0;
        
        return answer;
    }
    
    public boolean isAlreadyEnd(int x, int y, String[] board) {
        char character = board[x].charAt(y);
        
        int width = 0;
        int cross = 0;
        int reverseCross = 0;
        int height = 0;
        for (int i=0 ; i<3 ; i++) {
            if (board[i].charAt(y) == character) width++;
            if (x == y && board[i].charAt(i) == character) cross++;
            if (x + y == 2 && board[i].charAt(2-i) == character) reverseCross++;
            if (board[x].charAt(i) == character) height++;
        }
        
        if (width == 3 || cross == 3 || height == 3 || reverseCross == 3) return true;
        else return false;
    }
}
