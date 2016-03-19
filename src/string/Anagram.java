package string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	// Array is better in performance
	public boolean isAnagramUsingArray(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		if (s.length() == 0 && t.length() == 0)
			return true;
		int[] countCharacter = new int[26];
		for (int i = 0; i < countCharacter.length; i++) {
			countCharacter[i] = 0;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = (int) c % 97;
			if (countCharacter[index] != 0) {
				countCharacter[index] = countCharacter[index] + 1;
			} else {
				countCharacter[index] = 1;
			}
		}
		boolean isValid = true;
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int index = (int) c % 97;
			if (countCharacter[index] != 0) {
				int count = countCharacter[index];
				if (countCharacter[index] == 1) {
					countCharacter[index] = 0;
				} else {
					countCharacter[index] = count - 1;
				}
			} else {
				isValid = false;
				break;
			}
		}
		for (int i = 0; i < countCharacter.length; i++) {
			if (countCharacter[i] != 0) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}
	
	// Array is better in performance

	public boolean isAnagramUsingMap(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		if (s.length() == 0 && t.length() == 0)
			return true;
		Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (characterCount.containsKey(c)) {
				characterCount.put(c, characterCount.get(c) + 1);
			} else {
				characterCount.put(c, 1);
			}
		}
		boolean isValid = true;
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (characterCount.containsKey(c)) {
				int count = characterCount.get(c);
				if (count == 1) {
					characterCount.remove(c);
				} else {
					characterCount.put(c, count - 1);
				}
			} else {
				isValid = false;
				break;
			}
		}
		return isValid && characterCount.isEmpty();
	}
}
