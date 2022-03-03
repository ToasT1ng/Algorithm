// https://programmers.co.kr/learn/courses/30/lessons/42890#

import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        // unique 한지 확인해야함 
        // unique 하면 add to result 
        // unique 하지 않으면 result 에 이미 있는 거 제외하고 나머지 갖고 조합해서 다시 unique 한지 확인
        // map 을 이용해서 모든 경우의수를 key 값으로 만들고 counter 느낌으로 해서
        Map<String, Integer> answerMap = new HashMap<>();
        for (int amount = 1 ; amount<relation[0].length ; amount++) {
            answerMap = get(relation, answerMap, amount);
        }
        return answerMap.keySet().size();
    }
    
    public Map<String, Integer> get(String[][] relation, Map<String, Integer> answerMap, int amount) {
        for (int j=0 ; j<relation[0].length ; j++) {
            if (j+amount <= relation[0].length) {
                Set<String> temp = new HashSet<>();
                for (int i=0 ; i<relation.length ; i++) {
                    String combination = "";
                
                    for (int k=0 ; k<amount && j+k<relation[0].length ; k++) {
                        combination += relation[i][j+k];
                    }
                
                    temp.add(combination);
                }
            
                if (temp.size() == relation.length) {
                    String string = "";
                    for (int k=j ; k<j+amount; k++) {
                        string += Integer.toString(k) + "_";
                    }

                    if (isMinimality(answerMap, string)) answerMap.put(string, 1);
                }
            }
        }
        return answerMap;
    }
    
    public boolean isMinimality(Map<String, Integer> answerMap, String key) {
        // 기존 key 0_2_ 일 때 0_1_2_ 이거 못잡아냄
        System.out.println("====" + key);
        String[] keySplit = key.split("_");
        Set<String> keySet = new HashSet<>();
        getEveryKeySet(0, keySplit, new boolean[keySplit.length], "", keySet);
        System.out.println("====" + keySet.toString());
        
        for (String eachKey : keySet) {
            if (answerMap.containsKey(eachKey)) {
                return false;
            }
        }
        return true;
    }
    
    public void getEveryKeySet(int index, String[] keySplit, boolean[] visited, String keyResult, Set<String> result) {
        if (index >= keySplit.length) {
            // System.out.println(keyResult);
            // result.add(keyResult);
            return;
        }
        
        for (int i=index ; i < keySplit.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String add = keySplit[i] + "_";
                keyResult += add;
                result.add(keyResult);
                getEveryKeySet(index+1, keySplit, visited, keyResult, result);
                
                keyResult = keyResult.substring(0, keyResult.length()-add.length());
                visited[i] = false;
            }
        }
    }
}
