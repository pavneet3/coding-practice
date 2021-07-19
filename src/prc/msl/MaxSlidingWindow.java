package prc.msl;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
	public static int[] maxSlidingWindow(int[] a, int k) {
		int r[] = new int[a.length - k + 1];
		Deque<Integer> q = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		int w = 0;
		while (j < a.length) {
			w = j - i;
			if (w < k) {
				while (!q.isEmpty() && a[q.peekLast()] < a[j]) {
					q.pollLast();
				}
				q.addLast(j);
			} else {
				r[i] = a[q.peekFirst()];
				if (i == q.peekFirst()) {
					q.pollFirst();
				}
				i++;
				while (!q.isEmpty() && a[q.peekLast()] < a[j]) {
					q.pollLast();
				}
				q.addLast(j);
			}
			System.out.println(" i : " + j + " q :" + q);
			j++;
		}
		r[i] = a[q.peekFirst()];
		return r;
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		printA(maxSlidingWindow(new int[] { -6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7 },
				7));
	}

}
