package prc.array;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegative {
	public static long[] printFirstNegativeInteger(long a[], int n, int k) {
		long list[] = new long[a.length - k + 1];
		Queue<Long> l = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			if (a[i] < 0) {
				l.add(a[i]);
			}
		}
		int m = 0;
		for (int i = 0, j = k; j < a.length; j++) {
			list[m++] = l.isEmpty() ? 0 : l.peek();
			if (!l.isEmpty() && a[i] == l.peek()) {
				l.poll();
			}
			i++;
			if (a[j] < 0) {
				l.add(a[j]);
			}
		}
		list[m++] = l.isEmpty() ? 0 : l.peek();
		return list;
	}

	static void printA(long a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		printA(printFirstNegativeInteger(new long[] { -8, 2, 3, -6, 10 }, 0, 2));
	}
}
