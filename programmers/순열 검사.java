import java.util.*;

class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;

        Arrays.sort(arr);
        
        for (int i=0 ; i<arr.length ; i++) {
            if (arr[i] != i+1) return false;
        }

        return answer;
    }
}
