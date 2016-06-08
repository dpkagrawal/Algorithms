package string;
import java.util.HashMap;
import java.util.Map;
/*
 * Link: http://articles.leetcode.com/finding-minimum-window-in-s-which/
 * 
 * Given a set T of characters and a string S, find the minimum window in S which will 
 * contain all the characters in T in complexity O(n).
	eg,
	S = “ADOBECODEBANC”
	T = “ABC”
	
	Minimum window is “BANC”.
 */

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || t == null)
			return "";

		if (t.length() > s.length()) {
			return "";
		}

		Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
		Map<Character, Integer> foundTillNow = new HashMap<Character, Integer>();
		int count = 0;
		int startIndex = 0;
		int endIndex = 0;
		int globalStartIndex = -1;
		int globalEndIndex = -1;
		int minLength = Integer.MAX_VALUE;

		/*
		 * 
		 * Calculating number of occurrence for each character
		 */
		for (Character c : t.toCharArray()) {
			if (needToFind.containsKey(c)) {
				needToFind.put(c, needToFind.get(c) + 1);
			} else {
				needToFind.put(c, 1);
			}
		}

		while (endIndex < s.length()) {
			char c = s.charAt(endIndex);
			// If the character is present in T
			if (needToFind.containsKey(c)) {
				// Updating count in foundTillNow
				if (foundTillNow.containsKey(c)) {
					foundTillNow.put(c, foundTillNow.get(c) + 1);
				} else {
					foundTillNow.put(c, 1);
				}


				// Keep track of number of characters found from T
				if (foundTillNow.get(c) <= needToFind.get(c)) {
					count++;
				}

				// if count match the length, we have found all characters.
				if (count == t.length()) {
					/*
					Increment startIndex till the condition is valid. ie
					needToFind.get(cStart) < foundTillNow.get(cStart)
					*/
					
					char cStart = s.charAt(startIndex);
					while (!foundTillNow.containsKey(cStart)
							|| needToFind.get(cStart) < foundTillNow
									.get(cStart)) {
						if (foundTillNow.containsKey(cStart)
								&& needToFind.get(cStart) < foundTillNow
										.get(cStart)) {
							foundTillNow.put(cStart,
									foundTillNow.get(cStart) - 1);
						}
						startIndex++;
						cStart = s.charAt(startIndex);
					}
					System.out.println(startIndex);
					int windowLength = (endIndex - startIndex) + 1;
					if (windowLength < minLength) {
						minLength = windowLength;
						globalStartIndex = startIndex;
						globalEndIndex = endIndex;
						System.out.println(s.substring(globalStartIndex, globalEndIndex + 1));
					}
				}
			}
			endIndex++;
		}
		return count == t.length() ? s.substring(globalStartIndex, globalEndIndex + 1): "";
	}

	public static void main(String[] args) {
		MinimumWindowSubstring t = new MinimumWindowSubstring();
		System.out.println(t.minWindow("ADOBECODEBANC", "ABC"));
	}
}
