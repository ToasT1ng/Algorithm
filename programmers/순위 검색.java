import java.util.*;

class Solution {
    HashMap<String, List<Integer>> queryMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (String eachInfo : info) {
            String[] eachTinyInfo = eachInfo.split(" ");
            recursion(eachTinyInfo, 0, "");
        }
        for (int i=0 ; i<query.length ; i++) {
            answer[i] = 0;
            
            String currentQuery = query[i];
            int lastIndent = currentQuery.lastIndexOf(" ");
            
            String key = currentQuery.substring(0, lastIndent);
            int scoreValue = Integer.parseInt(currentQuery.substring(lastIndent+1));
            
            if (queryMap.containsKey(key)) {
                answer[i] = search(queryMap.get(key), scoreValue);
            }
        }
        return answer;
    }
    
    public void recursion(String[] eachTinyInfo, int tinyInfoIndex, String queryMapKey) {
        if (tinyInfoIndex == 4) {
            queryMapKey = queryMapKey.replaceAll(" ", " and ");
            
            List<Integer> score = queryMap.getOrDefault(queryMapKey, new ArrayList<>());
            score.add(Integer.parseInt(eachTinyInfo[tinyInfoIndex]));
            Collections.sort(score);
            queryMap.put(queryMapKey, score);
            return ;
        }
        if (tinyInfoIndex != 0) {
            queryMapKey += " ";
        }
        recursion(eachTinyInfo, tinyInfoIndex+1, queryMapKey + eachTinyInfo[tinyInfoIndex]);
        recursion(eachTinyInfo, tinyInfoIndex+1, queryMapKey + "-");
    }
    
    public int search(List<Integer> score, int queryScoreValue) {
        int low = 0;
        int high = score.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (score.get(mid) < queryScoreValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return score.size() - low;
    }
}
