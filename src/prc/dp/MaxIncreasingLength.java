package prc.dp;

import java.util.Arrays;

public class MaxIncreasingLength {
	static int mx = -1;

	public static int getMaxIncreasingLen(int a[][]) {
		mx = -1;
		int t[][] = new int[a.length][a[0].length];
		for (int i = 0; i < t.length; i++) {
			Arrays.fill(t[i], -1);
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (t[i][j] == -1) {
					populateMax(a, t, i, j);
//					printA(t);
				}
			}
		}
		return mx + 1;
	}

	static void printA(int a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * [3,4,5], [3,2,6], [2,2,1]
	 * 
	 * 
	 * [3,2,1] [-1,-1,0] [-1,-1,-1]
	 */
	private static int populateMax(int[][] a, int[][] t, int i, int j) {
		if (i < 0 || j < 0 || i >= a.length || j >= a[0].length) {
			return -1;
		}
		if (t[i][j] != -1) {
			return t[i][j];
		}
		int v1 = -1, v2 = -1, v3 = -1, v4 = -1;
		if (i > 0 && a[i][j] < a[i - 1][j]) {
			v1 = populateMax(a, t, i - 1, j);
		}
		if (i < a.length - 1 && a[i][j] < a[i + 1][j]) {
			v2 = populateMax(a, t, i + 1, j);
		}
		if (j > 0 && a[i][j] < a[i][j - 1]) {
			v3 = populateMax(a, t, i, j - 1);
		}
		if (j < a.length - 1 && a[i][j] < a[i][j + 1]) {
			v3 = populateMax(a, t, i, j + 1);
		}
		t[i][j] = Math.max(v1, Math.max(v2, Math.max(v3, v4))) + 1;
		mx = Math.max(mx, t[i][j]);
		return t[i][j];
	}

	
//	[9,9,4],
//	  [6,6,8],
//	  [2,1,1]
	public static void main(String[] args) {
		System.out.println(getMaxIncreasingLen(new int[][] { {9,9,4 }, { 6,6,8 }, {2,1,1 } }));
	}

}
