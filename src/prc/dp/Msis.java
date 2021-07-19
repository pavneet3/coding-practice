package prc.dp;

public class Msis {
	public int maxSumIS(int a[], int n) {
		int r[] = new int[n];
		int m = a[0];
		for (int i = 0; i < a.length; i++) {
			r[i] = a[i];
			m = Math.max(m, a[i]);
		}
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && r[i] < r[j] + a[i]) {
					r[i] = r[j] + a[i];
					m = Math.max(m, r[i]);
				}
			}
		}
		return m;
	}
}
