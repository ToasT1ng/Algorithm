// https://programmers.co.kr/learn/courses/30/lessons/12901
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] eachMonthDates = {31,29,31,30,31,30,31,31,30,31,30,31};
        int totalDay = 0;
        for (int i=0 ; i<a-1 ; i++) {
            totalDay += eachMonthDates[i];
        }
        totalDay += b;
        answer = day[totalDay % 7];
        
        return answer;
    }
    
    public String oldSolution(int a, int b) {
        String answer = "";
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int totalDay = 0;
        for (int i=1 ; i<a ; i++) {
            if (i==2) {
                totalDay += 29;
            } else if (i%2 == 0) {
                if (i <= 7) totalDay += 30;
                else totalDay += 31;
                
            } else {
                if (i <= 7) totalDay += 31;
                else totalDay += 30;
            }
        }
        totalDay += b;
        answer = day[totalDay % 7];
        
        return answer;
    }
}
