package prc.bt;

import java.util.Arrays;

public class KnightTour {

	static boolean knightTour(int n) {
		int s[][] = new int[n][n];
		int xm[] = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };
		int ym[] = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
		for (int i = 0; i < s.length; i++) {
			Arrays.fill(s[i], -1);
		}
		s[0][0] = 0;
		if (tour(0, 0, n, s, xm, ym, 1)) {
			return true;
		}
		return false;

	}

	private static boolean tour(int x, int y, int n, int[][] s, int[] xm, int[] ym, int m) {
		if (m == n * n) {
			return true;
		}
		int nx, ny;

		for (int k = 0; k < 8; k++) {
			nx = xm[k] + x;
			ny = ym[k] + y;
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || s[nx][ny] != -1) {
				continue;
			}
			s[nx][ny] = m;
			if (tour(nx, ny, n, s, xm, ym, m + 1)) {
				return true;
			} else {
				s[nx][ny] = -1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(knightTour(8));
	}

}
