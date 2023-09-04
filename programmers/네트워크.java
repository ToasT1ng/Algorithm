// https://school.programmers.co.kr/learn/courses/30/lessons/43162#

class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] computers) {    
        boolean[] visited = new boolean[n];
        
        for (int i=0 ; i<n ; i++) {
            visited[i] = false;
        }
        
        for (int i=0 ; i<n ; i++) {
            if (!visited[i]) {
                answer++;
                visited[i] = true;
                dfs(i, computers, visited);
            }
        }
        
        return answer;
    }
    
    public void dfs(int currentComputer, int[][] computers, boolean[] visited) {
        for (int i=0 ; i<computers.length ; i++) {
            if (!visited[i] && computers[currentComputer][i] == 1) {
                visited[i] = true;
                dfs(i, computers, visited);
            }
        }
    }
}
