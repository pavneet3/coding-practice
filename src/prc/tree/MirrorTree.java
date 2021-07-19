package prc.tree;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class MirrorTree {
	static class Solution {
		public static boolean isSymmetric(Node root) {
			return checkSymmetric(root, root);
		}

		private static boolean checkSymmetric(Node root1, Node root2) {
			if (root1 == null && root2 == null) {
				return true;
			}
			if ((root1 == null && root2 != null) || (root2 == null && root1 != null)) {
				return false;
			}
			if (root1.data != root2.data) {
				return false;
			}
			return checkSymmetric(root1.left, root2.right);
		}
	}
}
