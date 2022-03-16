// https://programmers.co.kr/learn/courses/30/lessons/42626

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int each : scoville) {
            heap.offer(each);
        }
        
        while (true) {
            if (heap.peek() >= K) {
                break;
            }
            if (heap.size() < 2) {
                answer = -1;
                break;
            }
            int currentFirst = heap.poll();
            int currentSecond = heap.poll();
            int newScoville = currentFirst + (currentSecond * 2);
            heap.offer(newScoville);
            answer++;
        }
        
        if (answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
}
