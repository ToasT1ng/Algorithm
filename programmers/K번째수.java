import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int index=0 ; index<commands.length; index++) {
            int[] eachCommand = commands[index];
            
            int i = eachCommand[0]-1;
            int j = eachCommand[1];
            int k = eachCommand[2]-1;
            
            List<Integer> eachList = new ArrayList<>();
            for (int arrayIndex = i ; arrayIndex < j ; arrayIndex++) {
                eachList.add(array[arrayIndex]);
            }
        
            Collections.sort(eachList);
            
            answer[index] = eachList.get(k);
        }
        return answer;
    }
}
