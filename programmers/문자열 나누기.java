class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] sCharArray = s.toCharArray();
        
        int firstLetterCounter = 0;
        int anotherLetterCounter = 0;
        char firstLetter = sCharArray[0];        
        for (int i=0 ; i<sCharArray.length ; i++) {
            if (firstLetter == sCharArray[i]) {
                firstLetterCounter++;
            } else {
                anotherLetterCounter++;
            }
            
            if (firstLetterCounter == anotherLetterCounter) {
                answer++;
                firstLetterCounter = 0;
                anotherLetterCounter = 0;
                if (i+1 < sCharArray.length) {
                    firstLetter = sCharArray[i+1];
                }
            }
        }
        
        if (firstLetterCounter != anotherLetterCounter) {
            answer++;
        }
                
        return answer;
    }
}
