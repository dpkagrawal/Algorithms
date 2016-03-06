package algo;

import java.util.HashSet;
import java.util.Hashtable;
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

	public void find(String str) {
		if (str != null && str.length() > 0) {
			String maxString = "";
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (!unique.contains(str.charAt(i))) {
					sb.append(str.charAt(i));
					unique.add(str.charAt(i));
				} else {
					if (maxString.length() < sb.length())
						maxString = sb.toString();
					sb = new StringBuilder();
					sb.append(str.charAt(i));
				}
			}
			System.out.println(maxString);
		}
	}

	public static void main(String[] args) {
		NonRepeatingSequence n = new NonRepeatingSequence();
		n.find("ABDEFGABEF");
		n.find("GEEKSFORGEEKS");
		n.find("BBBB");
	}
}
