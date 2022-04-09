import java.util.*;

class Solution {
	public static void main(String[] args) {
		print(new int[]{1,2,3,4,5}, quick(new int[]{1,2,5,4,3}));
		print(new int[]{1,2,3,4,5,6,7}, quick(new int[]{5,6,1,4,3,7,2}));
	}

	public static void print(int[] expected, int[] result) {
		StringBuilder builder = new StringBuilder();
		builder.append("expected: ");
		builder.append(Arrays.toString(expected));
		builder.append(" // result: ");
		builder.append(Arrays.toString(result));
		System.out.println(builder);
	}

	// O(n log n) or O (n^2)
	public static int[] quick(int[] arr) {
		quickSort(arr, 0, arr.length-1);
		return arr;
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int middle = partition(arr, start, end);
		quickSort(arr, start, middle-1);
		quickSort(arr, middle, end);
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		while (start <= end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			if (start <= end) {
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
