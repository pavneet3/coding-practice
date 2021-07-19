package prc.st.q;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxOfSubArrayOfK {
	static ArrayList<Integer> max_of_subarrays(int a[], int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		int i = 0;
		int j = 0;
		ArrayList<Integer> r = new ArrayList<Integer>();
		while (j < a.length) {
			int w = j - i + 1;
			if (w < k) {
				while (!q.isEmpty() && a[q.peek()] < a[j]) {
					q.poll();
				}
				if (q.isEmpty() || a[q.peek()] > a[j]) {
					q.add(j);
				}
				j++;
			} else if (w == k) {
				r.add(a[q.peek()]);
				if (i == q.peek()) {
					q.poll();
				}
				while (!q.isEmpty() && a[q.peek()] < a[j]) {
					q.poll();
				}
				if (q.isEmpty() || a[q.peek()] > a[j]) {
					q.add(j);
				}
				i++;
				j++;
			}
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(max_of_subarrays(new int[] { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 }, 0, 4));
	}

}
