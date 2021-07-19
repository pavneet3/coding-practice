package lb.array;

import java.util.Arrays;

public class NextPermutation {
	public static void nextPermutation(int[] a) {
		int mi = a[a.length - 1];
		int i = a.length - 1;
		while (i > 0 && a[i - 1] > a[i]) {
			i--;
		}
		if (i > 0) {
			int k = i;
			int v = i - 1;
			mi = k;
			while (k < a.length) {
				if (a[k] > a[v] && a[k] <= a[mi]) {
					mi = k;
				}
				k++;
			}
			swap(a, i - 1, mi);
		}
		Arrays.sort(a, i, a.length);
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
	}

	public static void main(String[] args) {
		int a[] = new int[] { 1 };
		nextPermutation(a);
		printA(a);
	}
}
