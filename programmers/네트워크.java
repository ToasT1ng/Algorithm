// https://school.programmers.co.kr/learn/courses/30/lessons/43162#

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i=0 ; i<n ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, computers, visited);
            }
            
        }
        
        return answer;
    }
    
    public void dfs(int index, int[][] computers, boolean[] visited) {
        for (int i=0 ; i<visited.length ; i++) {
            if (visited[i]) continue;
            
            if (computers[i][index] == 1) {
                visited[i] = true;
                dfs(i, computers, visited);
            }
        }
    }
}
