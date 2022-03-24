// https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Progress {
    int day;
    int jobAmount;
    public Progress(int day, int jobAmount) {
        this.day = day;
        this.jobAmount = jobAmount;
    }
    
    public String toString() {
        return "{day=" + this.day + ",jobAmount=" + this.jobAmount + "}";
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Progress> stack = new Stack<>();
        for (int i=0 ; i<progresses.length ; i++) {
            int progress = progresses[i];
            
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            
            if (!stack.isEmpty() && stack.peek().day >= day) {
                Progress lastProgress = stack.pop();
                lastProgress.jobAmount += 1;
                stack.push(lastProgress);
            } else {
                stack.push(new Progress(day, 1));
            }
        }

        return stack.stream().mapToInt(i->i.jobAmount).toArray();
    }
}
