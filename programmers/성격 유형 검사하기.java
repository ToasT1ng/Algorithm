import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] surveyType = {"RT", "CF", "JM", "AN"};

        Map<Character, Integer> answerMap = new HashMap<>();

        for (int surveyIndex=0 ; surveyIndex < survey.length ; surveyIndex++) {
            int choice = choices[surveyIndex];
            char[] surveys = survey[surveyIndex].toCharArray();
            if (choice == 4) {
                continue;
            } else if (choice < 4) {
                int currentAnswer = answerMap.getOrDefault(surveys[0], 0) + (choice-4) * -1;
                answerMap.put(surveys[0], currentAnswer);
            } else {
                int currentAnswer = answerMap.getOrDefault(surveys[1], 0) + (choice-4);
                answerMap.put(surveys[1], currentAnswer);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (String eachType : surveyType) {
            char[] eachTypeCharArray = eachType.toCharArray();
            Arrays.sort(eachTypeCharArray);
            if (answerMap.getOrDefault(eachTypeCharArray[0], 0) >= answerMap.getOrDefault(eachTypeCharArray[1], 0)) {
                answer.append(eachTypeCharArray[0]); 
            } else {
                answer.append(eachTypeCharArray[1]); 
            }
        }
        return answer.toString();
    }
}
