package pp.test;

public class FindTarget {

	public static int targetIndex(int a[], int t) {
		int ri = findIndex(a, 0, a.length-1);

//		System.out.println(ri);
		if (ri == -1) {
			return binarySearch(a, 0, a.length - 1, t);
		} else {
			if (a[0] > t) {
				return binarySearch(a, ri + 1, a.length - 1, t);
			} else {
				return binarySearch(a, 0, ri, t);
			}
		}

	}

	private static int findIndex(int[] a, int s, int e) {
		if (s >= e) {
			return -1;
		}
		int m = (s + e) / 2;
		if ( a[m] > a[m + 1]) {
			return m;
		} else if (a[m] > a[0]) {
			return findIndex(a, m+1, e);
		} else {
			return findIndex(a, s, m-1);
		}
	}

	private static int binarySearch(int[] a, int s, int e, int t) {
		while (s <= e) {
			int m = (s + e) / 2;
			if (a[m] == t) {
				return m;
			} else if (a[m] < t) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(targetIndex(new int[] {  4, 6, 7 ,0, 1, 2}, 1));
	}

}
