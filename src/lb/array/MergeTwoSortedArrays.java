package lb.array;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	public static void merge1(int a[], int b[], int n, int m) {
		int t = n + m;
		quicksort(a, b, 0, t - 1);
	}

	private static void quicksort(int[] a, int[] b, int l, int r) {
		if (l < r) {
			int p = partition(a, b, l, r);
			quicksort(a, b, l, p - 1);
			quicksort(a, b, p + 1, r);
		}
	}

	private static int partition(int[] a, int[] b, int l, int r) {
		int v = getvalidWithIndex(a, b, r);
		int i = l;
		int j = l;
		while (j < r) {
			if (getvalidWithIndex(a, b, j) <= v) {
				performswap(a, b, j, i);
				i++;
			}
			j++;
		}
		performswap(a, b, i, r);
		return i;
	}

	private static void performswap(int[] a, int[] b, int j, int i) {
		int bi = -1;
		int ai = -1;
		int aj = -1;
		int bj = -1;
		if (j >= a.length) {
			bj = (j - a.length);
		} else {
			aj = j;
		}
		if (i >= a.length) {
			bi = (i - a.length);
		} else {
			ai = i;
		}
		if (ai != -1 && aj != -1) {
			swap(a, ai, aj);
		} else if (bi != -1 && bj != -1) {
			swap(b, bi, bj);
		} else if (ai != -1 && bj != -1) {
			swapInter(a, b, ai, bj);
		} else if (bi != -1 && aj != -1) {
			swapInter(a, b, aj, bi);
		}
	}

	private static void swapInter(int[] a, int[] b, int ai, int bi) {
		int t = a[ai];
		a[ai] = b[bi];
		b[bi] = t;
	}

	static void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static int getvalidWithIndex(int[] a, int[] b, int r) {
		if (r >= a.length) {
			return b[r - a.length];
		} else {
			return a[r];
		}
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	////////////////////////////////////////////////////////////

	public static void merge(int a[], int b[], int n, int m) {
		int nthMax = -1;
		int mxi = 0;
		int i = n - 1;
		int j = m - 1;
		while (j >= 0 && i >= 0) {
			mxi++;
			if (mxi == m) {
				nthMax = Math.max(a[i], b[j]);
				break;
			}
			if (a[i] > b[j]) {
				nthMax = a[i--];
			} else {
				nthMax = b[j--];
			}
		}
		if (mxi != m) {
			if (j >= 0) {
				int v = j - ((m - mxi) - 1);
				nthMax = b[v];
			}
		}
		System.out.println(nthMax);
		i = n - 1;
		j = 0;
		while (i >= 0 && j < m && b[j] < nthMax) {
			swapInter(a, b, i, j);
			j++;
			i--;
		}
		Arrays.sort(a);
		Arrays.sort(b);
	}

	public static void main(String[] args) {
		int a[] = new int[] { 1, 3, 5, 7 };
		int b[] = new int[] { 0, 2, 6, 8, 9 };
		merge(a, b, a.length, b.length);
		printA(a);
		printA(b);
	}
}
