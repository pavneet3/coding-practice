package prc.dp;

import java.util.Arrays;

public class CountHops {
	static long countWays(int n) {
		long t[] = new long[n + 1];
		Arrays.fill(t, -1);
		t[0] = 1;
		return countWaysMem(n, t);
	}

	static long countWaysMem(int n, long t[]) {
		if (n < 0) {
			return 0;
		}
		if (t[n] != -1) {
			return t[n];
		}
		if (n == 0) {
			return 1;
		}
		long v1 = countWaysMem(n - 1,t);
		long v2 = countWaysMem(n - 2,t);
		long v3 = countWaysMem(n - 3,t);
		t[n] = v1 + v2 + v3;
		return t[n];
	}

	public static void main(String[] args) {
		System.out.println(countWays(1));
	}
}
