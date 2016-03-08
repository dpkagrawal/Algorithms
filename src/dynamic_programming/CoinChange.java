package dynamic_programming;

public class CoinChange {
	/*
	 * 1) Overlapping Subproblems 2) Optimal Substructure
	 */
	/*
	 * To count total number solutions, we can divide all set solutions in two
	 * sets. 1) Solutions that do not contain mth coin (or Sm). 2) Solutions
	 * that contain at least one Sm. Let count(S[], m, n) be the function to
	 * count the number of solutions, then it can be written as sum of
	 * count(S[], m-1, n) and count(S[], m, n-Sm).
	 */
	static int totalCountRecursive(int number, int[] typesOfCurrency,
			int currentCurrency) {
		if (number == 0)
			return 1;
		if (number < 0)
			return 0;
		if (currentCurrency <= 0 && number > 0)
			return 0;
		return totalCountRecursive(number, typesOfCurrency, currentCurrency - 1) // exclusive
				+ totalCountRecursive(number
						- typesOfCurrency[currentCurrency - 1], // inclusive
						typesOfCurrency, currentCurrency);
	}

	
	/*
	 * https://www.youtube.com/watch?v=_fgjrs570YE
	 * 
	 * 
	 */
	static int totalWays(int number, int[] typesOfCurrency) {
		int[][] dp = new int[typesOfCurrency.length + 1][number + 1];
		for (int row = 0; row <= typesOfCurrency.length; row++) {
			for (int column = 0; column <= number; column++) {
				if (row == 0) {
					dp[row][column] = 0;
				} else if (column == 0) {
					dp[row][column] = 1;
				} else if (column >= typesOfCurrency[row - 1]) {
					dp[row][column] = dp[row - 1][column]
							+ dp[row][column - typesOfCurrency[row - 1]];
				} else {
					dp[row][column] = dp[row - 1][column];
				}
			}
		}
		return dp[typesOfCurrency.length][number];
	}

	public static void main(String[] args) {
		int[] typesOfCurrency = { 1, 2, 3 };
		System.out.println(CoinChange.totalCountRecursive(5, typesOfCurrency,
				typesOfCurrency.length));
		System.out.println(CoinChange.totalWays(5, typesOfCurrency));
	}
}
