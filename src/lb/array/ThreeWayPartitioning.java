package lb.array;

public class ThreeWayPartitioning {
	public void threeWayPartition(int ar[], int a, int b) {
		int l = 0;
		int r = ar.length - 1;
		int m = 0;
		while (l < r) {
			if (ar[m] < a) {
				swap(ar, l, m);
				l++;
				m++;
			} else if (ar[m] >= a && ar[m] <= b) {
				m++;
			} else if (ar[m] > b) {
				swap(ar, r, m);
				r--;
			}
		}
	}

	static void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
