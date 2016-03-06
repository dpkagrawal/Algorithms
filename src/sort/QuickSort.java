package sort;
//https://en.wikipedia.org/wiki/Quicksort
public class QuickSort {

	static void quickSortNew(int[] input, int low, int high) {
		if (low < high) {
			int p = partition(input, low, high);
			print(input);
			quickSortNew(input, low, p - 1);
			quickSortNew(input, p + 1, high);
		}
	}

	static int partition(int[] input, int low, int high) {
		int pivot = input[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (input[j] <= pivot) {
				swap(input, i, j);
				i++;
			}
		}
		swap(input, i, high);
		return i;
	}

	static void swap(int[] input, int index1, int index2) {
		int t = input[index1];
		input[index1] = input[index2];
		input[index2] = t;
	}

	static void print(int[] input) {
		for (Integer n : input) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// int[] values = {9,7,5,6,11,12,2,14,3,10,12, 6};
		int[] values = { 9, 8, 6, 7, 3, 5, 4, 1, 2 };
		int a[] = { 4, 9, 4, 4, 1, 2, 9, 4, 4, 9, 4, 4, 1, 4 };
		QuickSort.print(values);
		QuickSort.quickSortNew(values, 0, values.length - 1);
		QuickSort.print(values);
		// QuickSort.print(values);
	}
}
