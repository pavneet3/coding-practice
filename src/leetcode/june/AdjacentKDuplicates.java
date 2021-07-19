package leetcode.june;

import java.util.Stack;

public class AdjacentKDuplicates {
	public static String removeDuplicates(String s, int k) {
		int j = 0; // 2
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder(s);
		while (j < sb.length() - 1) {
			int l = k - 1;
			int m = j;
			while (m < sb.length() - 1 && sb.charAt(m) == sb.charAt(m + 1) && l != 0) {
				l--;
				m++;
			}
			if (l == 0) {
				sb = sb.replace(j, m + 1, "");
				if (st.isEmpty()) {
					j = 0;
				} else {
					j = st.pop();
				}
			} else {
				st.push(j);
				j = m + 1;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("aaaaaaa", 2));
	}
}
