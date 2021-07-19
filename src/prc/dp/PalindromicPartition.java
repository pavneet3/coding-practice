package prc.dp;

import java.util.Arrays;

public class PalindromicPartition {
	static int palindromicPartition(String s) {
		int t[][] = new int[s.length() + 1][s.length() + 1];
		for (int i = 0; i < t.length; i++) {
			Arrays.fill(t[i], -1);
		}
		return pp(s, 0, s.length() - 1, t);
	}

	private static int pp(String s, int i, int j, int t[][]) {
		if (i >= j) {
			return 0;
		}
		if (t[i][j] != -1) {
			return t[i][j];
		}
		System.out.println("i : j : " + i + " " + j);
		String ss = s.substring(i, j + 1);
		System.out.println("subs : " + ss);
		if (isP(ss)) {
			t[i][j] = 0;
			return 0;
		}
		int m = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			int v = pp(s, i, k, t) + pp(s, k + 1, j, t);
			if (isP(s.substring(i, k + 1)) && isP(s.substring(k + 1, j + 1))) {
				v = v + 1;
			}
			m = Math.min(m, v);
		}
		t[i][j] = m;
		return m;
	}

	private static boolean isP(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		String ns = new StringBuilder(s).reverse().toString();
		return ns.equals(s);
	}

	public static void main(String[] args) {
		System.out.println(palindromicPartition("aab"));
	}
}
