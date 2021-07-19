package prc.dp;

import java.util.Arrays;

public class UnboundedKnapsack {
	static int knapSack(int n, int wt, int v[], int w[]) {
		return knapSacktd(n, wt, v, w);
	}

	static int knapSacktd(int n, int wt, int v[], int w[]) {
		int t[][] = new int[n + 1][wt + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= wt; j++) {
				if (w[i - 1] > j) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - w[i - 1]] + v[i - 1]);
				}
			}
		}
		return t[n][wt];
	}

	static int knapSackMem(int n, int wt, int v[], int w[], int m[][]) {
		if (n == 0 || wt == 0) {
			return 0;
		}
		if (m[n][wt] != -1) {
			return m[n][wt];
		}
		if (w[n - 1] > wt) {
			int v1 = knapSackMem(n - 1, wt, v, w, m);
			m[n][wt] = v1;
			return v1;
		} else {
			int v1 = knapSackMem(n - 1, wt, v, w, m);
			int v2 = v[n - 1] + knapSackMem(n, wt - w[n - 1], v, w, m);
			m[n][wt] = Math.max(v1, v2);
			return m[n][wt];
		}
	}

	public static void main(String[] args) {
		System.out.println(knapSack(4, 8, new int[] { 1, 4, 5, 7 }, new int[] { 1, 3, 4, 5 }));
	}
}
