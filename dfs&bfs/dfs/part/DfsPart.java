class DfsPart {
	public void print(String[] input) {
		dfs(0, "", input);
	}

	public void dfs(int index, String result, String[] input) {
		if (index >= input.length) {
			System.out.println(result);
			return;
		}

		for (int i=index ; i<input.length ; i++) {
			result += input[i];
			dfs(i+1, result, input);
			result = result.substring(0, result.length()-2);
		}
	}
}


class Main {
	public static void main(String[] args) {
		DfsPart dfsPart = new DfsPart();
		dfsPart.print(new String[]{"ab", "cd", "ef", "gh"});

		// abcdefgh
		// abcdgh
		// abefgh
		// abgh
		// cdefgh
		// cdgh
		// efgh
		// gh
	}
}