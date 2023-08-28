// https://school.programmers.co.kr/learn/courses/30/lessons/138476

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int each : tangerine) {
            counterMap.put(each, counterMap.getOrDefault(each, 0) + 1);
        }
        
        List<Integer> countList = new ArrayList<>();
        for (int key : counterMap.keySet()) {
            countList.add(counterMap.get(key));
        }
        
        Collections.sort(countList, Collections.reverseOrder());
        
        for (int each : countList) {
            k -= each;
            answer++;
            if (k <= 0) return answer;
        }
        return answer;
    }
}
