package prc.string;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeating {

	public static int lengthOfLongestSubstring(String s) {
		int i = 0;
		int j = 0;
		Set<Character> st = new HashSet<>();
		int m = 0;
		while (j < s.length()) {
			if (st.contains(s.charAt(j))) {
				while (i < s.length() && !st.isEmpty() && st.contains(s.charAt(j))) {
					st.remove(s.charAt(i++));
				}
			}
			st.add(s.charAt(j));
			m = Math.max(j - i + 1, m);
			j++;
		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aaa"));
	}

}
