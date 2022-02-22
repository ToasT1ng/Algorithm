// https://programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;

class PriorityElement {
    public int priority;
    public int index;
    
    public PriorityElement (int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        // return priorityQueueWay(priorities, location);
        
        // init queue
        int answer = 0;
        Queue<PriorityElement> queue = new LinkedList<>();
        for (int index=0 ; index<priorities.length ; index++) {
            queue.offer(new PriorityElement(priorities[index], index));
        }
        
        // print or not
        boolean printBool;
        while (!queue.isEmpty()) {
            printBool = true;
            for (PriorityElement queueEach : queue) {
                // when unable to print
                if (queue.peek().priority < queueEach.priority) {
                    printBool = false;
                    break;
                }
            }
            
            PriorityElement pollElement = queue.poll();
            
            // able to print
            if (printBool) {
                answer++;
                
                // check location
                if (pollElement.priority == priorities[location] && pollElement.index == location) {
                    break;
                }
                
            // unable to print
            } else {
                queue.offer(pollElement);
            }
        }
        
        return answer;
    }
    
    public int priorityQueueWay(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            queue.offer(priority);
        }
         while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }
        return 0;
    }
}
