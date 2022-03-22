// https://programmers.co.kr/learn/courses/30/lessons/12899

class Solution {
    public String solution(int n) {
        String answer = "";
        while (n >= 3) {
            int num = n % 3;
            if (num == 0) {
                n--;
            }
            answer = converter(num) + answer;
            n /= 3;
        }
        if (n != 0) answer = converter(n) + answer;
        return String.valueOf(answer);
    }
    
    public String converter(int num) {
        if (num == 0) {
            return String.valueOf(4);
        } else if (num < 0) {
            return "";
        } else {
            return String.valueOf(num);
        }
    }
}
