// https://programmers.co.kr/learn/courses/30/lessons/12903?language=java

class Solution {
    public String solution(String s) {
        String answer = "";
        int total = s.length();
        int mid = total / 2 + total % 2 - 1;
        answer += s.charAt(mid);
        if (total % 2 == 0) answer += s.charAt(mid+1);
        return answer;
    }
}
