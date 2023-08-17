import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> minClick = new HashMap<>();
        for (String keymapEach : keymap) {
        	char[] keymapCharArray = keymapEach.toCharArray();
        	for (int i=0 ; i<keymapCharArray.length ; i++) {
        		char each = keymapCharArray[i];
        		minClick.put(each, Math.min(minClick.getOrDefault(each, i+1), i+1));
        	}
        }
        // System.out.println(minClick.toString());

        for (int answerIndex = 0; answerIndex < targets.length ; answerIndex++) {
        	int currentAnswer = 0;
        	char[] targetCharArray = targets[answerIndex].toCharArray();
        	for (char each : targetCharArray) {
        		if (!minClick.containsKey(each)) {
        			currentAnswer = -1;
        			break;
        		}
        		currentAnswer += minClick.get(each);
        	}
        	answer[answerIndex] = currentAnswer;
        }
        return answer;
    }
}
