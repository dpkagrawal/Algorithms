package dynamic_programming;
public class LevensteinDistance {
	int LevenshteinDistance(String s, int len_s, String t, int len_t) {
		int cost;
		/* base case: empty strings */
		if (len_s == 0)
			return len_t;
		if (len_t == 0)
			return len_s;
		/* test if last characters of the strings match */
		if (s.charAt(len_s - 1) == t.charAt(len_t - 1))
			cost = 0;
		else
			cost = 1;
		/*
		 * return minimum of delete char from s, delete char from t, and delete
		 * char from both
		 */
		int minValue = Math.min(
				LevenshteinDistance(s, len_s - 1, t, len_t),
				LevenshteinDistance(s, len_s, t, len_t - 1));
		minValue = Math.min(minValue,
				LevenshteinDistance(s, len_s - 1, t, len_t - 1) )+ cost;
		return minValue;
	}

	int levenshteinDistanceDP(String s, String t) {
		int[][] cost = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < s.length() + 1; i++) {
			for (int j = 0; j < t.length() + 1; j++) {
				// Initializing the cost
				if (i == 0)
					cost[i][j] = j;
				else if (j == 0)
					cost[i][j] = j;
				else {
					int currentCost;
					if (s.charAt(i - 1) == t.charAt(j - 1))
						currentCost = 0;
					else
						currentCost = 1;
					int min = Math.min(cost[i - 1][j - 1], cost[i][j - 1]);
					min = Math.min(cost[i - 1][j], min);
					cost[i][j] = min + currentCost;
				}
			}
		}
		return cost[s.length()][t.length()];
	}

	public static void main(String[] args) {
		LevensteinDistance ld = new LevensteinDistance();
		System.out.println(ld.LevenshteinDistance("gumbo", 5, "gambol", 6));
		;
		System.out.println(ld.levenshteinDistanceDP("gumbo", "gambol"));
	}
}
