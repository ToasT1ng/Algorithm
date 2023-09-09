class BinarySearch {
	public boolean search(int start, int end, int find) {
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;

			if (mid == find) return true;

			if (find < mid) end = mid - 1;
			else start = mid + 1;
		}

		return false;
	}
}

class Main {
	public static void main(String[] args) {
		BinarySearch s = new BinarySearch();
		System.out.println(print(s.search(1, 10, 4), true));
		System.out.println(print(s.search(1, 10, 11), false));
		System.out.println(print(s.search(1, 11, 11), true));
	}

	public static <T> String print(T result, T expected) {
		String message = " ==> result " + result + " / expected " + expected;
		if (result.equals(expected)) return "맞았습니다" + message;
		else return "틀렸습니다" + message;
	}
}
