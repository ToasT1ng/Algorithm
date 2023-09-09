// https://school.programmers.co.kr/learn/courses/30/lessons/12904#

class Solution {
    public int solution(String s) {
        int answer = 1;

        for (int i=0, length=s.length() ; i<s.length() ; i++, length--) {
            for (int j=0 ; j<s.length() && j+length < s.length() ; j++) {
                if (isPalindrome(s, j, j+length)) return length+1;
            }
        }

        return answer;
    }
    
    public boolean isPalindrome(String input, int begin, int end) {
        for (int i=begin, j=end ; i<end && j>=0 && i<j ; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) return false; 
        }
        return true;
    }

}
