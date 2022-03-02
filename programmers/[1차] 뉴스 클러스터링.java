import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> first = makeList(str1);
        List<String> second = makeList(str2);
        
        double computeValue = compute(first, second);
    
        return (int) Math.floor(computeValue * 65536);
    }
    
    private List<String> makeList(String str) {
        String temp = "";
        List<String> list = new ArrayList<>();
        for (int i=0 ; i<str.length()-1 ; i++) {
            temp += String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1));
            temp = temp.toLowerCase();
            if (temp.matches("[a-z]+")) {
                list.add(temp);
            }
            temp = "";
        }
        return list;
    }
    
    private double compute(List<String> first, List<String> second) {
        if (first.size() == 0 && second.size() == 0) {
            return 1f;
        }
        
        List<String> entire = new ArrayList<>();
        List<String> samePart = new ArrayList<>();
        
        // 첫번째 리스트를 합집합에 더한다.
        // 두번째 리스트에서 첫번째 리스트 항목을 삭제할 수 있으면 교집합에 더한다.
        for (String firstEach : first) {
            entire.add(firstEach);
            if (second.remove(firstEach)) {   
                samePart.add(firstEach);
            }
        }
        
        // 위에서 삭제되고 남은 리스트 항목을 합집합에 더한다.
        for (String secondEach : second) {
            entire.add(secondEach);
        }
        
        return (double) samePart.size() / entire.size();
    }
}
