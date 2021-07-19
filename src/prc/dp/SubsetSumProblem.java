package prc.dp;

import java.util.Arrays;

public class SubsetSumProblem {

	public boolean canPartition(int[] nums) {
		return equalPartition(nums.length, nums) == 1 ? true : false;
	}

	static int equalPartition(int n, int a[]) {
		int s = a[0];
		for (int i = 1; i < n; i++) {
			s += a[i];
		}

		if (s % 2 == 1) {
			return 0;
		} else {
			int m[][] = new int[n + 1][(s / 2) + 1];
			for (int i = 0; i < m.length; i++) {
				Arrays.fill(m[i], -1);
			}
			return subsetSum(a, n, s / 2, m);
		}
	}

	private static int subsetSum(int[] a, int n, int t, int[][] m) {
		if (t == 0) {
			return 1;
		}
		if (n == 0 && t != 0) {
			return 0;
		}
		if (m[n][t] != -1) {
			return m[n][t];
		}
		if (a[n - 1] > t) {
			int v = subsetSum(a, n - 1, t, m);
			m[n][t] = v;
			return v;
		} else {
			int v1 = subsetSum(a, n - 1, t - a[n - 1], m);
			int v2 = subsetSum(a, n - 1, t, m);
			m[n][t] = v1 | v2;
			return m[n][t];
		}
	}

	public static void main(String[] args) {
		System.out.println(equalPartition(4, new int[] { 1, 5, 11, 5 }));
	}
}
