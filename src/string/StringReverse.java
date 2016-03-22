package string;

public class StringReverse {
	
	/*
	 * Swap first and last of the string
	 */
	public String reverse(String s) {
		if (s ==null || s.length()==0 || s.length() == 1)
			return s;
		char[] charArr = s.toCharArray();
		int start = 0;
		int end = charArr.length-1;
		while (start < end) {
			char t = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = t;
			start++;
			end--;
		}
		return new String(charArr);
	}

	public static void main(String[] args) {
		StringReverse s = new StringReverse();
		System.out.println(s.reverse("deep"));
	}
}
