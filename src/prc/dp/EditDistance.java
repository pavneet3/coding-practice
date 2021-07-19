package prc.dp;

public class EditDistance {

	public int minDistance(String s, String t) {
		int n = s.length();
		int m = t.length();
		int d[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			d[i][0] = i;
		}
		for (int i = 0; i <= m; i++) {
			d[0][i] = i;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					d[i][j] = Math.min(d[i - 1][j], Math.min(d[i - 1][j - 1], d[i][j - 1])) + 1;
				}
			}
		}
		return d[n][m];
	}

	public int minOperations(String s, String t) {
		int n = s.length();
		int m = t.length();
		int tp[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					tp[i][j] = tp[i - 1][j - 1] + 1;
				} else {
					tp[i][j] = Math.max(tp[i - 1][j], tp[i][j - 1]);
				}
			}
		}
		return (n - tp[n][m]) + (m - tp[n][m]);
//		return Math.max(n, m) - tp[n][m];
	}

	public static void main(String[] args) {
		System.out.println(editDistance("intention", "execution"));
	}
}
