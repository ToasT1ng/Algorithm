import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        // list 에 게산값 순차적으로 저장
        // * 이나 # 이 나오면 list 로 잘쓰면 됨
        
        List<Integer> list = new ArrayList<>();
        
        String tempIntString = "";
        for (int i=0 ; i < dartResult.length() ; i++ ) {
            String dartString = String.valueOf(dartResult.charAt(i));
            
            if (dartString.matches("[0-9]")) {
                tempIntString += dartString;
                if (!String.valueOf(dartResult.charAt(i+1)).matches("[0-9]")) {
                    list.add(Integer.parseInt(tempIntString));
                    tempIntString = "";
                }
            
            } else if (dartString.matches("[A-Z]")) {
                int lastIndex = list.size()-1;
                if (dartString.equals("D")) list.set(lastIndex, (int) Math.pow(list.get(lastIndex), 2));
                else if (dartString.equals("T")) list.set(lastIndex, (int) Math.pow(list.get(lastIndex), 3));
                
            } else {
                int lastIndex = list.size()-1;
                int last = list.get(lastIndex);
                if (dartString.equals("*")) {
                    last *= 2;
                    if (lastIndex - 1 >= 0) list.set(lastIndex-1, list.get(lastIndex-1) * 2);
                } else {
                    last *= -1;
                }
                list.set(lastIndex, last);
            }
        }
        
        for (int each : list) {
            answer += each;
        }
        return answer;
    }
}
