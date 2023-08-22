// https://school.programmers.co.kr/learn/courses/30/lessons/17680#

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        int i=0;
        int expectSize = i+1;
        for ( ; i<cities.length ; i++) {
            set.add(cities[i].toUpperCase());
            
            if (set.size() != expectSize) {
                queue.remove(cities[i].toUpperCase());
                queue.offer(cities[i].toUpperCase());
                answer += 1;
            } else {
                queue.offer(cities[i].toUpperCase());
                answer += 5;
                expectSize++;
            }
            
            if (set.size() == cacheSize) {
                i++;
                break;
            }
        }
        
    
        for ( ; i<cities.length ; i++) {
            set.add(cities[i].toUpperCase());
             
            if (set.size() >= cacheSize+1) {
                queue.offer(cities[i].toUpperCase());
                set.remove(queue.poll());
                answer += 5;
            } else {
                queue.remove(cities[i].toUpperCase());
                queue.offer(cities[i].toUpperCase());
                answer += 1;
            }
            
            
        }
        return answer;
    }
}
