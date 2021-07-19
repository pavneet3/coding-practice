package leetcode.june;

import java.util.HashMap;
import java.util.Map;

import prc.tree.TreeNode;

public class ConstructTreeWithInorderAndPreOrder {
	static int i = 0;

	public TreeNode buildTree(int[] p, int[] in) {
		i = 0;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < p.length; i++) {
			m.put(in[i], i);
		}
		return buildTree(p, in, 0, p.length - 1, m);
	}

	private TreeNode buildTree(int[] p, int[] in, int l, int u, Map<Integer, Integer> m) {
		if (u < l) {
			return null;
		}
		TreeNode n = new TreeNode(p[i++]);
		if (u == l) {
			return n;
		}
		int mid = m.get(n.val);
		n.left = buildTree(p, in, l, mid - 1, m);
		n.right = buildTree(p, in, mid + 1, u, m);
		return n;
	}
}
