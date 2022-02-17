import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> pokemonSet = new HashSet<>();
        for (int i=0 ; i<nums.length ; i++) {
            pokemonSet.add(nums[i]);
        }
        int size = pokemonSet.size();
        int ableMaxSize = nums.length/2;
        if (size > ableMaxSize) {
            answer = ableMaxSize;
        } else {
            answer = size;
        }
        return answer;
    }
}
