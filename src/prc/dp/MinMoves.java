package prc.dp;

import java.util.Arrays;

public class MinMoves {
	public int minMoves2(int[] a) {
		Arrays.sort(a);
		int avg = a[(a.length - 1) / 2];
		int r = 0;
		for (int i = 0; i < a.length; i++) {
			r += Math.abs(avg - a[i]);
		}
		return r;
	}
}
