// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.*;

class Solution {
    boolean solution(String s) {
        if (s.charAt(0) == ')') return false;
        if (s.length() % 2 != 0) return false;
        
        int openBracket = 0;
        int closeBracket = 0;
        
        for (char eachChar : s.toCharArray()) {
            if (eachChar == '(') {
                openBracket++;
            } else {
                closeBracket++;
            }     
            
            if (closeBracket > openBracket) {
                return false;
            }
        }

        return openBracket == closeBracket;
    }
}
