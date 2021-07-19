package prc.dp;

public class MinCoinChange {
	public static int minCoins(int s[], int m, int n) {
		int t[][] = new int[m + 1][n + 1];
//		for (int i = 0; i <= m; i++) {
//			t[i][0] = 1;
//		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s[i - 1] > j) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - s[i - 1]]);
				}
			}
		}
		return t[m][n];

	}

	public static int minCoinsr(int s[], int m, int n) {
		
	}

	public static void main(String[] args) {
		System.out.println(minCoins(new int[] { 25, 10, 5 }, 3, 30));
	}
}
