package prc.tree;

import java.util.ArrayList;
import java.util.Stack;

public class SpiralView {
	ArrayList<Integer> findSpiral(Node root) {
		if (root == null) {
			return null;
		}
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		ArrayList<Integer> r = new ArrayList<Integer>();
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node n = s1.pop();
				r.add(n.data);
				if (n.right != null) {
					s2.push(n.right);
				}
				if (n.left != null) {
					s2.push(n.left);
				}
			}

			while (!s2.isEmpty()) {
				Node n = s2.pop();
				r.add(n.data);
				if (n.left != null) {
					s1.push(n.left);
				}
				if (n.right != null) {
					s1.push(n.right);
				}
			}
		}
		return r;
	}
}
