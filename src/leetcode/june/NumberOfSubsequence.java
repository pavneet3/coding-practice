package leetcode.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NumberOfSubsequence {
	public static int numMatchingSubseq(String s, String[] w) {
		Map<Character, List<String>> m = new HashMap<>();
		int v = 0;
		for (int i = 0; i < s.length(); i++) {
			m.put(s.charAt(i), new ArrayList<>());
		}
		for (String s1 : w) {
			if (s1.trim().equals("")) {
				v++;
			}
			addToMap(s1, m);
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			List<String> l = m.get(c);
			Iterator<String> il = l.iterator();
			List<String> la = new ArrayList<String>();
			while (il.hasNext()) {
				String s1 = il.next();
				if (s1.substring(1).trim().equals("")) {
					il.remove();
					v++;
				} else {
					il.remove();
					if (s1.length() > 1) {
						if (s1.charAt(0) == s1.charAt(1)) {
							la.add(s1.substring(1));
						} else {
							addToMap(s1.substring(1), m);
						}
					}
				}
			}
			l.addAll(la);
		}
		return v;
	}

	private static void addToMap(String s1, Map<Character, List<String>> m) {
		char c = s1.charAt(0);
		List<String> l = m.getOrDefault(c, new ArrayList<>());
		l.add(s1);
		m.put(c, l);
	}

	public static void main(String[] args) {
		System.out.println(numMatchingSubseq("abcade", new String[] { "a", "bb", "acd", "ace", "aad" }));
	}

}
