import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i=0 ; i<want.length ; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i=0 ; i<discount.length ; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j=i, k=0 ; j<discount.length && k<10 ; j++, k++) {
                int counter = discountMap.getOrDefault(discount[j], 0);
                discountMap.put(discount[j], counter+1);
            }
            
            boolean correctFlag = true;
            for (String wantProduct : wantMap.keySet()) {
                if (wantMap.get(wantProduct) > discountMap.getOrDefault(wantProduct, 0)) {
                    correctFlag = false;
                    break;
                }
            }
            if (correctFlag) {
                answer++;
            }
        }
        return answer;
    }
}
