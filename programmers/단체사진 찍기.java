// https://programmers.co.kr/learn/courses/30/lessons/1835

import java.util.*;

class Solution {
    int answer = 0;
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    boolean[] visited = new boolean[8];
    List<String> sortingFriends = new ArrayList<>();
    
    public int solution(int n, String[] data) {
        dfs(0, data);
        return answer;
    }
    
    public void dfs(int location, String[] data) {
        System.out.println(location);
        if (location == 8) {
            check(data);
            return;
        }
        for (int i=0 ; i<8 ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sortingFriends.add(friends[i]);
                dfs(location+1, data);
                visited[i] = false;
                sortingFriends.remove(location);
            }
        }
    }
    
    public void check(String[] data) {
        for (String eachCommand : data) {
            char firstFriend = eachCommand.charAt(0);
            char secondFriend = eachCommand.charAt(2);
            int firstFriendPos = sortingFriends.indexOf(String.valueOf(firstFriend));
            int secondFriendPos = sortingFriends.indexOf(String.valueOf(secondFriend));
            int realDistance = Math.abs(firstFriendPos - secondFriendPos) - 1;
            
            char sign = eachCommand.charAt(3);
            int betweenNumber = eachCommand.charAt(4) - '0';
            
            if (sign == '=') {
                if (realDistance != betweenNumber) {
                    return;
                }
            } else if (sign == '<') {
                if (realDistance >= betweenNumber) {
                    return;
                }
            } else {
                if (realDistance <= betweenNumber) {
                    return;
                }
            }
            
        }
        answer++;
    }
}
