package prc.array;

public class InversionCount {

	static long inversionCount(long a[], long N) {
		return sortAndCountInversions(a, 0, (int) N - 1, 0l);
	}

	private static long sortAndCountInversions(long[] a, int s, int n, long count) {
		if (s > n) {
			return count;
		}
		int m = (s + n) / 2;
		sortAndCountInversions(a, s, m - 1, count);
		sortAndCountInversions(a, m + 1, n, count);
		count += merge(a, s, m, n);
		return 0;
	}

	private static long merge(long[] a, int s, int m, long n) {
		long c = 0;
		long a1[] = new long[(int) (m - s)];
		long a2[] = new long[(int) (n - (m + 1))];

		int a1i = 0;
		int a2i = 0;
		for (long i = s; i <= m; i++) {
			a1[a1i++] = a[(int) i];
		}
		for (long i = m + 1; i <= n; i++) {
			a1[a2i++] = a[(int) i];
		}
		long i = s;
		long j = m + 1;
		while (i <= m && j <= n) {
			if (a1[(int) i] > a2[(int) j]) {
				c += a1.length - i;
			} else {
				i++;
			}
		}
		return 0;

	}

}
