package prc.recursion;

import java.util.Arrays;

public class KeyPress {
	static int optimalKeys(int n) {
		int m[] = new int[n + 1];
		Arrays.fill(m, -1);
		return minKeyPress(n, 0, 0, m);
	}

	private static int minKeyPress(int n, int cl, int s, int m[]) {
		if (n == 0) {
			return s;
		}
		if (m[n] != -1) {
			return m[n];
		}
		int v1 = 0, v2 = 0, v3 = 0;
		if (cl != 0) {
			v1 = minKeyPress(n - 1, cl, s + cl, m);
			if (n >= 3 && s != 0) {
				v2 = minKeyPress(n - 3, s, s * 2, m);
			}
			v3 = minKeyPress(n - 1, 0, s + 1, m);
		} else {
			if (n >= 3 && s != 0) {
				v2 = minKeyPress(n - 3, s, s * 2, m);
				v3 = minKeyPress(n - 1, 0, s + 1, m);
			} else {
				v3 = minKeyPress(n - 1, 0, s + 1, m);
			}
		}
		m[n] = Math.max(v2, Math.max(v1, v3));
		return m[n];
	}

	public static void main(String[] args) {
		System.out.println(optimalKeys(11));
	}
}
