import java.util.*;

class Solution {
	public void solution(int[] input) {
		dfs_all(0, input, new boolean[input.length], "");
		System.out.println("===============");
		dfs_limit(0, input);
		System.out.println("===============");
	}

	public void dfs_all(int index, int[] input, boolean[] visited, String result) {
		if (index >= input.length) {
			System.out.println(result);
			return;
		}
		for (int i=0 ; i<input.length ; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int beforeLength = result.length();
				result += String.valueOf(input[i]);
				dfs_all(index+1, input, visited, result);
				result = result.substring(0, beforeLength);
				visited[i] = false;
			}
		}
	}

	// 0 1 2 3
	// 0 1 3 2
	// 0 2 1 3
	// 0 2 3 1
	// 0 3 1 2
	// 0 3 2 1
	// 1 2 3
	// 1 3 2
	// 2 3
	// 3

	public void dfs_limit(int index, int[] input) {
		boolean[] visited = new boolean[input.length];
		for (int i=0 ; i<input.length ; i++) {
			visited[i] = true;
			String result = String.valueOf(input[i]);
			dfs_all(i+1, input, visited, result);
		}
	}
}

class RunClass {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] input = {0,1,2,3};
		s.solution(input);
	}
}
