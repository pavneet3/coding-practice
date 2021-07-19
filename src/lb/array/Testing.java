package lb.array;

/*
 * [1,3,10]
 * [2,7,31]
 * [5,7,32]
 * 
 * 3
 * [1,3,10]
 * [2,7,31]
 * 
 * */

public class Testing {
	static int kthSmallest(int a[], int b[], int k) {
		int i = 0, j = 0;
		int m = 0;
		int v = Integer.MIN_VALUE;
		if (a.length + b.length < k || k <= 0) {
			return Integer.MIN_VALUE;
		}
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				v = a[i];
				i++;
			} else {
				v = b[j];
				j++;
			}
			m++;
			if (m == k) {
				break;
			}
		}
		if (m != k) {
			if (i < a.length) {
				v = a[i + ((a.length + b.length) - m) - 1];
			} else if (j < b.length) {
				v = b[j + ((a.length + b.length) - m) - 1];
			}
		}
		return v;
	}

	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[] { 1, 3, 10 }, new int[] { 2, 7, 31 }, 6));
		System.out.println(kthSmallest(new int[] { 1, 3, 10 }, new int[] { 2, 7, 31 }, 0));
		System.out.println(kthSmallest(new int[] { 1, 3, 10 }, new int[] { 2, 7, 31 }, 3));
		System.out.println(kthSmallest(new int[] {}, new int[] { 2, 7, 31, 45, 65, 89, 90 }, 6));
//		System.out.println(kthSmallest(new int[] { 1, 3, 10 }, new int[] { 2, 7, 31 }, 6));
	}

}
