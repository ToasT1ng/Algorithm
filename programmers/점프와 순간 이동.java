// https://school.programmers.co.kr/learn/courses/30/lessons/12980

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;

        while (n > 2) {
            if (n % 2 == 1) ans++;
            n /= 2;
        }

        return ans;
    }
}
