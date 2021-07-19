package leetcode.june;

public class MinCostClimbingStairs {
	public static int minCostClimbingStairs(int[] a) {
		int r[] = new int[a.length + 1];
		r[0] = 0;
		r[1] = 0;
		for (int i = 2; i < r.length; i++) {
			r[i] = Math.min(r[i - 1] + a[i - 1], r[i - 2] + a[i - 2]);
		}
		return r[r.length - 1];
	}

	private static int climb(int[] a, int i) {
		if (i >= a.length - 1) {
			return 0;
		}
		return Math.min(climb(a, i + 1), climb(a, i + 2)) + a[i];
	}

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 1,100,1,1,1,100,1,1,100,1 }));
	}
}
