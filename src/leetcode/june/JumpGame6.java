package leetcode.june;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGame6 {
//	public static int maxResult(int[] a, int k) {
//		int r[] = new int[a.length];
//		Arrays.fill(r, Integer.MIN_VALUE);
//		r[0] = a[0];
//		for (int i = 1; i < a.length; i++) {
//			int j = Math.max(0, i - k);
//			int t = i - 1;
//			while (t >= j) {
//				r[i] = Math.max(r[t] + a[i], r[i]);
//				t--;
//			}
//		}
////		printA(r);
//		return r[a.length - 1];
//	}

	public static int maxResult(int[] a, int k) {
		Deque<Integer> q = new LinkedList<Integer>();
		q.add(0);
		for (int i = 1; i < a.length; i++) {
			System.out.println(q);
			printA(a);
			a[i] = a[i] + a[q.peek()];
			if (!q.isEmpty() && q.peek() == i - k) {
				q.pollFirst();
			}
			if (q.size() == k) {
				q.pollFirst();
			}
			while (!q.isEmpty() && a[q.peekLast()] <= a[i]) {
				q.pollLast();
			}
			q.add(i);
		}
		return a[a.length - 1];
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		System.out.println(maxResult(new int[] {10,-5,-2,4,0,3 }, 3));
	}

}
