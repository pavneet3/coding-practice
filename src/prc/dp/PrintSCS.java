package prc.dp;

public class PrintSCS {
	public static String shortestCommonSupersequence(String s1, String s2) {
		String lcs = lcs(s1, s2);
		return lcs;
	}

	private static String lcs(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int t[][] = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1] + 1;
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}

		return getlcs(t, s1, s2);
	}

	private static String getlcs(int[][] t, String s1, String s2) {
		int i = s1.length();
		int j = s2.length();
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				sb.append(s1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (t[i - 1][j] == t[i][j]) {
					sb.append(s1.charAt(i - 1));
					i--;
				} else {
					sb.append(s2.charAt(j - 1));
					j--;
				}
			}
		}
		while (i > 0) {
			sb.append(s1.charAt(i - 1));
			i--;
		}
		while (j > 0) {
			sb.append(s2.charAt(j - 1));
			j--;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(shortestCommonSupersequence("abac", "cab"));
	}
}
