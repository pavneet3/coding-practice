package prc.msl;

public class SSGS {
	public static int sb(int a[], int n, int x) {
		int i = 0;
		int j = 0;
		int s = 0;
		int m = 0;
		while (j < a.length) {
			s += a[j++];
			if (s > x) {
				m = Math.min(j - i, m);
				s -= a[i];
				i++;
			}
		}
		return m;
	}
}
