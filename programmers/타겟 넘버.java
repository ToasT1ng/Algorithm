class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        // 양, 음 두가지 케이스.
        // for 문을 돌면서 양의 케이스 먼저하고 음의 케이스 먼저하고 해야됨.
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int index, int result, int[] numbers, int target) {
        for(int i=index ; i<numbers.length ; i++) {
            result += numbers[i];
            dfs(i+1, result, numbers, target);
            result -= numbers[i];
            result -= numbers[i];
        }
        if (result == target) {
            answer++;
        }
    }
}

// 22 05 09
// import java.util.*;

// class Solution {
// 	int answer = 0;
// 	public int solution(int[] numbers, int target) {
// 		dfs(0, numbers, new boolean[numbers.length], target, 0);	
// 		return answer;
// 	}

// 	public void dfs(int pos, int[] numbers, boolean[] visited, int target, int result) {
// 		for (int i=pos ; i<numbers.length ; i++) {
// 			if (!visited[i]) {
// 				visited[i] = true;
// 				result += numbers[i];
				
// 				dfs(i+1, numbers, visited, target, result);

// 				result -= numbers[i];
// 				result -= numbers[i];
// 				visited[i] = false;
// 			}
// 		}
//         if (result == target) answer++; 
// 	}
// }
