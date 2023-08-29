// https://school.programmers.co.kr/learn/courses/30/lessons/12914#

class Solution {
    public long solution(int n) {
        long dp[] = new long[n+1];
        
        for (int i=0 ; i<=n ; i++) {
            dp[i] = i;
        }
        
        for (int i=3 ; i<=n ; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        
        return dp[n];
    }

}
