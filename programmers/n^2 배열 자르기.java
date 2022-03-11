// https://programmers.co.kr/learn/courses/30/lessons/87390#

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)(right - left) + 1;
        int[] answer = new int[length];
        for (int i=0 ; i<length ; i++) {
            int max = Math.max((int)((left + i) / n), (int)((left + i) % n));
            answer[i] = max + 1;
        }
    
        return answer;
    }
    
    // 1 2 3 4      // 1 2 3 4 2 2 3 4 3 3 3 4
    // 2 2 3 4      // left 2  , right 5
    // 3 3 3 4      
    // 4 4 4 4      
    
    // 아래는 -1 한 버젼
    
    // 0 1 2 3      // 0,2  => 2    right = 1,1  => 1
    // 1 1 2 3      // 행과 열 중 Max 값을 해주면 해당 값이 나옴
    // 2 2 2 3
    // 3 3 3 3
}
