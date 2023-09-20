import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int aIndex=0, bIndex=0 ; aIndex < A.length && bIndex < B.length ; bIndex++) {
            if (A[aIndex] < B[bIndex]) {
                answer++;
                aIndex++;
            }
        }
        return answer;
    }
}
