package prc.dp;

public class MaxLengthSubArray {
	public int findLength(int[] a, int[] b) {
		int t[][] = new int[a.length + 1][b.length + 1];
		int r = 0;
		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1] == b[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
					r = Math.max(t[i][j], r);
				}
			}
		}
		return r;
	}
}
