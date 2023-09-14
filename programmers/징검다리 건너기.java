// https://school.programmers.co.kr/learn/courses/30/lessons/64062

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        
        while (min <= max) {
            int mid = (min+max) / 2;
            if (check(stones, mid, k)) {
                min = mid+1;
                answer = mid;
            } else {
                max = mid-1;
            }
        }
        return answer;
    }
    
    public boolean check(int[] stones, int mid, int k) {
        int step = 1;
        for (int stone : stones) {
            if (stone < mid) step++;
            else step = 1;
            if (step > k) {
                return false;
            }
        }
        return true;
    }
}
