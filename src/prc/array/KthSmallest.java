package prc.array;

public class KthSmallest {
	public static int kthSmallest(int[] a, int l, int r, int k) {
		if (l > r) {
			return -1;
		}
		int p = pivot(a, l, r);
//		System.out.println(p);
		if (p == k) {
			return a[k];
		} else if (p < k) {
			return kthSmallest(a, p + 1, r, k);
		} else {
			return kthSmallest(a, l, p - 1, k);
		}

	}

	private static int pivot(int[] a, int l, int r) {
		int p = a[r];
		int j = l;
		for (int i = l; i < r; i++) {
			if (a[i] < p) {
				swap(a, i, j);
				j++;
			}
		}
		swap(a, r, j);
//		printA(a);
		return j;
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
		int a[] = new int[] { 7, 10, 4, 3, 20, 15 };
		System.out.println(kthSmallest(a, 0, a.length - 1, 3));
	}

}
