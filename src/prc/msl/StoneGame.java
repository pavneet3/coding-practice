package prc.msl;

public class StoneGame {

	public static int stoneGameII(int[] a) {
		int d[][] = new int[a.length][a.length];
		for (int g = 0; g < a.length; g++) {
			for (int i = 0, j = g; j < a.length; j++, i++) {
				if (g == 0) {
					d[i][j] = a[j];
				} else if (g == 1) {
					d[i][j] = Math.max(a[i], a[j]);
				} else {
					int v1 = a[i] + Math.min(d[i + 1][j - 1], d[i + 2][j]);
					int v2 = a[j] + Math.min(d[i][j - 2], d[i + 1][j - 1]);
					d[i][j] = Math.max(v1, v2);
				}
			}
		}
		return d[0][a.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(stoneGameII(new int[] { 2, 7, 9, 4, 4 }));
	}
}
