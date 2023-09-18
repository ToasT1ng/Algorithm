// https://school.programmers.co.kr/learn/courses/30/lessons/12927#

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long total = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            queue.offer(work);
            total += work;
        }
        if (total <= n) return 0; 
        
        while (n > 0) {
            n--;
            queue.offer(queue.poll()-1);
        }
        
        while (!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }
        return answer;
    }
}
