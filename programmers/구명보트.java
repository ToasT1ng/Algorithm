// https://school.programmers.co.kr/learn/courses/30/lessons/42885

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Integer[] peopleInt = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(peopleInt, Collections.reverseOrder());
        
        for (int i=0, j=peopleInt.length-1 ; i<peopleInt.length && i<=j; i++) {
            if (peopleInt[i] >= limit || peopleInt[i] + peopleInt[j] > limit) {
                answer++;
            } else if (peopleInt[i] + peopleInt[j] <= limit) {
                answer++;
                j--;
            }
        }
        return answer;
    }
}
