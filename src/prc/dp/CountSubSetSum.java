package prc.dp;

public class CountSubSetSum {
	public static int numSubseq(int[] a, int t) {
		return numSubSequence(a, t, a.length, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
	}

	private static int numSeq(int[] a, int t, int n) {
		if (t == 0) {
			return 1;
		}
		if (n == 0 && t != 0) {
			return 0;
		}
		if (a[n - 1] > t) {
			return numSeq(a, t, n - 1);
		} else {
			return numSeq(a, t, n - 1) + numSeq(a, t - a[n - 1], n - 1);
		}
	}

	private static int numSubSequence(int[] a, int t, int n, int min, int max, int e) {
		System.out.println("min is : " + min + " max is : " + max);
		if (n == 0) {
			if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
				return 0;
			}
			if (e == 1) {
				if (t >= min) {
					return 1;
				}
			} else {
				if (t >= min + max) {
					return 1;
				}
			}
			return 0;
		}
		if (t == 0) {
			return 0;
		}
		if (a[n - 1] > t) {
			return numSubSequence(a, t, n - 1, min, max, e);
		} else {
			return numSubSequence(a, t, n - 1, min, max, e)
					+ numSubSequence(a, t, n - 1, Math.min(min, a[n - 1]), Math.max(max, a[n - 1]), e + 1);
		}
	}

	private static int numSeqTD(int[] a, int t, int n) {
		int d[][] = new int[n + 1][t + 1];
		for (int i = 0; i <= n; i++) {
			d[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= t; j++) {
				if (a[i - 1] > j) {
					d[i][j] = d[i - 1][j];
				} else {
					d[i][j] = d[i - 1][j - a[i - 1]] + d[i - 1][j];
				}
			}
		}
		return d[n][t];
	}

	public static void main(String[] args) {
		System.out.println(numSubseq(new int[] { 3,5,6,7 }, 9));
	}
}
