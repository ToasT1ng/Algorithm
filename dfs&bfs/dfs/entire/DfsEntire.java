class DfsEntire {
	public void print(String[] input) {
		dfs(0, "", new boolean[input.length], input);
	}

	public void dfs(int index, String result, boolean[] visited, String[] input) {
		if (result.length() >= input.length * 2) {
			System.out.println(result);
			return;
		}

		for (int i=0 ; i<input.length ; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int length = result.length();
				result += input[i];

				dfs(index+1, result, visited, input);

				result = result.substring(0, length);
				visited[i] = false;
			}
		}
		System.out.println("==== " + result);
	}
}


class Main {
	public static void main(String[] args) {
		DfsEntire dfsEntire = new DfsEntire();
		dfsEntire.print(new String[]{"ab", "cd", "ef", "gh"});

		// abcdefgh
		// ==== abcdef
		// abcdghef
		// ==== abcdgh
		// ==== abcd
		// abefcdgh
		// ==== abefcd
		// abefghcd
		// ==== abefgh
		// ==== abef
		// ...
	}
}