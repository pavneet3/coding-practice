package prc.dp;

public class MaxCutRod {
	public static int maximizeCuts(int n, int x, int y, int z) {
		int t[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			t[i] = Math.max(i - x >= 0 ? t[i - x] : 0, Math.max(i - y >= 0 ? t[i - y] : 0, i - z >= 0 ? t[i - z] : 0));
			if (t[i] == 0) {
				if (x == i || y == i || z == i) {
					t[i] = 1;
				}
			} else {
				t[i] = t[i] + 1;
			}
		}
		return t[n];
	}

	public static void main(String[] args) {
		System.out.println(maximizeCuts(5,5,3,2));
	}
}
