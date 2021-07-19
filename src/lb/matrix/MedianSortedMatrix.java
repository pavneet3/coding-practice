package lb.matrix;

import java.util.PriorityQueue;

public class MedianSortedMatrix {
	static int median(int a[][], int r, int c) {
		int n = r * c;
		if (n % 2 == 1) {
			return findKthSmallest(a, (n / 2) + 1);
		} else {
			return (findKthSmallest(a, n / 2) + findKthSmallest(a, n / 2 + 1)) / 2;
		}
	}

	private static int findKthSmallest(int[][] a, int k) {
		if (k > a.length * a[0].length) {
			return -1;
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> a[o1[0]][o1[1]] - a[o2[0]][o2[1]]);
		for (int i = 0; i < a.length; i++) {
			q.add(new int[] { i, 0 });
		}
		int kth = -1;
		while (!q.isEmpty() && k != 0) {
			int[] min = q.poll();
			kth = a[min[0]][min[1]];
			if (min[1] < a[0].length - 1) {
				q.add(new int[] { min[0], min[1] + 1 });
			}
			k--;
		}
		return kth;
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1 }, { 2 }, { 3 } };
		System.out.println(median(a, 3, 1));
	}
}
