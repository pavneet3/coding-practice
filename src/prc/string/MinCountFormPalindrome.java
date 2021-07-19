package prc.string;

import java.util.HashMap;
import java.util.Map;

public class MinCountFormPalindrome {
	static int countMin(String s) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
		}
		int c = (int) m.entrySet().stream().filter(e -> e.getValue() % 2 == 1).count();
		return c == 0 ? 0 : c - 1;
	}

	public static void main(String[] args) {
		System.out.println(countMin("anasdad"));
	}

}
