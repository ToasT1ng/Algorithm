// https://programmers.co.kr/learn/courses/30/lessons/12981

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        
        for (int i=0 ; i<words.length ; i++) {
            if ((i>0 && !isWordLastAndFirstEqual(words[i-1], words[i])) || !set.add(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }
    
    public boolean isWordLastAndFirstEqual(String last, String first) {
        return last.charAt(last.length()-1) == first.charAt(0);
    }
}
