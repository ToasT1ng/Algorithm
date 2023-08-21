// https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int minMinute = fees[0];
        int minFee = fees[1];
        int unitMinute = fees[2];
        int unitFee = fees[3];
        
        
        Map<String, List<Integer>> timeMap = new HashMap<>();
        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String carNumber = recordSplit[1];
            
            String[] timeSplit = recordSplit[0].split(":");
            
            int time = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            
            List<Integer> timeList = timeMap.getOrDefault(carNumber, new ArrayList<>());
            timeList.add(time);
            timeMap.put(carNumber, timeList);
        }
    
        // System.out.println(timeMap.toString());
        
        int[] answer = new int[timeMap.keySet().size()];
        
        Map<Integer, Integer> feeMap = new HashMap<>();
        for (String carNumber : timeMap.keySet()) {
            List<Integer> timeList = timeMap.get(carNumber);
            if (timeList.size() % 2 != 0) timeList.add(23*60 + 59);
            
            int entireMinute = 0;
            for (int i=0 ; i<timeList.size() ; i+=2) {
                entireMinute += (timeList.get(i+1) - timeList.get(i));
            }
            
            int entireFee = 0;
            if (entireMinute <= minMinute) {
                entireFee = minFee;
            } else {
                entireFee = minFee + (int) Math.ceil((double)(entireMinute - minMinute) / unitMinute) * unitFee;
            }
            
            feeMap.put(Integer.parseInt(carNumber), entireFee);
        }
        
        // System.out.println(feeMap.toString());
        
        TreeSet<Integer> carNumbers = new TreeSet<>(feeMap.keySet());
        // Collections.sort(carNumbers);
        
        int i=0;
        for (int carNumber : carNumbers) {
            answer[i] = feeMap.get(carNumber);
            i++;
        }
        
        return answer;
    }
}
