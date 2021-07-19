package prc.dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
	static int longestSubsequence(int size, int a[]) {
		int b[] = new int[size];
		Arrays.fill(b, 1);
		int m = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && b[j] >= b[i]) {
					b[i] = b[j] + 1;
					m = Math.max(m, b[i]);
				}
			}
		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println();
	}
}
