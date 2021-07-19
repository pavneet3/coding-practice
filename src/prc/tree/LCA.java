package prc.tree;

public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		TreeNode l = lowestCommonAncestor(root.left, p, q);
		TreeNode r = lowestCommonAncestor(root.right, p, q);

		if (l != null && r != null) {
			return root;
		}
		if (l == null && r == null) {
			return null;
		}
		return l != null ? l : r;
	}
}
