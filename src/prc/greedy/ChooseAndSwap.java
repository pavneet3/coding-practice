package prc.greedy;

import java.util.Set;
import java.util.TreeSet;

public class ChooseAndSwap {
	static String chooseandswap(String s) {
		Set<Character> st = new TreeSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			st.add(s.charAt(i));
		}
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			st.remove(s.charAt(i));
			if (st.isEmpty()) {
				break;
			}
			if (st.stream().findFirst().get() < s.charAt(i)) {
				char c1 = st.stream().findFirst().get();
				char c2 = s.charAt(i);
				for (int j = 0; j < s.length(); j++) {
					if (sb.charAt(j) == c2) {
						sb.replace(j, j + 1, c1 + "");
						continue;
					}
					System.out.println(sb.toString());
					if (sb.charAt(j) == c1) {
						sb.replace(j, j + 1, c2 + "");
					}
				}
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(chooseandswap("abba"));
	}
}
