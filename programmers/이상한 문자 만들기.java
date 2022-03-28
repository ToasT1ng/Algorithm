// https://programmers.co.kr/learn/courses/30/lessons/12930#

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // String[] a = s.split(" ",-1);  이런식으로 써도됨!
        int count = 0;
        for (int i=0 ; i<s.length() ; i++) {
            if (String.valueOf(s.charAt(i)).equals(" ")) {
                count = 0;
                answer += String.valueOf(s.charAt(i)); 
                continue;
            }
            if (count%2 == 0) answer += String.valueOf(s.charAt(i)).toUpperCase();
            else answer += String.valueOf(s.charAt(i)).toLowerCase();
            count++;
        }
       
        return answer;
    }
}
