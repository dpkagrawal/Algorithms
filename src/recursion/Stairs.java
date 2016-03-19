package recursion;

import java.util.HashMap;

/*  CTCI: Recursion 9.1
 * 
 *   A child is running up a staircase with n steps, and can hop either 1,2, or 3
 *   steps at a time. Implement a method to count how many possible ways the child
 *   can run up the stairs
 */
public class Stairs {
	public static int differentWays(int n, int current) {
		if(n < 0)
			return 0;
		if (current == n)
			return 1;
		int remainder = n - current;
		int count = 0;
		if (remainder >= 1) {
			count += differentWays(n, current + 1);
		}
		if (remainder >= 2) {
			count += differentWays(n, current + 2);
		}
		if (remainder >= 3) {
			count += differentWays(n, current + 3);
		}
		return count;
	}

	public static int countWays(int n) {
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

	public static int countWays(int n, HashMap<Integer, Integer> cache) {
		if (cache.containsKey(n))
			return cache.get(n);
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else {
			int count = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
			cache.put(n, count);
			return count;
		}
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(Stairs.differentWays(n, 0));
		System.out.println(Stairs.countWays(n));
		System.out
				.println(Stairs.countWays(n, new HashMap<Integer, Integer>()));
	}
}
