package prc.msl;

import java.util.Stack;

public class MaxAreaHisto {

	public int maxArea(int a[][], int m, int n) {
		int mx = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != 0) {
					a[i][j] = a[i - 1][j] + a[i][j];
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			mx = Math.max(mx, largestRectangleArea(a[i]));
		}
		return mx;
	}

	public static int largestRectangleArea(int[] a) {
		int leftRange[] = new int[a.length];
		int rightRange[] = new int[a.length];
		fillLeftRange(leftRange, a);
		printA(leftRange);
		fillRightRange(rightRange, a);
		printA(rightRange);
		int m = 0;
		for (int i = 0; i < a.length; i++) {
			leftRange[i] += (rightRange[i] + 1);
		}
		printA(leftRange);
		for (int i = 0; i < a.length; i++) {
			m = Math.max(m, a[i] * leftRange[i]);
		}
		return m;
	}

	private static void fillRightRange(int[] range, int[] a) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = a.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				range[i] = (a.length - 1) - i;
			} else {
				while (!st.isEmpty() && a[st.peek()] >= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					range[i] = (a.length - 1) - i;
				} else {
					range[i] = (st.peek() - 1 - i);
				}
			}
			st.push(i);
//			System.out.println(st + " " + range[i]);
		}
	}

	private static void fillLeftRange(int[] range, int[] a) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (st.isEmpty()) {
				range[i] = i;
			} else {
				while (!st.isEmpty() && a[st.peek()] >= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					range[i] = i;
				} else {
					range[i] = i - (st.peek() + 1);
				}
			}
			st.push(i);
//			System.out.println(st + " " + range[i]);
		}
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 7, 2, 8, 9, 1, 3, 6, 5 }));
		// [5,4,3,2,1]
	}
}
