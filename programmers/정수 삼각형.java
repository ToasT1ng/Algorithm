// https://school.programmers.co.kr/learn/courses/30/lessons/43105

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for (int i=1 ; i<triangle.length ; i++) {
            for (int j=0 ; j<triangle[i].length ; j++) {
                int current = 0;
                if (j-1 >= 0) {
                    current = Math.max(current, triangle[i-1][j-1]);
                }
                if (j < triangle[i].length-1) {
                    current = Math.max(current, triangle[i-1][j]);
                }
                triangle[i][j] += current;
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
}
