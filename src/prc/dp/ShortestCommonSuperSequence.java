package prc.dp;

public class ShortestCommonSuperSequence {
	public static int shortestCommonSupersequence(String x, String y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1] + 1;
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		int l = t[m][n];
		System.out.println(t[m][n]);
		return x.length() + y.length() - l;
	}

	public static void main(String[] args) {
		System.out.println(shortestCommonSupersequence("BACB", "BBAB", 4, 4));
	}
}
