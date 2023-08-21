// https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        
        for (int index = x; index < y + 1; index++) {
            if (index != x && dp[index] == 0) {
                dp[index] = -1;
                continue;
            }
            if (index * 2 <= y) {
                dp[index * 2] = (dp[index * 2] == 0) ? dp[index] + 1 : Math.min(dp[index] + 1, dp[index * 2]);
            }
            if (index * 3 <= y) {
                dp[index * 3] = (dp[index * 3] == 0) ? dp[index] + 1 : Math.min(dp[index] + 1, dp[index * 3]);
            }
            if (index + n <= y) {
                dp[index + n] = (dp[index + n] == 0) ? dp[index] + 1 : Math.min(dp[index] + 1, dp[index + n]);
            }
        }
        return dp[y];
    }

}
