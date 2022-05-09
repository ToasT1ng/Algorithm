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


// 22 05 09
// import java.util.*;

// class Solution {
// 	Set<Integer> set = new HashSet<>();
// 	public int solution(String numbers) {
// 		dfs(0, numbers, new boolean[numbers.length()], "");	
// 		return set.size();
// 	}

// 	public void dfs(int pos, String numbers, boolean[] visited, String result) {
// 		if (pos >= numbers.length()) {
// 			return;
// 		}
// 		for (int i=0 ; i<numbers.length() ; i++) {
// 			if (!visited[i]) {
// 				visited[i] = true;
// 				int currentResultLength = result.length();
// 				result += String.valueOf(numbers.charAt(i));
//                 int resultInt = Integer.parseInt(result);
// 			    if (isPrime(resultInt))  {
//                     set.add(resultInt);
//                 }
// 				dfs(pos+1, numbers, visited, result);
// 				result = result.substring(0, currentResultLength);
// 				visited[i] = false;
// 			}
// 		}
// 	}

// 	public boolean isPrime(int value) {
// 		if (value <= 1) {
// 			return false;
// 		}
//         if (value == 1) {
// 			return true;
// 		}
// 		for (int i=2 ; i*i<=value ; i++) {
// 			if (value % i == 0) return false;
// 		}
// 		return true;
// 	}
// }
