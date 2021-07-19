package prc.array;

public class DatchFlagAlgo {

	static void sortArray(int a[]) {
		int m = 0, l = 0, r = a.length-1;

		while (m <= r) {
			switch (a[m]) {
			case 0:
				swap(a, l, m);
				l++;
				m++;
				break;
			case 1:
				m++;
				break;
			case 2:
				swap(a, m, r);
				r--;
				break;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int a[] = { 2, 1, 0, 1, 2 };
		sortArray(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
