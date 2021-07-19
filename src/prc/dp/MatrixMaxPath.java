package prc.dp;

public class MatrixMaxPath {
	static int maximumPath(int n, int a[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				int ld = i > 0 && j < n - 1 ? a[i - 1][j + 1] + a[i][j] : a[i][j];
				int t = i > 0 ? a[i - 1][j] + a[i][j] : a[i][j];
				int rd = i > 0 && j > 0 ? a[i - 1][j - 1] + a[i][j] : a[i][j];
				a[i][j] = Math.max(t, Math.max(ld, rd));
			}
		}
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			m = Math.max(m, a[n - 1][i]);
		}

		return m;
	}

	public static void main(String[] args) {
		System.out.println(maximumPath(2, new int[][] { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } }));
	}
}
