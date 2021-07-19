package prc.string;

import java.util.HashMap;

public class Anagram {
	public static boolean isAnagram(String a, String b) {
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		if (a.length() != b.length()) {
			return false;
		}
		for (int i = 0; i < a.length(); i++) {
			m.put(a.charAt(i), m.getOrDefault(a.charAt(i), 0) + 1);
		}
//		System.out.println(m);
		for (int i = 0; i < b.length(); i++) {
			if (m.containsKey(b.charAt(i))) {
				int c = m.get(b.charAt(i));
				if (c == 1) {
					m.remove(b.charAt(i));
				} else {
					m.put(b.charAt(i), c - 1);
				}
			} else {
				return false;
			}
		}

		return m.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("geeksforgeeks", "forgeeksgeeks"));
	}
}
