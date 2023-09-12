// https://school.programmers.co.kr/learn/courses/30/lessons/12952#

class Solution {
    int answer = 0;
    public int solution(int n) {
        // if (n==1) return 1;
        // else if (n<4) return 0;
        
        int[] queens = new int[n];
        
        dfs(0, queens);
        
        return answer;
    }  
    
    public void dfs(int index, int[] queens) {
        if (index == queens.length) {
            answer++;
            return;
        }
        for (int i=0 ; i<queens.length ; i++) {
            queens[index] = i;
            if (check(index, queens)) dfs(index+1, queens);
        }
    }
    
    public boolean check(int index, int[] queens) {
        for (int i=0 ; i<index ; i++) {
            if (queens[i] == queens[index]) return false;
            if (Math.abs(i - index) == Math.abs(queens[i] - queens[index])) return false;
        }
        return true;
    }
}
