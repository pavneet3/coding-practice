package prc.dp;

public class LongestCommonSubstring {
	int longestCommonSubstr(String s1, String s2, int n, int m) {
		int t[][] = new int[n + 1][m + 1];
		int r = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
					r = Math.max(t[i][j], r);
				} else {
					t[i][j] = 0;
				}
			}
		}
		return r;
	}
}
