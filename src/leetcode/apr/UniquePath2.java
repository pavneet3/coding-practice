package leetcode.apr;

public class UniquePath2 {
	public static int uniquePathsWithObstacles(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i][0] == 1) {
				while (i < a.length) {
					a[i][0] = -1;
					i++;
				}
			} else {
				a[i][0] = 1;
			}
		}
		for (int i = 1; i < a[0].length; i++) {
			if (a[0][i] == 1) {
				while (i < a[0].length) {
					a[0][i] = -1;
					i++;
				}
			} else {
				a[0][i] = 1;
			}
		}
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a[i].length; j++) {
				if (a[i][j] == 1) {
					a[i][j] = -1;
				}
			}
		}
		printA(a);
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a[i].length; j++) {
				if (a[i][j] == -1) {
					continue;
				}
				if (a[i - 1][j] == -1 && a[i][j - 1] == -1) {
					a[i][j] = -1;
				} else if (a[i - 1][j] == -1) {
					a[i][j] = a[i][j - 1];
				} else if (a[i][j - 1] == -1) {
					a[i][j] = a[i - 1][j];
				} else {
					a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]) + 1;
				}
			}
		}
		return a[a.length - 1][a[0].length - 1] == -1 ? -1 : a[a.length - 1][a[0].length - 1];
	}

	static void printA(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int a[][] = new int[][] { { 1,0 } };
		System.out.println(uniquePathsWithObstacles(a));
		printA(a);
	}
}