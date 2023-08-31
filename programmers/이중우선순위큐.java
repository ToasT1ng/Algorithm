// https://school.programmers.co.kr/learn/courses/30/lessons/42628#

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] split = operation.split(" ");
            int number = Integer.parseInt(split[1]);
            if (split[0].equals("I")) {
                minQueue.offer(number);
                maxQueue.offer(number);
            } else {
                if (minQueue.isEmpty() || maxQueue.isEmpty()) {
                    minQueue = new PriorityQueue<>();
                    maxQueue = new PriorityQueue<>(Collections.reverseOrder());
                    continue;
                }
                
                if (number == 1) {   
                    minQueue.remove(maxQueue.poll());
                } else {
                    maxQueue.remove(minQueue.poll());
                }
            }
        }
        
        
        if (!minQueue.isEmpty()) {
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();
        }
        
        return answer;
    }
}
