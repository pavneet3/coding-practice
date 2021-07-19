package prc.dp;

import java.util.Arrays;

public class MinSumPartition {
	public static int minDiffernce(int a[], int n) {
		int t = a[0];
		for (int i = 1; i < n; i++) {
			t += a[i];
		}
		int m[][] = new int[n + 1][t + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(m[i], -1);
		}
		int r = partition(a, n, 0, t, m);
		printA(m);
		return r;
	}

	static void printA(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int partition(int[] a, int n, int s, int t, int m[][]) {
		if (m[n][s] != -1) {
			return m[n][s];
		}
		if (n == 0) {
			int v = Math.abs((t - s) - s);
			m[n][s] = v;
			return v;
		}
		int v1 = partition(a, n - 1, s, t, m);
		int v2 = partition(a, n - 1, s + a[n - 1], t, m);
		m[n][s] = Math.min(v1, v2);
		return m[n][s];
	}

	public static void main(String[] args) {
		System.out.println(minDiffernce(new int[] { 1, 6, 11, 5 }, 4));
	}
}
