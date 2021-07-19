package prc.ll;

public class RotateLL {
	public Node rotate(Node head, int k) {
		int l = length(head);
		k = k % l;
		Node kn = null;
		Node newHead = null;
		Node h = head;
		Node n = head;

		while (k != 1) {
			n = n.next;
			k--;
		}
		kn = n;
		newHead = n.next;
		kn.next = null;
		n = newHead;
		while (n.next != null) {
			n = n.next;
		}
		n.next = h;
		return newHead;
	}

	private int length(Node head) {
		Node n = head;
		int l = 0;
		while (n != null) {
			n = n.next;
			l++;
		}
		return l;
	}
}
