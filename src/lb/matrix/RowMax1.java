package lb.matrix;

public class RowMax1 {
	static int rowWithMax1s(int a[][], int n, int m) {
		int i = m - 1;
		int j = 0;
		int idx = 0;
		while (j < a.length && i >= 0) {
			if (a[j][i] == 1) {
				i--;
				idx = j;
			} else {
				j++;
			}
		}
		return idx;
	}

	public static void main(String[] args) {
		int a[][] = new int[][] { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.println(rowWithMax1s(a, 4, 4));
	}
}
