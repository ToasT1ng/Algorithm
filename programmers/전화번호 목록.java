import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, String> phoneMap = new HashMap<>();
        
        Arrays.sort(phone_book);
        
        for (String eachPhone : phone_book) {
            String temp = "";
            for (char eachChar : eachPhone.toCharArray()) {
                temp += eachChar;
                if (phoneMap.containsKey(temp)) {
                    return false;
                }
            }
            
            phoneMap.put(eachPhone, eachPhone);
        }
        return answer;
    }
}
