import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answerList = new ArrayList<>();
        int last = -1;
        for (int arrEach : arr) {
            if (arrEach != last) {
                answerList.add(arrEach);
                last = arrEach;
            } 
        }

        return answerList.stream().mapToInt(i->i).toArray();
    }
}
