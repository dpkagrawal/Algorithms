public class TrapWater {
	static int trap(int A[], int n) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		if (n < 2) {
			return 0;
		}
		int[] l = new int[n];
		int[] r = new int[n];
		int water = 0;
		l[0] = 0;
		for (int i = 1; i < n; i++) {
			l[i] = Math.max(l[i - 1], A[i - 1]);
		}
		r[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			r[i] = Math.max(r[i + 1], A[i + 1]);
		}
		for (int i = 0; i < l.length; i++) {
			System.out.print(l[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
		for (int i = 0; i < n; i++) {
			if (Math.min(l[i], r[i]) - A[i] > 0) {
				water += Math.min(l[i], r[i]) - A[i];
			}
		}
		return water;
	}

	public static void main(String[] args) {
		int[] n = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(TrapWater.trap(n, n.length));
	}
}
