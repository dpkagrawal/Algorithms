package string;
/*
 *  
 */
public class Permutation {
	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String word) {
		int n = word.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++) {
				String cur = word.substring(i, i + 1);
				String before = word.substring(0, i);
				String after = word.substring(i + 1);
				permutation(prefix + cur, before + after);
			}
		}
	}

	public static void main(String[] args) {
		Permutation.permutation("abc");
	}
}
