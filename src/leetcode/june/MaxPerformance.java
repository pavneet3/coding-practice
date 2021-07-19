package leetcode.june;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxPerformance {
	public static int maxPerformance(int n, int[] s, int[] e, int k) {
		Queue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o2[0] - o1[0];
		});
		for (int i = 0; i < n; i++) {
			q.add(new int[] { e[i], s[i] });
		}
		Queue<Integer> sq = new PriorityQueue<Integer>();
		long mx = 0;
		int tk = 0;
		while (!q.isEmpty()) {
			int v[] = q.poll();
			if (sq.size() == k) {
				tk -= sq.poll();
			}
			sq.add(v[1]);
			tk += v[1];
			int tv = tk * v[0];
			mx = Math.max(mx, tv);
		}
		return (int) (mx % (Math.pow(10, 9) + 7));
	}

	static void printA(long a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 4));
	}
}
