// https://programmers.co.kr/learn/courses/30/lessons/42746#

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] stringNums = new String[numbers.length];
        for (int i=0 ; i<numbers.length ; i++) {
            stringNums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(stringNums, (n1, n2) -> (n2+n1).compareTo(n1+n2));
        
        if (stringNums[0].equals("0")) {
            return "0";
        }
        
        for (String stringNum : stringNums) {
            answer += stringNum;
        }
        return answer;
    }
}
