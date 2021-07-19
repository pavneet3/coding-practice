package prc.array;

public class MergeSort {

	static void sortArray(int a[], int l, int n) {
		if (l < n) {
			int m = (l + n) / 2;
			sortArray(a, l, m);
			sortArray(a, m + 1, n);
			merge(a, l, n, m);
		}
	}

	private static void merge(int[] a, int l, int n, int m) {
		int m1[] = new int[(m + 1) - l];
		int m2[] = new int[(n + 1) - (m + 1)];
		int j = 0;
		for (int i = l; i <= m; i++) {
			m1[j++] = a[i];
		}
		j = 0;
		for (int i = m + 1; i <= n; i++) {
			m2[j++] = a[i];
		}
		j = 0;
		int i = 0;
		int k = l;
		for (; i < m1.length && j < m2.length && k <= n;) {
			if (m1[i] < m2[j]) {
				a[k++] = m1[i];
				i++;
			} else {
				a[k++] = m2[j];
				j++;
			}
		}
		while (i < m1.length && k <= n) {
			a[k++] = m1[i++];
		}
		while (j < m2.length && k <= n) {
			a[k++] = m2[j++];
		}
	}

	public static void main(String[] args) {
		int a[] = { 2, 1, 6, 3, 8 };
		sortArray(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
