package prc.msl;

public class LargestSqMatrix {
	static int maximalSquare(char a[][]) {
		int n = a.length;
		int m = a[0].length;
		int mx = 0;
		if (n == 1) {
			for (int i = 0; i < m; i++) {
				mx = Math.max(a[0][i], mx);
			}
		}
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				mx = Math.max(a[i][0], mx);
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (a[i][j] == 0) {
					continue;
				}
				a[i][j] = (char) (Math.min(a[i - 1][j], Math.min(a[i][j - 1], a[i - 1][j - 1])) + 1);
				mx = Math.max(mx, a[i][j]);
			}
		}
		return mx;
	}
	
	public static void main(String[] args) {
		
	}
}
