// https://school.programmers.co.kr/learn/courses/30/lessons/118667

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sumOfFirst = 0;
        Queue<Integer> first = new LinkedList<>();
        for (int each : queue1) {
            first.offer(each);
            sumOfFirst += each;
        }
        
        long sumOfSecond = 0;
        Queue<Integer> second = new LinkedList<>();
        for (int each : queue2) {
            second.offer(each);
            sumOfSecond += each;
        }
        
        if ((sumOfFirst + sumOfSecond) % 2 != 0) {
            return -1;
        }
        
        while(sumOfFirst != sumOfSecond) {
            if (answer > (queue1.length + queue2.length)*2) {
                return -1;
            }
            if (sumOfFirst > sumOfSecond) {
                int element = first.poll();
                sumOfFirst -= element;
                sumOfSecond += element;
                second.offer(element);
            } else {
                int element = second.poll();
                sumOfFirst += element;
                sumOfSecond -= element;
                first.offer(element);
            } 
            answer++;
        }
        return answer;
    }
}
