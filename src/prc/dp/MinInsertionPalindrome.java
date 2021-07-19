package prc.dp;

public class MinInsertionPalindrome {
	public int minInsertions(String s) {
		int lcs = lcs(s, new StringBuilder(s).reverse().toString());
		System.out.println(lcs);
		return s.length() - lcs;
	}

	private static int lcs(String s1, String s2) {
//		System.out.println("strin: " + s1 + " " + s2);
		int n1 = s1.length();
		int n2 = s2.length();

		int t[][] = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					t[i][j] = 1+t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		return t[n1][n2];
	}
}
