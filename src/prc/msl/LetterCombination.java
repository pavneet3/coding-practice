package prc.msl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

	static Map<Character, String> m = new HashMap<>();
	static {
		m.put('2', "abc");
		m.put('3', "def");
		m.put('4', "ghi");
		m.put('5', "jkl");
		m.put('6', "mno");
		m.put('7', "pqrs");
		m.put('8', "tuv");
		m.put('9', "wxyz");
	}

	public static List<String> letterCombinations(String digits) {
		List<String> all = new ArrayList<String>();
		for (int i = 0; i < digits.length(); i++) {
			all.add(m.get(digits.charAt(i)));
		}
		List<String> r = new ArrayList<String>();
		getListByR(all, 0, r, "");
		return r;
	}

	private static void getListByR(List<String> all, int i, List<String> r, String s) {
		if (i >= all.size() && !s.isBlank()) {
			r.add(s);
			return;
		}
		for (int j = 0; j < all.get(i).length(); j++) {
			String s1 = s + all.get(i).charAt(j);
			getListByR(all, i + 1, r, s1);
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
}
