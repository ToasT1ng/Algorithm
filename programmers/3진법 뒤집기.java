import java.util.*;

class Solution {
    public int solution(int n) {
        String answerString = "";
        while (n >= 1) {
            answerString += n%3;
            n = n/3;
        }
        
        return Integer.parseInt(answerString, 3);
    }
    
    public int oldAnswer(int n) {
        int answer = 0;
        
        // Stack 을 써서 3진법 계산, 수를 넣고
        // 빼면서 계산 3진법으로 계산
        Stack<Integer> stack = new Stack<>();
        
        while (n >= 1) {
            stack.push(n%3);
            n = n/3;
        }
        
        int i=0;
        while (!stack.isEmpty()) {
            answer += Math.pow(3, i) * stack.pop();
            i++;
        }
        
        return answer;
    }
}
