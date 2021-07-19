package prc.dp;

public class CoinChange {
//	public static long count(int s[], int m, int n) {
////		if (n == 0) {
////			return 1;
////		}
////		if (m == 0 && n != 0) {
////			return 0;
////		}
////		if (s[m - 1] > n) {
////			return count(s, m - 1, n);
////		} else {
////			return count(s, m - 1, n) + count(s, m, n - s[m - 1]);
////		}
//		return countTd(s, m, n);
//	}

	public static long count(int s[], int m, int n) {
		long t[][] = new long[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			t[i][0] = 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s[i - 1] > j) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j] + t[i][j - s[i - 1]];
				}
			}
		}
		return t[m][n];
	}

	public static void main(String[] args) {
		System.out.println(count(new int[] { 1, 2, 3, 4, 7, 8, 9, 11 }, 8, 7));
	}
}
