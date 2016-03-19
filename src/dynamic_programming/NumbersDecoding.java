package dynamic_programming;

/*
 Decode Ways
 A message containing letters from A-Z is being encoded to numbers using the following mapping:
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.
 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 The number of ways decoding "12" is 2.

 */
/*
 Analysis:
 The key to this problem is : num(current) = num(current-1) + num(current-2).
 if current string is : 01 is invalid.
 */

public class NumbersDecoding {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.equals("0"))
			return 0;

		// Array to store previous results
		int[] dp = new int[s.length() + 1];

		// initialize
		dp[0] = 1;


		if (isValid(s.substring(0, 1)))
			dp[1] = 1;
		else
			dp[1] = 0;


		/*
		 *  Current count depends upon previous 1 digit & 2 digit
		 */
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i))) { // Single digit
				dp[i] += dp[i - 1];
			}
			if (isValid(s.substring(i - 2, i))) { // Double digit
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}

	public boolean isValid(String s) {
		if (s.charAt(0) == '0')
			return false;
		int value = Integer.parseInt(s);
		return value >= 1 && value <= 26;
	}

	public static void main(String[] args) {
		NumbersDecoding nd = new NumbersDecoding();
		System.out.println(nd.numDecodings("1234"));
	}
}
