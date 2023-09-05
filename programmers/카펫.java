// https://school.programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int entireAmount = brown + yellow;
        int bottonTop = (brown + 4) / 2;

        for (int x=3 ; x<10000 ; x++) {
            for (int y=3 ; y<10000 ; y++) {
                if (x + y == bottonTop && x * y == entireAmount) {
                    if (x > y) {
                        answer[0] = x;
                        answer[1] = y;
                    } else {
                        answer[0] = y;
                        answer[1] = x;
                    }
                    
                    return answer;
                }
                if (x + y > bottonTop && x * y > entireAmount) {
                    break;
                }
            }
        }
        
        return answer;
    }
}
