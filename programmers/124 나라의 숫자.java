// https://programmers.co.kr/learn/courses/30/lessons/12899

import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        int temp = n;
        int front = temp / 3;
        int back = temp % 3;
        if (back == 0) {
            front--;
        }
        answer = converter(back) + answer;
        
        while (front >= 3) {
            temp = front;
            front = temp / 3;
            back = temp % 3;
            if (back == 0) {
                front--;
            }
            answer = converter(back) + answer;
            
        }
        
        if (front != 0) {
            answer = converter(front) + answer;
        }
        
        return answer;
    }
    
    public String converter(int number) {
        if (number == 0) {
            return Integer.toString(4);
        } else if (number < 0) {
            return "";
        } else {
            return Integer.toString(number);
        }
    }
}
