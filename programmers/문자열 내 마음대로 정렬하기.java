// https://programmers.co.kr/learn/courses/30/lessons/12915

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.charAt(n) > b.charAt(n)) {
                    return 1;
                } else if (a.charAt(n) < b.charAt(n)) {
                    return -1;
                } else {
                    return a.compareTo(b);
                }
                
            }
        });
        return strings;
    }
}
