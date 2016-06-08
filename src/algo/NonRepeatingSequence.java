package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 *  For example, the longest substrings without repeating characters for 
 *  “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6. 
 *  For “BBBB” the longest substring is “B”, with length 1. For “GEEKSFORGEEKS”, 
 *  there are two longest substrings shown in the below diagrams, with length 7.
 */
public class NonRepeatingSequence {
	Set<Character> unique = new HashSet<Character>();
	Hashtable<String, Integer> t = new Hashtable<String, Integer>();

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		Map<Character, Integer> uniqueCharIndex = new HashMap<Character, Integer>();
		int max = 0;
		int currMax = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// Repeating character
			if (uniqueCharIndex.containsKey(c)) {
				currMax = 0;
				int startIndex = uniqueCharIndex.get(c); // last occurrence of
															// duplicate
															// character
				uniqueCharIndex.clear();
				/*
				 * Remove all characters. And add characters which are unique
				 * up till now. i.e between startIndex+1 to i
				 */
				for (int j = startIndex + 1; j <= i; j++) {
					uniqueCharIndex.put(s.charAt(j), j);
					currMax++;
				}
			} else {
				// Unique. Add it to the map with index value.
				uniqueCharIndex.put(c, i);
				currMax++;
			}
			if (max < currMax) {
				max = currMax;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		NonRepeatingSequence n = new NonRepeatingSequence();
		System.out.println(n.lengthOfLongestSubstring("dvdf"));
		System.out.println(n.lengthOfLongestSubstring("GEEKSFORGEEKS"));
		System.out.println(n.lengthOfLongestSubstring("BBBB"));
	}
}
