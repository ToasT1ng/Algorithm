// https://programmers.co.kr/learn/courses/30/lessons/42839#

import java.util.*;

class Solution {
    Set<Integer> resultSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        dfs(0, numbers, "", visited);
        return resultSet.size();
    }
    
    public void dfs(int index, String numbers, String currentString, boolean[] visited) {
        if (index > numbers.length()) {
            return;
        }
        
        
        for (int i=0 ; i<numbers.length() ; i++) {  
            if (!visited[i]) {
                currentString += numbers.charAt(i);
                visited[i] = true;
                
                int currentInt = Integer.parseInt(currentString);
                if (isPrimitive(currentInt)) {
                    resultSet.add(currentInt);
                }

                dfs(index+1, numbers, currentString, visited);   

                currentString = currentString.substring(0, currentString.length()-1);
                visited[i] = false;
            }
            
        }
    }
    
    public boolean isPrimitive(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i=2 ; i*i<=number ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
