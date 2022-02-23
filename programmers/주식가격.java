// https://programmers.co.kr/learn/courses/30/lessons/42584?language=java

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i=0 ; i<prices.length ; i++) {
            int current = prices[i];
            for (int j=i+1 ; j<prices.length ; j++) {
                answer[i] += 1;
                if (current > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
    
    public int[] oldSolution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0 ; i<prices.length ; i++) {
            int currentPrice = prices[i];
            queue.offer(currentPrice);
        }
        
        for (int i=0 ; i<prices.length ; i++) {
            int current = queue.poll();
            for (int each : queue) {
                answer[i] += 1;
                if (current > each) {
                    break;
                }
            }
        }
        return answer;
    }
}
