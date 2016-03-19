package dynamic_programming;

// https://www.youtube.com/watch?v=Y0ZqKpToTic&index=4&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
public class MinimumNumberOfCoins {
	public static void minimumCoins(int number, int[] coins) {
		int[][] dp = new int[coins.length + 1][number + 1];
		for (int i = 0; i < coins.length + 1; i++) {
			for (int j = 0; j < number + 1; j++) {
				if (i == 0) {
					dp[i][j] = Integer.MAX_VALUE;
				} else if (j == 0) {
					dp[i][j] = 0;
				} else {
					if (j >= coins[i - 1]) { // Coin value should be great than
												// equal to i
						dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]],
								dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		System.out.println(dp[coins.length][number]);
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3 };
		MinimumNumberOfCoins.minimumCoins(5, input);
	}
}
