// https://programmers.co.kr/learn/courses/30/lessons/64065?language=java

import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        String[] eachTuple = s.split("\\},\\{");
        
        Arrays.sort(eachTuple, (a,b) -> (a.length() > b.length() ? 1 : -1));
        
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[eachTuple.length];
        for (int i=0 ; i<eachTuple.length ; i++) {
            String tuple = eachTuple[i];
            String[] tupleElement = tuple.split(",");
            for (String tupleEachElement : tupleElement) {
                int current = Integer.parseInt(tupleEachElement);
                if (set.add(current)) answer[i] = current;
            }
        }
        return answer;
    }
    
    public int[] oldSolution(String s) {
        s = s.substring(2, s.length()-2);
        String[] eachTuple = s.split("\\},\\{");
        
        Arrays.sort(eachTuple, (a,b) -> (a.length() > b.length() ? 1 : -1));
        
        Set<Integer> set = new LinkedHashSet<>();
        for (int i=0 ; i<eachTuple.length ; i++) {
            String tuple = eachTuple[i];
            String[] tupleElement = tuple.split(",");
            for (String tupleEachElement : tupleElement) {
                set.add(Integer.parseInt(tupleEachElement));
            }
        }
        
        int[] answer = new int[eachTuple.length];
        int index = 0;
        for (Integer each : set) {
            answer[index] = each;
            index++;
        }
        return answer;
    }
}
