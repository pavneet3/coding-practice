package prc.greedy;

import java.util.Deque;
import java.util.LinkedList;

public class PageFaults {
	static int pageFaults(int n, int c, int a[]) {
		Deque<Integer> q = new LinkedList<Integer>();
		int pf = 0;
		for (int i = 0; i < a.length; i++) {
			if (q.isEmpty()) {
				q.add(a[i]);
			} else if (q.contains(a[i])) {
				q.remove(a[i]);
				q.add(a[i]);
			} else {
				if (q.size() == c) {
					q.removeFirst();
				}
				q.add(a[i]);
				pf++;
			}
		}
		return pf;
	}
	
	public static void main(String[] args) {
		
	}
}
