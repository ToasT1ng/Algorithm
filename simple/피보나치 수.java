class Solution {
	public static void main(String[] args) {
		print(1, fibo(1));
		print(2, fibo(3));
		print(3, fibo(4));
		print(5, fibo(5));
		print(610, fibo(15));
		System.out.println();
		print(1, fibo(1));
		print(2, fibo2(3));
		print(3, fibo2(4));
		print(5, fibo2(5));
		print(610, fibo2(15));
		System.out.println();
		print(1, fibo(1));
		print(2, fibo3(3));
		print(3, fibo3(4));
		print(5, fibo3(5));
		print(610, fibo3(15));
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

	// O(2^n)
	public static int fibo(int end) {
		if (end < 3) {
			return 1;
		}
		return fibo(end-1) + fibo(end-2);
	}

	// O(n)
	public static int fibo2(int end) {
		int first = 1;
		int second = 1;
		for (int i=3 ; i<=end ; i++) {
			int temp = second;
			second = first + second;
			first = temp;
		}
		return second;
	}
	
	// O(n)
	public static int fibo3(int end) {
		int[] arr = new int[2];
		arr[0] = 1;
		arr[1] = 1;
		for (int i=3 ; i<=end ; i++) {
			int temp = arr[1];
			arr[1] = arr[0] + arr[1];
			arr[0] = temp;
		}
		return arr[1];
	}
}
