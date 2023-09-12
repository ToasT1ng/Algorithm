// https://school.programmers.co.kr/learn/courses/30/lessons/12938#

import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int initValue = s/n;
        if (initValue == 0) return new int[]{-1};
        for (int i=0, remainValue=s%n ; i<answer.length ; i++, remainValue--) {
            answer[i] = initValue;
            if (remainValue > 0) answer[i] += 1;
        }
        Arrays.sort(answer);
        return answer;

    }
}
