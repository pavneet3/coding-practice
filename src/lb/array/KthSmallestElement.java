package lb.array;

public class KthSmallestElement {
	public static int kthSmallest(int[] a, int l, int r, int k) {
		if (k > 0 && k <= r - l + 1) {
			int p = pivot(a, l, r);
			if (k - 1 == p-l) {
				return a[p];
			}
			if (p - l > k - 1) {
				return kthSmallest(a, l, p - 1, k);
			} else {
				return kthSmallest(a, p + 1, r, k - p + l - 1);
			}
		}
		return Integer.MAX_VALUE;
	}

	private static int pivot(int[] a, int l, int r) {
		int pv = a[r];
		int i = l;
		int j = l;
		while (j < r) {
			if (a[j] <= pv) {
				swap(a, i, j);
				i++;
			}
			j++;
		}
		swap(a, i, r);
		return i;
	}

	static void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[] { 12, 3, 5, 7, 4, 19, 26 }, 0, 6, 3));
	}

}
