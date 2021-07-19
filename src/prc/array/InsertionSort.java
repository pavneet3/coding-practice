package prc.array;

public class InsertionSort {

	static void sortArray(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int k = a[i];
			int j = i - 1;
			while (j >= 0) {
				if (k < a[j]) {
					swap(a, j + 1, j);
				}
				j--;
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
	}

	public static void main(String[] args) {
		int a[] = new int[] { 7, 5, 3, 1 };
		sortArray(a);
		printA(a);
	}
}
