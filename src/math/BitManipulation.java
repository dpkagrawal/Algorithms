package math;
/*
 * 
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 * The unsigned right shift operator ">>>" shifts a zero into the leftmost position,
 * while the leftmost position after ">>" depends on sign extension.
 */
public class BitManipulation {
	public static int reverseBits(int n) {
		int m = 0;
		int tmp = n;
		for (int i = 0; i < 32; i++) {
			m = (m << 1) | (tmp & 1);
			tmp >>>= 1;
		}
		return m;
	}

	
	/*
	 * Number of one's in an integer
	 */
	public static int hammingWeight(int n) {
		int count = 0;
		while (n > 0) {
			int t = n & 1;
			if (t == 1) {
				count++;
			}
			n >>>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(4));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(hammingWeight(Integer.MAX_VALUE));
	}
}
