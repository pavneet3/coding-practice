package leetcode.june;

public class RefulingStops {
	public static int minRefuelStops(int t, int s, int[][] a) {
		if (a.length == 0) {
			if (t <= s) {
				return 0;
			}
			return -1;
		}
		int mx = minRefuel(t, s, a, 0, 0);
		return mx == Integer.MAX_VALUE ? -1 : mx;
	}

	private static int minRefuel(int t, int s, int[][] a, int i, int c) {
		int t1 = Math.min(a[i][0], t);
		t = t - t1;
		s = s - t1;
		if (t > 0 && s < 0) {
			return Integer.MAX_VALUE;
		}
		if (t == 0) {
			if (s >= 0) {
				return c;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		if (i == a.length - 1) {
			if (s >= 0) {
				return c;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		return Math.min(minRefuel(t, s + a[i][1], a, i + 1, c + 1), minRefuel(t, s, a, i + 1, c));
	}

	public static void main(String[] args) {
		System.out.println(minRefuelStops(100, 50, new int[][] {{50,50}}));
	}
}