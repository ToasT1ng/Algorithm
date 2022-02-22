// https://programmers.co.kr/learn/courses/30/lessons/60057

class Solution {
    public int solution(String s) {
        int entireSize = s.length();
        int answer = entireSize;
        
        for (int i=1 ; i<entireSize/2+1 ; i++) {
            
            String currentString = s.substring(0,i);
            int currentCount = 1;
            
            String answerString = "";
            String last = "";
            for (int j=i ; j<entireSize ; j=j+i) {
                if (j + i > entireSize) {
                    last = s.substring(j);
                    continue;
                }
                if (currentString.compareTo(s.substring(j,j+i)) == 0) {
                    currentCount++;
                } else {
                    if (currentCount >= 2) {
                        answerString += currentCount;
                    }
                    answerString += currentString;
                    currentString = s.substring(j,j+i);
                    currentCount = 1;
                }
            }
            
            answerString += last;
            if (currentCount >= 2) {
                answerString += currentCount;
            }
            answerString += currentString;
            answer = Math.min(answer, answerString.length());
            
        }
        return answer;
    }
}
