package algo;

/*
 * 
 Inversion Count for an array indicates – how far (or close) the array is from being sorted. 
 If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
 Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

 Example:
 The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

 Solution: Merge Sort
 If we select element from right sub-array there is an inversion(as an element in left sub-array is greater).
 So number of inversions += size of left sub-array - current left index.
 */
public class InversionCount {
	int inversionCount;

	public void countInversion(int[] input) {
		inversionCount = 0;
		mergeSort(input, 0, input.length - 1);
	}

	public void mergeSort(int[] input, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(input, left, mid);
			mergeSort(input, mid + 1, right);
			merge(input, left, mid, right);
		}
	}

	private void merge(int[] input, int left, int mid, int right) {
		int[] leftArray = new int[mid - left + 1];
		int[] rightArray = new int[right - mid];
		for (int i = left, j = 0; i <= mid; i++, j++) {
			leftArray[j] = input[i];
		}
		for (int i = mid + 1, j = 0; i <= right; i++, j++) {
			rightArray[j] = input[i];
		}
		int leftIndex = 0;
		int rightIndex = 0;
		int i = left;
		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] < rightArray[rightIndex]) {
				input[i] = leftArray[leftIndex];
				leftIndex++;
			} else {
				input[i] = rightArray[rightIndex];
				inversionCount += leftArray.length - leftIndex;
				rightIndex++;
			}
			i++;
		}
		while (leftIndex < leftArray.length) {
			input[i] = leftArray[leftIndex];
			i++;
			leftIndex++;
		}
		while (rightIndex < rightArray.length) {
			input[i] = rightArray[rightIndex];
			i++;
			rightIndex++;
		}
	}

	public static void main(String[] args) {
		InversionCount ic = new InversionCount();
		int[] input = { 1, 20, 6, 4, 5 };
		ic.countInversion(input);
		for (Integer i : input)
			System.out.print(i + " ");
		System.out.println("Inversion Count: " + ic.inversionCount);
	}
}
