package leetcode.june;

import java.util.Arrays;
import java.util.List;

class Node {

	int val;
	Node left;
	Node right;
	int count;

	Node(int val, int count) {
		this.val = val;
		this.count = count;
	}
}

public class SmallerNumberAfterSelf {

	public static List<Integer> countSmaller(int[] a) {
		Node head = null;
		head = new Node(a[a.length - 1], 0);
		Integer r[] = new Integer[a.length];
		r[a.length - 1] = 0;
		for (int i = a.length - 2; i >= 0; i--) {
			r[i] = contructBST(head, a[i], 0);
		}
		return Arrays.asList(r);
	}

	private static int contructBST(Node head, int ai, int c) {
		if (head == null) {
			head = new Node(ai, 0);
			return c;
		}
		if (head.val < ai) {
			return head.count + contructBST(head.right, ai, c + 1);
		} else {
			head.count++;
			return contructBST(head.left, ai, c);
		}
	}

	public static void main(String[] args) {
		System.out.println(countSmaller(new int[] { 12, 1, 2, 3, 0, 11, 4 }));
	}
}
