package leetcode.apr;

public class RotateImage {
	public static void rotate(int[][] a) {
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0, k = a.length - 1; j < k; j++, k--) {
				swap(a, i, k, j);
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a[i].length; j++) {
				int t = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = t;
			}
		}

	}

	private static void swap(int[][] a, int i, int k, int j) {
		int t = a[j][i];
		a[j][i] = a[k][i];
		a[k][i] = t;
	}

	static void printA(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int a[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(a);
		printA(a);
	}
}
