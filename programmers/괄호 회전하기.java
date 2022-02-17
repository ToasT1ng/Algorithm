import java.util.*;
        
    
class Solution {
    public int solution(String s) {
        int answer = 0;
        int loop = s.length();
        String temp = s;
        while(loop > 0) {
            char firstChar = temp.charAt(0);
            temp = temp.substring(1, s.length()) + Character.toString(firstChar);
            if (isCorrect(temp)) {
                answer++;
            }
            loop--;
        }
        return answer;
    }
    
    Map<Character, Character> bracketMap = new HashMap<>() {{
        put('(' , ')');
        put('{' , '}');
        put('[' , ']');
    }};
    
    public boolean isCorrect(String st) {    
        Stack<Character> stack = new Stack<>();
        for (int i=0 ; i<st.length() ; i++) {
            char currentChar = st.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (!stack.isEmpty()) {
                    if (bracketMap.getOrDefault(stack.peek(), '1') == currentChar) {
                        stack.pop();
                    } 
                } else {
                    stack.push(currentChar);
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
