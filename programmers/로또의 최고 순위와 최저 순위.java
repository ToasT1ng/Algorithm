import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int matchCounter = 0;
        int zeroCounter = 0;
        for (int i=0 ; i<lottos.length ; i++) {
            if (lottos[i] == 0) {
                zeroCounter++;
            }
            for (int j=0 ; j<win_nums.length ; j++) {
                if (lottos[i] == win_nums[j]) {
                    matchCounter++;
                }
            }
        }
        
        if (matchCounter == 0 && zeroCounter == 0) {
            answer[0] = 6;
        } else {
            answer[0] = 7 - (matchCounter + zeroCounter);
        }
        
        if (matchCounter == 0) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - matchCounter;
        }
        
        return answer;
    }
}
