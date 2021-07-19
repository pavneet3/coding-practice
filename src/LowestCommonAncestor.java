
class Node {

	int val;
	Node left;
	Node rigth;

}

public class LowestCommonAncestor {

	Node lowestCommonAncestor(Node root, int a, int b) {

		if (root == null) {
			return null;
		}

		if (root.val == a || root.val == b) {
			return root;
		}

		Node left = lowestCommonAncestor(root.left, a, b);
		Node right = lowestCommonAncestor(root.rigth, a, b);

		if (left == null && right == null) {
			return null;
		} else if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			return root;
		}
	}

}
