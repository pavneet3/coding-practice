package prc.array;

public class QuickSort {

	static void sortArray(int a[], int l, int n) {
		if (l >= n) {
			return;
		}
		int p = partition(a, l, n);
		sortArray(a, l, p - 1);
		sortArray(a, p + 1, n);
	}

	private static int partition(int[] a, int l, int n) {
		int p = a[n];
		int i = 0;
		int j = 0;
		while (i < n && j < n) {
			if (a[i] < p) {
				swap(a, i, j);
				j++;
			}
			i++;
		}
		swap(a, j, n);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int a[] = { 5, 3, 0, 2, 7, 1, -1 };
		sortArray(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
