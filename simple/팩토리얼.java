class Solution {
	public static void main(String[] args) {
		print(1, factorial(1));
		print(2, factorial(2));
		print(6, factorial(3));
		print(120, factorial(5));
		print(3628800, factorial(10));
		System.out.println();
		print(1, factorial2(1));
		print(2, factorial2(2));
		print(6, factorial2(3));
		print(120, factorial2(5));
		print(3628800, factorial2(10));
	}

	public static void print(int expected, int result) {
		StringBuilder builder = new StringBuilder();
		builder.append("expected: ");
		builder.append(expected);
		builder.append(" // result: ");
		builder.append(result);
		builder.append(" // ");
		builder.append(expected == result);
		System.out.println(builder);
	}

	// O(n)
	public static int factorial(int end) {
		if (end <= 1) {
			return 1;
		}
		return end * factorial(end-1);
	}

	// O(n)
	public static int factorial2(int end) {
		int result = 1;
		for (int i=2 ; i<=end ; i++) {
			result *= i;
		}
		return result;
	}
}
