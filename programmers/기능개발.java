// https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0 ; i<progresses.length ; i++) {
            int duration = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                duration++;
            }
            queue.add(duration);
        }
        
        int save = queue.poll();
        int count = 1;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (current <= save) {
                count++;
            } else {
                save = current;
                answer.add(count);
                count = 1;
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(i->i).toArray();
    }
}
