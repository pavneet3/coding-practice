package prc.ll;

public class GroupReverse {
	public Node pairwiseSwap(Node node) {
		int k=2;
		if (node == null) {
			return null;
		}
		Node r = node;
		Node n = node;
		int l = k;
		while (n != null && l > 0 ) {
			n = n.next;
			l--;
		}
		Node p = pairwiseSwap(n);
		l = k;
		while (l > 0 && r != null) {
			Node t = r.next;
			r.next = p;
			p = r;
			r = t;
			l--;
		}
		return p;
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);

		node = reverse(node, 2);

		printN(node);

	}

	private static void printN(Node node) {
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
