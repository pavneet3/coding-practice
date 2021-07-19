package prc.ll;

public class MergeSortedLL {
	Node sortedMerge(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (head1.value < head2.value) {
			head1.next = sortedMerge(head1.next, head2);
			return head1;
		} else {
			head2.next = sortedMerge(head1, head2.next);
			return head2;
		}
	}
}
