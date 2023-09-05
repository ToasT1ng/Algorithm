// https://school.programmers.co.kr/learn/courses/30/lessons/43163

class Solution {
    int answer = 100;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(0, 0, begin, target, words, visited);
        
        return answer == 100 ? 0 : answer;
    }
    
    public void dfs(int index, int number, String current, String target, String[] words, boolean[] visited) {
        if (current.equals(target)) {
            answer = Math.min(answer, number);
            return;
        }
        
        if (index > words.length-1) {
            return;
        }
        
        for (int i=0 ; i<words.length ; i++) {
            if (!visited[i] && checkAbleToChange(current, words[i])) {
                visited[i] = true;
                
                dfs(i, number+1, words[i], target, words, visited);
                
                visited[i] = false;
            }
        }
    }
    
    public boolean checkAbleToChange(String currentString, String changeString) {
        int count = 0;
        for (int i=0 ; i<currentString.length() ; i++) {
            if (currentString.charAt(i) != changeString.charAt(i)) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }
        return true;
        
    }
}
