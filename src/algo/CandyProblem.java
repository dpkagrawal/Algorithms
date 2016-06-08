package algo;

/*
 Problem: https://leetcode.com/problems/candy/
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class CandyProblem {
	public int candy(int[] ratings) {
		if (ratings.length == 0)
			return 0;
		int[] candies = new int[ratings.length];
		candies[0] = 1;
		/*
		 * left to right if (increasing pair) then add 1 to previous number of
		 * candies
		 */
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i - 1] < ratings[i]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}
		/*
		 * Right to left if(increasing pair) then add 1 to previous number of
		 * candies
		 */
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
				candies[i] = candies[i + 1] + 1;
			}
		}
		int result = 0;
		for (int i = 0; i < candies.length; i++) {
			result += candies[i];
		}
		return result;
	}
	
	public static void main(String[] args){
		CandyProblem cp = new CandyProblem();
		int [] input = {1,4,5,6,2,1};
		System.out.println("Candies: " + cp.candy(input));
	}
}
