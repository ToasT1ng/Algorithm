import java.util.*;

class Solution {
//     public long solution(long n) {
//         long answer = 0;
        
//         String[] nString = String.valueOf(n).split("");
//         Arrays.sort(nString, Comparator.reverseOrder());
        
//         String result = "";
//         for (String nEach : nString) 
//             result += nEach;  
        
//         return Long.parseLong(result);
//     }
    
    
    public long solution(long n) {
        long answer = 0;
        
        List<Long> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        
        Collections.sort(list);
        
        int multiply = 1;
        for (Long each : list) {
            answer += each * multiply;
            multiply *= 10;
        }
        
        return answer;
    }
}
