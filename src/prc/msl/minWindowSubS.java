package prc.msl;

import java.util.HashMap;
import java.util.Map;

public class minWindowSubS {
	public static String minWindow(String s, String t) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) + 1);
		}
		int l = m.size();
		int i = 0;
		int j = 0;
		int mx = Integer.MAX_VALUE;
		String r = "";
		while (i < s.length() && !m.containsKey(s.charAt(i))) {
			i++;
		}
		j = i;
		while (j < s.length()) {
			if (m.containsKey(s.charAt(j))) {
				m.put(s.charAt(j), m.get(s.charAt(j)) - 1);
				if (m.get(s.charAt(j)) == 0) {
					l--;
				}
			}
			System.out.println("i : " + i + " j : " + j + " l : " + l);
			if (l == 0) {
				while (mx > j - i + 1 && l == 0) {
					r = s.substring(i, j + 1);
					mx = j - i + 1;
					if (m.containsKey(s.charAt(i))) {
						m.put(s.charAt(j), m.get(s.charAt(j)) + 1);
						if (m.get(s.charAt(j)) > 0) {
							l++;
						}
					}
					i++;
				}
			}
			while (i <= j && !m.containsKey(s.charAt(i))) {
				i++;
			}
			j++;
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("aaabbbbbc", "abc"));
	}
}
