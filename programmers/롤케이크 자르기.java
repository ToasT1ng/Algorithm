// https://school.programmers.co.kr/learn/courses/30/lessons/132265

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> cheolsu = new HashSet<>();
        cheolsu.add(topping[0]);
        
        HashMap<Integer, Integer> brother = new HashMap<>();
        
        for (int i=1 ; i<topping.length ; i++) {
            brother.put(topping[i], brother.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i=1 ; i<topping.length ; i++) {
            cheolsu.add(topping[i]);
            
            brother.put(topping[i], brother.getOrDefault(topping[i], 0) - 1);
            if (brother.get(topping[i]) <= 0) {
                brother.remove(topping[i]);
            }
            
            if (cheolsu.size() == brother.size()) {
                answer++;
            }
        }
        return answer;
    }
}
