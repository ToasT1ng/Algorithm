class Solution {
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;
    public int solution(int n, String[] data) {  
        dfs(0, data, new boolean[8], "");
        return answer;
    }

    public void dfs(int index, String[] data, boolean[] visited, String result) {
        if (index >= 8) {
            if (isCorrect(data, result)) answer++;
            return;
        }
        for (int i=0 ; i<visited.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int originResultLength = result.length();
                result += friends[i];

                dfs(index+1, data, visited, result);

                result = result.substring(0, originResultLength);
                visited[i] = false;
            }
        }
    }

    public boolean isCorrect(String[] data, String result) {
        for (String eachData : data) {
            String firstFriend = String.valueOf(eachData.charAt(0));
            String secondFriend = String.valueOf(eachData.charAt(2));
            String comparator = String.valueOf(eachData.charAt(3));
            int amount = eachData.charAt(4) - '0';
            
            int firstFriendIndex = result.indexOf(firstFriend);
            int secondFriendIndex = result.indexOf(secondFriend);
            int betweenFriends = Math.abs(firstFriendIndex - secondFriendIndex) - 1;
            
            if (comparator.equals("=")) {
                if (betweenFriends != amount) return false;
            } else if (comparator.equals(">")) {
                if (betweenFriends <= amount) return false;
            } else {
                if (betweenFriends >= amount) return false;
            }
        }
        return true;
    }
}


// 22 05 09
// class Solution {
// 	int answer = 0;
//     String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
// 	public int solution(int n, String[] data) {  
// 		dfs(0, data, new boolean[8], "");
// 		return answer;
// 	}

// 	public void dfs(int pos, String[] data, boolean[] visited, String result) {
// 		if (result.length() >= 8) {
// 			if (isCorrect(data, result)) answer+=1;
// 		}
// 		for (int i=0 ; i<8 ; i++) {
// 			if (!visited[i]) {
// 				visited[i] = true;
// 				result += friends[i];
// 				dfs(pos+1, data, visited, result);
// 				result = result.substring(0,result.length()-1);
// 				visited[i] = false;
// 			}
// 		}
// 	}

// 	public boolean isCorrect(String[] data, String result) {
// 		for (String each : data) {
// 			int distance = Math.abs(result.indexOf(each.charAt(0)) - result.indexOf(each.charAt(2))) - 1;
// 			String comparator = String.valueOf(each.charAt(3));
// 			int compareValue = Integer.parseInt(String.valueOf(each.charAt(4)));
// 			if (comparator.equals("=")) {
// 				if (distance != compareValue) return false;
// 			} else if (comparator.equals(">")) {
// 				if (distance <= compareValue) return false;
// 			} else {
// 				if (distance >= compareValue) return false;
// 			}
// 		}
// 		return true;
// 	}
// }
