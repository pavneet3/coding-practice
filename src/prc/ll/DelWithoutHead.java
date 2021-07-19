package prc.ll;

public class DelWithoutHead {
	void deleteNode(Node del) {
		Node n = del;
		while (n.next.next != null) {
			n.value = n.next.value;
			n = n.next;
		}
		n.next = null;
	}
}
