package prc.msl;

public class NumberOfIslands {
	public static int numIslands(char[][] a) {
		boolean v[][] = new boolean[a.length][a[0].length];
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 1 && !v[i][j]) {
					visit(a, v, i, j);
					c++;
				}
			}
		}
		return c;
	}

	private static void visit(char[][] a, boolean[][] v, int i, int j) {
		if (i == -1 || j == -1 || i >= a.length || j >= a[0].length) {
			return;
		}
		if (a[i][j] == 0 || v[i][j]) {
			return;
		}
		v[i][j] = true;
		visit(a, v, i + 1, j);
		visit(a, v, i, j + 1);
		visit(a, v, i - 1, j);
		visit(a, v, i, j - 1);
		visit(a, v, i + 1, j + 1);
		visit(a, v, i - 1, j - 1);
		visit(a, v, i - 1, j + 1);
		visit(a, v, i + 1, j - 1);
	}

	public static void main(String[] args) {
		System.out.println(numIslands(new char[][] { {0,1,1,1,0,0,0},{0,0,1,1,0,1,0} }));
	}
}
