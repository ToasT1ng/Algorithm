// https://programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 옷 종류별로 Map<String, List<String>> 선언하여 각각 몇벌을 갖고 있는지 알아야함.
        // 각 옷 종류별로 경우의 수 = N벌 입기, N-1번 입기, ... , 1벌 입기, 0벌 입기 = N+1 의 경우의 수
        // (N+1) * (M+1) * ... - 1 (모두 0벌 입는 경우)
        Map<String, List<String>> map = new HashMap<>();
        for (String[] clothesPair : clothes) {
            String oneClothes = clothesPair[0];
            String clothesType = clothesPair[1];
            List<String> list = map.getOrDefault(clothesType, new ArrayList<>());
            list.add(oneClothes);
            map.put(clothesType, list);
        }
        
        for (String key : map.keySet()) {
            answer *= map.get(key).size() + 1;
        }
        return answer - 1;
    }

}
