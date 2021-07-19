package prc.st.q;

import java.util.LinkedList;
import java.util.Queue;

class Box {
	int i, j;
	int t;

	Box(int i, int j, int t) {
		this.i = i;
		this.j = j;
		this.t = t;
	}
}

public class RottonOranges {

	public int orangesRotting(int[][] a) {
		Queue<Box> q = new LinkedList<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 2) {
					q.add(new Box(i, j, 0));
				}
			}
		}
		int t = 0;
		while (!q.isEmpty()) {
			Box b = q.poll();
			if (b.i > 0) {
				if (a[b.i - 1][b.j] != 0) {
					
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 1) {
					return -1;
				}
			}
		}
	}
}
