package leetcode.june;

import java.util.Arrays;

public class InterleavingString {
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s3 == "" && s1 == "" && s3 == "") {
			return true;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		int m[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < m.length; i++) {
			Arrays.fill(m[i], -1);
		}
		return interleaving(s1, s2, s3, s1.length(), s2.length(), s3.length(), m);
	}

	private static boolean interleaving(String s1, String s2, String s3, int n1, int n2, int n3, int m[][]) {
		if (n1 == 0) {
			while (n3 != 0 && n2 != 0) {
				if (s3.charAt(n3 - 1) != s2.charAt(n2 - 1)) {
					return false;
				}
				n3--;
				n2--;
			}
			return true;
		}

		if (n2 == 0) {
			while (n3 != 0 && n1 != 0) {
				if (s3.charAt(n3 - 1) != s1.charAt(n1 - 1)) {
					return false;
				}
				n1--;
				n3--;
			}
			return true;
		}

		if (m[n1][n2] != -1) {
			return m[n1][n2] == 1;
		}

		if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
			if (s1.charAt(n1 - 1) != s3.charAt(n3 - 1)) {
				return false;
			}
			boolean v1 = interleaving(s1, s2, s3, n1 - 1, n2, n3 - 1, m);
			boolean v2 = interleaving(s1, s2, s3, n1, n2 - 1, n3 - 1, m);
			m[n1][n2] = v1 || v2 ? 1 : 0;
			return m[n1][n2] == 1;
		} else if (s1.charAt(n1 - 1) == s3.charAt(n3 - 1)) {
			m[n1][n2] = interleaving(s1, s2, s3, n1 - 1, n2, n3 - 1, m) ? 1 : 0;
			return m[n1][n2] == 1;
		} else if (s2.charAt(n2 - 1) == s3.charAt(n3 - 1)) {
			m[n1][n2] = interleaving(s1, s2, s3, n1, n2 - 1, n3 - 1, m) ? 1 : 0;
			return m[n1][n2] == 1;
		} else {
			m[n1][n2] = 0;
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

}
