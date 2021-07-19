package prc.st.q;

import java.util.Stack;

public class NextGreaterElement {
	public static long[] nextLargerElement(long[] a, int n) {
		Stack<Integer> st = new Stack<>();
		long[] r = new long[a.length];
		for (int i = a.length - 1; i <= 0; i--) {
			if (st.isEmpty()) {
				r[i] = -1;
			} else {
				while (!st.isEmpty() && a[st.peek()] <= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					r[i] = -1;
				} else {
					r[i] = a[st.peek()];
				}
			}
			st.push(i);
		}
		return r;
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {

	}
}
