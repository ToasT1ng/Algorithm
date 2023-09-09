import java.util.*;

class BfsPart {
	public void print(String[] input) {
		for (int i=0 ; i<input.length ; i++) {
			bfs(i, input, new boolean[input.length]);
		}
	}

	public void bfs(int firstIndex, String[] input, boolean[] visited) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(input[firstIndex]);
		visited[firstIndex] = true;

		String currentResult = "";
		while (!queue.isEmpty()) {
			String current = queue.poll();
			currentResult += current;

			for (int i=firstIndex ; i<input.length ; i++) {
				if (visited[i]) continue;

				visited[i] = true;
				currentResult += input[i];
			}
		}

		System.out.println(currentResult);
	}
}


class Main {
	public static void main(String[] args) {
		BfsPart bfsPart = new BfsPart();
		bfsPart.print(new String[]{"ab", "cd", "ef"});

		// abcdef
		// cdef
		// ef
	}
}