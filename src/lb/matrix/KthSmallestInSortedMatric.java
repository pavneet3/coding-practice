package lb.matrix;

public class KthSmallestInSortedMatric {
	public static int kthSmallest(int[][] a, int n, int k) {
		int s = a[0][0];
		int e = a[a.length - 1][a[0].length - 1];
		while (s < e) {
			int m = (s + e) / 2;
			if (count(a, m) < k) {
				s = m + 1;
			} else {
				e = m;
			}
		}
		return e;
	}

	private static int count(int[][] a, int m) {
		int i = 0, j = a[0].length - 1;
		int c = 0;
		while (i < a.length && j >= 0) {
			if (a[i][j] <= m) {
				i++;
				c += j + 1;
			} else {
				j--;
			}
		}
		return c;
	}
}
