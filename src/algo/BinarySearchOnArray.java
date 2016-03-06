package algo;

public class BinarySearchOnArray {
	public static int findNumber(int[] input, int number) {
		return findNumber(input, number, 0, input.length - 1);
	}

	public static int findNumber(int[] input, int number, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (input[mid] == number)
				return mid;
			else if (number < input[mid])
				return findNumber(input, number, start, mid - 1);
			else
				return findNumber(input, number, mid + 1, end);
		} else {
			return -1;
		}
	}
	/*
	 * Original Array: 1, 2, 3, 4, 5, 6, 7
	 * 
	 * Rotated Arrays: 7, 6, 1, 2, 3, 4, 5 4, 5, 6, 7, 1, 2, 3
	 * 
	 * Search for : 5, 7, 3
	 */
	public static int findInRotatedArray(int[] input, int number, int start,
			int end) {
		if (start > end) {
			return -1;
		}
			int mid = (start + end) / 2;
			if (input[mid] == number)
				return mid;
			else if(input[start] < input[mid]){
				if(number <= input[mid] && number >= input[start]){
					return findInRotatedArray(input, number, start, mid-1);
				} else
					return findInRotatedArray(input, number, mid+1, end);
			} else {	
				if(number >= input[mid] &&  number <= input[end])
					return findInRotatedArray(input, number, mid+1, end);
				else
					return findInRotatedArray(input, number, start, mid-1);
			}
}


	public static void main(String[] args) {
		int[] input = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < input.length; i++) {
			System.out.println("number: " + input[i] + " postion: "
					+ BinarySearchOnArray.findNumber(input, input[i]));
		}
		System.out.println(BinarySearchOnArray.findNumber(input, 12));
		int[] inputRotated = new int[] { 3, 4, 5, 6, 7, 8, 9, 0, 1, 2 };
		for (int i = 0; i < inputRotated.length; i++) {
			System.out.println("number: "
					+ inputRotated[i]
					+ " postion: "
					+ BinarySearchOnArray.findInRotatedArray(inputRotated,
							inputRotated[i], 0, inputRotated.length - 1));
		}
	}
}
