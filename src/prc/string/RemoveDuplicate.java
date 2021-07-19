package prc.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
	String removeDups(String s) {
		StringBuilder sb = new StringBuilder();
		Set<Character> st = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!st.contains(s.charAt(i))) {
				sb.append(s.charAt(i));
				st.add(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
