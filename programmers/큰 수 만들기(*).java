// https://programmers.co.kr/learn/courses/30/lessons/42883#

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        // 순차적으로 돌면서 stack 에 쌓는데, Peek이 현재꺼보다 작으면 클때까지 계속 pop 하고 넣는다. 
        // 이 때, k를 빼주는 이유는 전체 갯수에서 pop 되는 숫자들의 갯수를 빼주기 때문이다.
        for (int i=0 ; i<number.length() ; i++) {
            char current = number.charAt(i);
            while (!stack.isEmpty() && current > stack.peek()) {
                k--;
                if (k >= 0) stack.pop();
                else break;
            }
            stack.push(current);
        }
        // 마지막에 혹시 k가 양수일 경우, 숫자를 다 제거하지 않은 것이므로 제거해준다.
        while (k > 0) {
            k--;
            stack.pop();
        }
        for (Character each : stack) {
            answer += String.valueOf(each);
        }
        return answer;
    }
}
