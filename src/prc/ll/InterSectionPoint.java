package prc.ll;

public class InterSectionPoint {
	int intersectPoint(Node head1, Node head2) {
		int l1 = length(head1);
		int l2 = length(head2);
		if (l1 > l2) {
			while (l1 != l2) {
				head1 = head1.next;
				l1--;
			}
		} else {
			while (l1 != l2) {
				head2 = head2.next;
				l2--;
			}
		}
		while (head1 != null) {
			if (head1.value == head2.value) {
				return head1.value;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return -1;
	}

	private int length(Node n) {
		int l = 0;
		while (n != null) {
			l++;
			n = n.next;
		}
		return l;
	}
}
