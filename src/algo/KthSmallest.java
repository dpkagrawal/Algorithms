package algo;

// https://en.wikipedia.org/wiki/Quickselect
public class KthSmallest {
	static int quickSortNew(int[] input, int low, int high, int nthLargest) {
		if (low == high)
			return input[low];
		int p = partition(input, low, high);
		if(nthLargest==p)
			return input[p];
		else if(nthLargest< p)
			return quickSortNew(input, low, p - 1, nthLargest);
		else
			return quickSortNew(input, p + 1, high, nthLargest);
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
		int[] values = { -1,9, 8, 6, 7, 3, 5, 4, 1, 2 };
		for(int i=0;i<values.length;i++)
			System.out.println(i+1+ "th smallest: " +KthSmallest.quickSortNew(values, 0, values.length - 1, i));
	}
}
