package prc.st.q;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstNonRepeatingCharInStream {
	public static String FirstNonRepeating(String s) {
		LinkedHashSet<Character> hs = new LinkedHashSet<>();
		Set<Character> st = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (hs.contains(s.charAt(i))) {
				hs.remove(s.charAt(i));
			} else {
				if (!st.contains(s.charAt(i))) {
					hs.add(s.charAt(i));
					st.add(s.charAt(i));
				}
			}
			sb.append(hs.isEmpty() ? '#' : hs.stream().findFirst().get());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(FirstNonRepeating("zz"));
	}
}
