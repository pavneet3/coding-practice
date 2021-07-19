package prc.recursion;

public class FloodFill {
	public int[][] floodFill(int[][] a, int i, int j, int newColor) {
		boolean v[][] = new boolean[a.length][a[0].length];
		floodfillr(a, i, j, newColor, a[i][j], v);
		return a;
	}

	private void floodfillr(int[][] a, int i, int j, int newColor, int sp, boolean v[][]) {
		if (i < 0 || j < 0 || i > a.length - 1 || j > a[0].length - 1 || v[i][j]) {
			return;
		}
		v[i][j] = true;
		if (a[i][j] == sp) {
			a[i][j] = newColor;
		}
		floodfillr(a, i + 1, j, newColor, sp,v);
		floodfillr(a, i, j + 1, newColor, sp,v);
		floodfillr(a, i - 1, j, newColor, sp,v);
		floodfillr(a, i, j - 1, newColor, sp,v);
	}
}
