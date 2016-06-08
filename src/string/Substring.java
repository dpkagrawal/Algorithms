package string;

import java.util.Arrays;

public class Substring {
	/**
     * KMP algorithm of pattern matching.
     */
	public static boolean substringMatch(char[] text, char[] pattern) {
		int lps[] = computeTemporaryArray(pattern);
		int i = 0;
		int j = 0;
		for(int k=0; k < lps.length; k++){
			System.out.print(lps[k] + " ");
		}
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == pattern.length) {
			return true;
		}
		return false;
	}

	private static int[] computeTemporaryArray(char pattern[]) {
		int[] lps = new int[pattern.length];
		int index = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[i] == pattern[index]) {
				lps[i] = index + 1;
				index++;
				i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		System.out.println(Substring.substringMatch("acbbacaasd".toCharArray(), "acbbaca".toCharArray()));
	}
}
