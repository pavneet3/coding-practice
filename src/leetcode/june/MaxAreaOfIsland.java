package leetcode.june;

public class MaxAreaOfIsland {
	public static int maxAreaOfIsland(int[][] a) {
		boolean v[][] = new boolean[a.length][a[0].length];
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 1 && !v[i][j]) {
					c = Math.max(c, visit(a, v, i, j));
				}
			}
		}
		return c;
	}

	private static int visit(int[][] a, boolean[][] v, int i, int j) {
		if (i == -1 || j == -1 || i >= a.length || j >= a[0].length) {
			return 0;
		}
		if (a[i][j] == 0 || v[i][j]) {
			return 0;
		}
		v[i][j] = true;
		int m1 = visit(a, v, i + 1, j);
		int m2 = visit(a, v, i, j + 1);
		int m3 = visit(a, v, i - 1, j);
		int m4 = visit(a, v, i, j - 1);
		return m1 + m2 + m3 + m4 + 1;
	}

	public static void main(String[] args) {
		System.out.println(maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
	}
}
