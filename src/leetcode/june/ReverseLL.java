package leetcode.june;

public class ReverseLL {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode n = head;
		ListNode p = null;
		ListNode m = null;

		int v = 1;
		while (n != null && v != left) {
			p = n;
			n = n.next;
			v++;
		}
		m = n;
		while (m != null && v != right + 1) {
			m = m.next;
			v++;
		}

		int d = right - left + 1;
		while (d != 0 && n != null) {
			d--;
			ListNode t = n.next;
			n.next = m;
			m = n;
			n = t;
		}
		if (p == null) {
			return m;
		} else {
			p.next = m;
			return head;
		}
	}
}
