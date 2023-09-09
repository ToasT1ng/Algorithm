// https://school.programmers.co.kr/learn/courses/30/lessons/43163

class Solution {
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        answer = words.length+1;
        
        dfs(0, begin, 0, new boolean[words.length], target, words);
        
        return answer == words.length+1 ? 0 : answer;
    }
    
    public void dfs(int index, String current, int count, boolean[] visited, String target, String[] words) {
        if (current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        if (index >= words.length) return;
        
        for (int i=0 ; i<words.length ; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            if (isChangable(current, words[i])) dfs(index+1, words[i], count+1, visited, target, words);
            visited[i] = false;
        }
    }
    
    public boolean isChangable(String input, String target) {
        int count = 0;
        for (int i=0 ; i<input.length() ; i++) {
            if (input.charAt(i) != target.charAt(i)) count++;
            if (count >= 2) return false;
        }
        return true;
    }
}
