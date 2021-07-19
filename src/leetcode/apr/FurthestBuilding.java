package leetcode.apr;

import java.util.PriorityQueue;

public class FurthestBuilding {
	public static int furthestBuilding(int[] a, int b, int l) {
		PriorityQueue<Integer> hp = new PriorityQueue<Integer>();
		for (int i = 0; i < a.length - 1; i++) {
			int d = a[i + 1] - a[i];
			if (d > 0) {
				hp.add(d);
				if (hp.size() > l) {
					b -= hp.poll();
					if (b < 0) {
						return i;
					}
				}
			}
		}
		return a.length;
	}

	public static void main(String[] args) {
//		System.out.println(furthestBuilding(new int[] { 4, 12, 2, 7, 3, 18, 20, 3, 19 }, 10, 2));
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(3);
		q.add(1);
		q.add(2);
		System.out.println(q.poll());
		System.out.println(q);
	}
	

}
