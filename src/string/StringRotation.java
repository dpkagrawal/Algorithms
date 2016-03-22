package string;
/*
 * 
 * Solution:
 * s1 = abc
 * s2 = cab
 * 
 * s3 = abccab
 * s3.contains(s2)
 * 
 */

public class StringRotation {
	public void isRotation(String s1, String s2) {
		if (s1 == null && s2 == null) {
			System.out.println("True");
			return;
		}
		if (s1 == null)
			return;
		if (s2 == null)
			return;
		String s3 = s1 + s2;
		if (s3.contains(s2))
			System.out.println("True");
		else
			System.out.println("False");
	}

	public static void main(String[] args) {
		StringRotation sr = new StringRotation();
		sr.isRotation("abc", "cab");
	}
}
