import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for (char currentChar : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == currentChar) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
    
   
}
