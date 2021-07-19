package prc.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSequence {
	static Map<String, Integer> m = new HashMap<>();

	static int lcs(String s1, String s2) {
		int t[][] = new int[s1.length() + 1][s2.length() + 1];
		return lcstd(s1.length() - 1, s2.length() - 1, s1, s2, t);
	}

	private static int lcstd(int x, int y, String s1, String s2, int[][] t) {
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1] + 1;
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		return t[x][y];
	}

	private static int lcsc(int x, int y, String s1, String s2) {
		if (x == -1 || y == -1) {
			return 0;
		}
		if (m.containsKey(createKey(x, y))) {
			System.out.println("map : " + m + " x,y " + x + " " + y);
			return m.get(createKey(x, y));
		}
		if (s1.charAt(x) == s2.charAt(y)) {
			int v = lcsc(x - 1, y - 1, s1, s2) + 1;
			m.put(createKey(x - 1, y - 1), v);
			return v;
		} else {
			int v1 = lcsc(x - 1, y, s1, s2);
			int v2 = lcsc(x, y - 1, s1, s2);
			if (x > 0) {
				m.put(createKey(x - 1, y), v1);
			}
			if (y > 0) {
				m.put(createKey(x, y - 1), v2);
			}
			return Math.max(v1, v2);
		}
	}

	private static String createKey(int x, int y) {
		return x + "-" + y;
	}

	public static void main(String[] args) {
		System.out.println(lcs("BBAB", "BACB"));
	}
}
