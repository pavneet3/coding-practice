package prc.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountOccurancesOfAnagram {
	static int search(String pat, String txt) {
		int c = 0;
		Map<Character, Integer> map = new HashMap<>();
		Map<Character,Integer> st = new HashMap<>();
		for (int i = 0; i < pat.length(); i++) {
			map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
			st.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
		}
		System.out.println(map);
		for (int i = 0; i < pat.length(); i++) {
			if (map.containsKey(txt.charAt(i))) {
				if (map.get(txt.charAt(i)) == 1) {
					map.remove(txt.charAt(i));
				} else {
					map.put(txt.charAt(i), map.get(txt.charAt(i)) - 1);
				}
			}
		}
		System.out.println(map);
		for (int i = 0, j = pat.length(); j < txt.length(); i++, j++) {
			System.out.println("map for i : " + j + " map : " + map);
			if (map.isEmpty()) {
				c++;
			}
			if (st.containsKey(txt.charAt(i))) {
				if (!map.containsKey(txt.charAt(i)) || map.get(txt.charAt(i)) + 1 <= st.get(txt.charAt(i))) {
					map.put(txt.charAt(i), map.getOrDefault(map.get(txt.charAt(i)), 0) + 1);
				}
			}
			if (map.containsKey(txt.charAt(j))) {
				if (map.get(txt.charAt(j)) == 1) {
					map.remove(txt.charAt(j));
				} else {
					map.put(txt.charAt(j), map.get(txt.charAt(j)) - 1);
				}
			}
		}
		if (map.isEmpty()) {
			c++;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(search("aaba", "aabaabaa"));
	}
}
