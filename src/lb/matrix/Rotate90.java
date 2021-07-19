package lb.matrix;

public class Rotate90 {

	static void transpose(int a[][], int i, int j) {
		if (i >= a[0].length || j >= a.length) {
			return;
		}
		int i1 = i;
		int j1 = j;
		while (i1 < a[0].length && j < a.length) {
			swap(a, i, j, i1, j1);
			j++;
			i1++;
		}
		transpose(a, i + 1, j1 + 1);
	}

	static void rotate90(int a[][]) {
		transpose(a, 0, 0);
		reverse(a);
	}

	private static void reverse(int a[][]) {
		for (int k = 0; k < a.length; k++) {
			int i = 0;
			int j = a.length - 1;
			while (i <= j) {
				swap(a, i, j, k);
				i++;
				j--;
			}
		}
	}

	private static void swap(int[][] a, int i, int j, int k) {
		int t = a[k][i];
		a[k][i] = a[k][j];
		a[k][j] = t;
	}

	private static void swap(int[][] a, int i, int j, int i1, int j1) {
		int t = a[i][j];
		a[i][j] = a[i1][j1];
		a[i1][j1] = t;
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
		int a[][] = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate90(a);
		printA(a);
	}

}
