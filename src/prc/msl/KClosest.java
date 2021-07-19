package prc.msl;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
	public static int[][] kClosest(int[][] a, int k) {
		Queue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o2[0] - o1[0]);
		for (int i = 0; i < a.length; i++) {
			int d = (int) Math.sqrt(Math.pow(a[i][0], 2) + Math.pow(a[i][1], 2));
			if (q.isEmpty() || q.size() < k) {
				q.add(new int[] { d, i });
			} else {
				if (q.peek()[0] > d) {
					q.poll();
					q.add(new int[] { d, i });
				}
			}
		}
		int r[][] = new int[q.size()][2];
		int i = 0;
		while (!q.isEmpty()) {
			r[i++] = a[q.peek()[1]];
			q.poll();
		}
		return r;
	}

	static void printA(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printA(kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2));
	}
}
