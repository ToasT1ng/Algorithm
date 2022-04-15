// https://programmers.co.kr/learn/courses/30/lessons/49993

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        List<String> skillTreeArray = Arrays.asList(skill_trees);
        
        for (String skillTree : skillTreeArray) {
            String essentialSkillTree = skillTree.replaceAll("[^"+skill+"]", "");
            if (skill.indexOf(essentialSkillTree) != 0) {
                continue;
            }
            answer++;
        }
        
        
        return answer;
    }
    
    // faster than above solution
    public int mySolution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0 ; i<skill.length() ; i++) {
            map.put(skill.charAt(i), i);
        }
        
        for (String skillTree : skill_trees) {
            int skillIndex = 0;
            boolean flag = true;
            for (char each : skillTree.toCharArray()) {
                if (map.containsKey(each)) {
                    if (map.get(each) != skillIndex) {
                        flag = false;
                        break;
                    } else {
                        skillIndex++;
                    }
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}
