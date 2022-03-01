// https://programmers.co.kr/learn/courses/30/lessons/77885

import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];    
        
        for (int i=0 ; i<numbers.length ; i++) {
            long current = numbers[i];
            answer[i] = findLowest(current);
        }

        return answer;
    }
    
    public long findLowest(long current) {
        if (current % 2 == 0) {
            return current+1;
        } else {
            String binaryString = Long.toBinaryString(current);
            return findLowestByBinaryString(binaryString);
        }
    }
    
    public long findLowestByBinaryString(String binaryString) {
        char[] array = binaryString.toCharArray();
        int lastIndexOfZero = binaryString.lastIndexOf("0");
        
        // '111'
        if (lastIndexOfZero == -1) {
            array[0] = '0';
            return Long.parseLong("1" + String.valueOf(array), 2); // '1011'
        
        // '1101'
        } else {
            array[lastIndexOfZero] = '1';
            array[lastIndexOfZero + 1] = '0';
            return Long.parseLong(String.valueOf(array), 2); // '1110'
        }
    }
}
