// https://programmers.co.kr/learn/courses/30/lessons/72411

import java.util.*;

class Solution {
    Map<String, Integer> counterMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        List<String> answerList = new ArrayList<>();
        
        // sorting each order string
        for (int ordersIndex=0 ; ordersIndex < orders.length ; ordersIndex++) {
            orders[ordersIndex] = new String(sortString(orders[ordersIndex]));
        }
        
        
        for (int courseIndex = 0 ; courseIndex < course.length ; courseIndex++) {
            
            // make every possible combination
            for (int ordersIndex = 0 ; ordersIndex < orders.length ; ordersIndex++) {
                char[] order = orders[ordersIndex].toCharArray();
                int courseCount = course[courseIndex];
                if (order.length >= courseCount) {
                    recursion(0, order, courseCount, "");
                }
            }
            
            //find max
            int currentMax = 0;
            for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
                if (entry.getValue() > currentMax) {
                    currentMax = entry.getValue();
                }
            }
            if (currentMax < 2) {
                currentMax = 2;
            }
            
            // make answer array list
            for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
                if (entry.getValue() == currentMax) {
                    answerList.add(entry.getKey());
                }
            }
                
            counterMap = new HashMap<>();
        }
        answer = answerList.stream().map(i->i).toArray(String[]::new);
        Arrays.sort(answer);
        return answer;
    }
    
    public char[] sortString(String order) {
        char[] orderCharArray = order.toCharArray();
        Arrays.sort(orderCharArray);
        return orderCharArray;
    }
    
    public void recursion(int position, char[] order, int courseCount, String temp) {
        if (temp.length() >= courseCount) {
            counterMap.put(temp, counterMap.getOrDefault(temp, 0) + 1);
            return;
        }
        
        for (int i=position ; i<order.length ; i++) {
            if (temp.contains(String.valueOf(order[i]))) {
                continue;
            }
            temp += order[i];
            recursion(i+1, order, courseCount, temp);
            temp = temp.substring(0, temp.length()-1);
        }
        
    }
}
