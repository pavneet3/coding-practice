package prc.ll;

public class ReverseLL {
	Node reverseList(Node head) {
		Node p = null;
		Node t = head;
		while (t != null) {
			Node n = t.next;
			t.next = p;
			p = t;
			t = n;
		}
		return p;
	}
}
