import java.util.*;

class BfsEntire {
	public void print(String[] input) {
		for (int i=0 ; i<input.length  ; i++) {
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

			for (int i=0 ; i<input.length ; i++) {
				if (visited[i]) continue;

				queue.offer(input[i]);
				visited[i] = true;
				currentResult += input[i];

				if (currentResult.length() >= 4) {
					System.out.println(currentResult);
					currentResult = currentResult.substring(0, 2);
				}
			}
		}
	}

}

class Main {
	public static void main(String[] args) {
		BfsEntire bfsEntire = new BfsEntire();
		bfsEntire.print(new String[]{"ab", "cd", "ef"});

		/// abcd
		/// abef
		/// cdab
		/// cdef
		/// ...
		
	}
}