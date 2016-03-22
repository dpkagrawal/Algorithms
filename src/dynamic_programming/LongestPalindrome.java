package dynamic_programming;

public class LongestPalindrome {
	/*
	 * 
	 * Divide the problem in sub-problem and if then solve the sub-problem
	 * LPS(ABCBA) = 2+ LPS(BCB) ...
	 */
	static String longestPalindromeSubtring(String input) {
		String result = "";
		if (input != null) {
			int lengthOfString = input.length();
			if (lengthOfString == 0 || lengthOfString == 1) {
				return input;
			}
			int maxString = 0;
			int start = -1;
			int end = -1;
			Boolean[][] dp = new Boolean[lengthOfString][lengthOfString];
			for (int i = 0; i < lengthOfString; i++) {
				dp[i][i] = true;
			}
			for (int l = 2; l <= lengthOfString; l++) {
				for (int i = 0; i + l <= lengthOfString; i++) {
					int j = i + l - 1;
					if (l == 2) {
						if (input.charAt(i) == input.charAt(j)) {
							dp[i][j] = true;
							maxString = l;
							start = i;
							end = i + l;
						} else {
							dp[i][j] = false;
						}
					} else {
						if (input.charAt(i) == input.charAt(j)
								&& dp[i + 1][j - 1]) {
							dp[i][j] = true;
							maxString = l;
							start = i;
							end = i + l;
						} else {
							dp[i][j] = false;
						}
					}
				}
			}
			if (maxString > 0)
				result = input.substring(start, end);
		}
		return result;
	}

	static String longestPalindromeSubsequence(String input) {
		String result = "";
		if (input != null) {
			int lengthOfString = input.length();
			if (lengthOfString == 0 || lengthOfString == 1) {
				return input;
			}
			int maxString = 0;
			int start = -1;
			int end = -1;
			int[][] dp = new int[lengthOfString][lengthOfString];
			for (int i = 0; i < lengthOfString; i++) {
				dp[i][i] = 1;
			}
			for (int l = 2; l <= lengthOfString; l++) {
				for (int i = 0; i + l <= lengthOfString; i++) {
					int j = i + l - 1;
					if (l == 2) {
						if (input.charAt(i) == input.charAt(j)) {
							dp[i][j] = 2;
						} else {
							dp[i][j] = 1;
						}
					} else {
						if (input.charAt(i) == input.charAt(j)) {
							dp[i][j] = 2 + dp[i + 1][j - 1];
						} else {
							dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
						}
					}
				}
			}
			System.out.println(dp[0][input.length() - 1]);
		}
		return result;
	}

	static void test(Integer a) {
		System.out.println(a);
		a = 10;
		System.out.println(a);
	}

	public static void main(String[] args) {
		String s = "BANANA";
		System.out.println(LongestPalindrome.longestPalindromeSubtring(s));
		s = "ABCD";
		System.out.println(LongestPalindrome.longestPalindromeSubtring(s));
		s = "LPASPAL";
		System.out.println(LongestPalindrome.longestPalindromeSubtring(s));
	}
}
