// https://school.programmers.co.kr/learn/courses/30/lessons/84512

import java.util.*;

class Solution {
    List<String> wordList = new ArrayList<>();
    
    public int solution(String word) {
        dfs("AEIOU", 0, "");
        for (int i=1 ; i<wordList.size() ; i++) {
            if (wordList.get(i).equals(word)) return i;
        }
        
        return 0;
    }
    
    void dfs(String alphabet, int index, String result) {
        wordList.add(result);
        if (index == alphabet.length()) {
            return;
        }
        
        for (int i=0 ; i<alphabet.length() ; i++) {
            dfs(alphabet, index+1, result += alphabet.charAt(i));
            result = result.substring(0, result.length()-1);
        }
    }
}
