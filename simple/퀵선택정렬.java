import java.util.*;

class Solution {
	public static void main(String[] args) {
		print(2, quickSelect(new int[]{1,2,5,4,3}, 2));
		print(5, quickSelect(new int[]{5,6,1,4,3,7,2}, 5));
		print(2, quickSelect(new int[]{5,6,1,4,8,3,7,2,9}, 2));
		print(7, quickSelect(new int[]{5,6,1,4,8,3,7,2,9}, 7));
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
	public static int quickSelect(int[] arr, int k) {
		return quickSelect(arr, 0, arr.length-1, k-1);
	}

	public static int quickSelect(int[] arr, int start, int end, int k) {
		if (start <= end) {	
			int middle = partition(arr, start, end);
			if (middle == k) {
				return arr[k];
			} else if (middle > k) {
				return quickSelect(arr, start, middle-1, k);

			} else {
				return quickSelect(arr, middle+1, end, k);
			}
		}

		return -1;
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		while (start < end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			if (start < end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	public static void swap(int[] arr, int start, int end) {
		int temp = arr[end];
		arr[end] = arr[start];
		arr[start] = temp;
	}
}
