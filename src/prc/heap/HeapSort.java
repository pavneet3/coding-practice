package prc.heap;

public class HeapSort {

	static void heapSort(int a[], int n) {
		heapify(a, n);
		while (n != 0) {
			swap(a, n - 1, 0);
			n = n - 1;
			maxHeapify(a, 0, n);
		}
	}

	static void heapify(int a[], int n) {
		for (int i = 0; i < n / 2 - 1; i++) {
			maxHeapify(a, i, n);
		}
	}

	private static void maxHeapify(int[] a, int i, int n) {
		if (i > n / 2 - 1) {
			return;
		}
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (a[l] > a[i] || a[r] > a[i]) {
			if (a[l] > a[r]) {
				swap(a, l, i);
				maxHeapify(a, l, n);
			} else {
				swap(a, r, i);
				maxHeapify(a, r, n);
			}
		}
	}

	static void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = new int[] { 1, 32, 31, 4, 6, 12, 22 };
		heapSort(a, a.length);
		printA(a);
	}

}
