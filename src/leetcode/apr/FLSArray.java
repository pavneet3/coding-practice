package leetcode.apr;

public class FLSArray {
	public static int[] searchRange(int[] a, int t) {
		int block[] = new int[2];
		block[0] = binarySearchFirst(a, 0, a.length-1, t);
		block[1] = binarySearchLast(a, 0, a.length-1, t);
		return block;
	}

	private static int binarySearchLast(int[] a, int s, int e, int t) {
		while (s <= e) {
			int m = (s + e) / 2;
			if (a[m] == t) {
				if (m < a.length - 1 && a[m] == a[m + 1]) {
					s = m + 1;
				} else {
					return m;
				}
			} else if (a[m] < t) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		return -1;
	}

	private static int binarySearchFirst(int[] a, int s, int e, int t) {
		while (s <= e) {
			int m = (s + e) / 2;
			if (a[m] == t) {
				if (m > 0 && a[m] == a[m - 1]) {
					e = m - 1;
				} else {
					return m;
				}
			} else if (a[m] < t) {
				s = m + 1;
			} else {
				e = m - 1;
			}

		}
		return -1;
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.err.println();
	}

	public static void main(String[] args) {
		int b[] = searchRange(new int[] { 2, 2 }, 3);
		printA(b);
	}
}
