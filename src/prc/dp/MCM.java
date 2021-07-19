package prc.dp;

import java.util.Arrays;

public class MCM {

	static int matrixMultiplication(int N, int arr[]) {
		int t[][] = new int[N + 1][N + 1];
		for (int i = 0; i < t.length; i++) {
			Arrays.fill(t[i], -1);
		}
		return minCost(arr, 1, N - 1, t);
	}

	private static int minCost(int[] a, int i, int j, int dp[][]) {
		if (i >= j) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int m = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int t = minCost(a, i, k, dp) + minCost(a, k + 1, j, dp) + (a[i - 1] * a[k] * a[j]);
			if (t < m) {
				m = t;
			}
		}
		dp[i][j] = m;
		return m;
	}

	public static void main(String[] args) {
		System.out.println(matrixMultiplication(4, new int[] { 10, 30, 5, 60 }));
	}
}
