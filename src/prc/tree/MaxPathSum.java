package prc.tree;

public class MaxPathSum {
	static int max = 0;

	int maxPathSum(Node root) {
		max = Integer.MIN_VALUE;
		getMaxPath(root);
		return max;
	}

	private int getMaxPath(Node root) {
		if (root == null) {
			return 0;
		}
		int l = getMaxPath(root.left);
		int r = getMaxPath(root.right);
		int t = Math.max(l, r) + root.data;
		max = Math.max(max, r + l + root.data);
		return ;
	}
}
