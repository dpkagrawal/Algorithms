package algo;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
	/*
	 * Given an integer array of size n, find all elements that appear more than
	 *  n/3 times. The algorithm should run in linear time and in O(1) space.
	 *  
	 *  Logic:
	 *  Keep two variables for num1 & num2 and their respective counts.
	 *  
	 *  if(unassigned) then assigned it. 
	 *  if current number matches any value num1 or num2, increase corresponding count. 
	 *  otherwise decrease both counts.
	 *  
	 *  Do a second pass to find out which of the element is more than n/3.
	 */
	public static List<Integer> majorityElement(int[] nums) {
		Integer num1 = null;
		Integer num2 = null;
		Integer count1 = 0;
		Integer count2 = 0;
		for (int i = 0; i < nums.length; i++) {

			if (num1 != null && nums[i] == num1) {
				count1++;
			} else if (num2 != null && nums[i] == num2) {
				count2++;
			} else if (count1 == 0) {
				count1 = 1;
				num1 = nums[i];
			} else if (count2 == 0) {
				count2 = 1;
				num2 = nums[i];
			} else {
				count1--;
				count2--;
			}
		}
		
		// second pass to find out which of the element is more than n/3.
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1) {
				count1++;
			} else if (nums[i] == num2) {
				count2++;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		if (count1 > nums.length / 3) {
			result.add(num1);
		}
		if (count2 > nums.length / 3) {
			result.add(num2);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(MajorityElement.majorityElement(new int[] { 1, 1, 1,3, 4, 6, 7 }));
		System.out.println(MajorityElement.majorityElement(new int[] { 1, 1, 1,3, 2, 2, 2 }));
	}
}