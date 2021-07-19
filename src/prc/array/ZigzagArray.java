package prc.array;

public class ZigzagArray {
	static void zigZag(int a[], int n) {
		if (n < 2) {
			return;
		}
		boolean f = true;
		for (int i = 0, j = 1; i < j && j < a.length; i++, j++) {
			if (f) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			} else {
				if (a[i] < a[j]) {
					swap(a, i, j);
				}
			}
			f = !f;
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
		int a[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };
		zigZag(a, a.length);
		printA(a);
	}
}
