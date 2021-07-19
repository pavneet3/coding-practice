package prc.dp;

public class KnapSack01 {

	static int knapSackr(int w, int wt[], int val[], int n) {
		if (w <= 0 || n == 0) {
			return 0;
		}
		if (wt[n - 1] > w) {
			return knapSackr(w, wt, val, n - 1);
		} else {
			return Math.max(val[n - 1] + knapSackr(w - wt[n - 1], wt, val, n - 1), knapSackr(w, wt, val, n - 1));
		}
	}

	static int knapSack(int w, int wt[], int val[], int n) {
		int t[][] = new int[n + 1][w + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (wt[i - 1] > j) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = Math.max(t[i - 1][j - wt[i - 1]] + val[i - 1], t[i - 1][j]);
				}
			}
		}
		return t[n][w];
	}

	public static void main(String[] args) {
		System.out.println(knapSack(4, new int[] { 4, 5, 1 }, new int[] { 1, 2, 3 }, 3));
	}

}
