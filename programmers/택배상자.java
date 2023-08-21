// https://school.programmers.co.kr/learn/courses/30/lessons/131704?language=java#

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int orderIndex = 0;
        for (int currentBoxNumber=1 ; currentBoxNumber<=order.length ; currentBoxNumber++) {
            if (currentBoxNumber == order[orderIndex]) {
                answer++;
                orderIndex++;
            } else {
                stack.push(currentBoxNumber); 
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek() == order[orderIndex]) {
                stack.pop();
                answer++;
                orderIndex++;
            } 
                
        }
        return answer;
    }
    
    /// 한번 쌓기 시작하면 그 이후 막힐 경우 Stop
    /// 쌓기 전에는 괜찮음
    
    /// order [1,2,3,4,5] result 5
    /// order [3,2,1,4,5] result 5
    
    
    /// 만약 stack 이 비어있다면, order[i] 에 도달할 때까지 쌓을 수 있습니다.
    /// 이 때, 가상 queue 의 번호를 (currentBoxNumber) 기억해둡니다.
    /// 다음 번호는 nextBoxNumber 입니다.
    /// currentBoxNumber는 실을 수 있으므로 answer++ 해줍니다.
    
    /// stack이 비어있지 않고 currentBoxNumber와 order[i]가 일치하게 된다면 아래의 스텝을 진행합니다.
    
    /// stack의 최상단의 boxNumber 혹은 nextBoxNumber 가 order[i+1] 와 일치하는지 확인합니다.
    /// 만약 어느 것과도 일치 하지 않으면 끝냅니다.
    /// 만약 stack과 일치하면 더 이상 일치하지 않을 때까지 pop 해주고, nextBoxNumber도 바꿔줍니다.
    /// 만약 nextBoxNumber와 일치하면 더 이상 일치하지 않을 때까지 바꿔줍니다.
    /// 위의 두가지 경우 모두 order[i++] 해주어야합니다.
    
}
