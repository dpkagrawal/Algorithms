package algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// http://www.geeksforgeeks.org/maximum-product-subarray/
/*
 *  At each step calculate two values: newMaxLocal , newMinLocal
 *  by multiplying with the current number.
 *  
 *  After which find maxLocal & minLocal from three values:
 *  currentValue,  newMaxLocal , newMinLocal
 *  
 *  Also set global value.
 *  
 */
public class MaximumSubarrayProduct {
	public static int maxProduct(int[] nums) {
		int maxGlobal = nums[0];
		int maxLocal = nums[0];
		int minLocal = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int newMinLocal = minLocal * nums[i];
			int newMaxLocal = maxLocal * nums[i];
			maxLocal = Math.max(Math.max(newMaxLocal, nums[i]), newMinLocal);
			minLocal = Math.min(Math.min(newMaxLocal, nums[i]), newMinLocal);
			maxGlobal = Math.max(maxLocal, maxGlobal);
		}
		return maxGlobal;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader r = new BufferedReader(new FileReader(
				"data/sumofinteger.txt"));
		String line;
		while ((line = r.readLine()) != null) {
			String[] columns = line.split(",");
			int[] input = new int[columns.length];
			for (int i = 0; i < columns.length; i++) {
				input[i] = Integer.parseInt(columns[i].trim());
			}
			System.out.println(maxProduct(input));
		}
	}
}
