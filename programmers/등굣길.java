// https://school.programmers.co.kr/learn/courses/30/lessons/42898#

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        
        for (int[] puddle : puddles) {
            if (puddle.length > 0) dp[puddle[0]][puddle[1]] = -1;
        }
        
        dp[1][1] = 1;
        for (int i=1 ; i<m+1 ; i++) {
            for (int j=1 ; j<n+1 ; j++) {
                if (dp[i][j] == -1) continue;
                if (dp[i-1][j] > 0) dp[i][j] += dp[i-1][j];
                if (dp[i][j-1] > 0) dp[i][j] += dp[i][j-1];
                dp[i][j] %= 1000000007;
            }
            
        }
        return dp[m][n] % 1000000007;
    }
}
