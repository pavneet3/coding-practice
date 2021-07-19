package prc.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class QN {
	int l;
	Node n;

	QN(int l, Node n) {
		this.l = l;
		this.n = n;
	}
}

public class LeftView {
	ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		Queue<QN> q = new LinkedList<>();
		q.add(new QN(0, root));
		int l = -1;
		while (!q.isEmpty()) {
			QN n = q.poll();
			if (n.l > l) {
				r.add(n.n.data);
				l = n.l;
			}
			if (n.n.left != null) {
				q.add(new QN(n.l + 1, n.n.left));
			}
			if (n.n.right != null) {
				q.add(new QN(n.l + 1, n.n.right));
			}
		}
		return r;
	}
}
